package com.janakerman.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Configuration for  application wide security.
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String REALM = "coffee"

    private final UserDetailsService userDetailsService

    @Autowired
    WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService
    }

    @Bean
    PasswordEncoder bCryptPasswordEncoder() { new BCryptPasswordEncoder() }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // Set the user details service, essentially just a DAO for our user credentials.
                .userDetailsService(userDetailsService)
                // Tell spring what we've already used to encode the password in our database, so it can re-encode for equality checks
                .passwordEncoder(bCryptPasswordEncoder())
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            /* CSRF - Cross Site Request Forgery -
                A type of attack whereby a user opens a session with a server, then also navigates to a malicious page, that also makes
                a request to the server on the same browser. Due to session info being stored in cookies, and cookies automatically
                being sent with requests, the request contains the correct session ID.

                CSRF protection uses the Synchronizer Token Pattern. Whereby a unique token is sent by the server, and subsequently sent
                by the client with each request. The idea is that this is only sent for sensitive operations, and because it isn't
                automatically sent by the browser, the service is now protected from CSRF. Although this token is sent in plain text,
                it's risk is analogous to the attacker knowing the session ID.

                Turn this off because Http Basic isn't using sessions.
             */
            .csrf().disable()
            // Authorize all requests to this service.
            .authorizeRequests().anyRequest().authenticated()
                .and()
                    /* HTTP Basic is a protocol that requires the auth info to be sent on every request. */
                    .httpBasic()
                    // The realm (namespace?) that this authentication corresponds to (allows different auth for different areas?).
                    .realmName(REALM)
                    // Set a handler for unauthorized requests - no idea why this is named as it is - implies otherwise.
                    .authenticationEntryPoint(authEntryPoint())
                .and()
                    .sessionManagement()
                    // Http Basic doesn't require state.
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
    }

    static CustomBasicAuthenticationEntryPoint authEntryPoint() {
        def entryPoint = new CustomBasicAuthenticationEntryPoint()
        entryPoint.setRealmName(REALM)
        return entryPoint
    }
}
