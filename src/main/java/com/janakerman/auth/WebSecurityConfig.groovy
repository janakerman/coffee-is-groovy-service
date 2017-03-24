package com.janakerman.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

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
            // TODO: Find out what this means.
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
                    // TODO: Find out what this means.
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // We don't need sessions to be created (why?)
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
