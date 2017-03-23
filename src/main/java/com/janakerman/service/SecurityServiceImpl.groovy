package com.janakerman.service

import org.apache.log4j.spi.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

import java.util.logging.Logger

@Service
class SecurityServiceImpl implements SecurityService {

    private final AuthenticationManager authManager
    private final UserDetailsService userDetailsService

    @Autowired
    SecurityServiceImpl(AuthenticationManager authManager, UserDetailsService userDetailsService) {
        this.authManager = authManager
        this.userDetailsService = userDetailsService
    }

    @Override
    String findLoggedInUsername() {
        def userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails()

        if (!userDetails instanceof UserDetails) {
            return null
        }

        return ((UserDetails)userDetails).getUsername()
    }

    @Override
    boolean autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username)
        def token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities())

        try {
            authManager.authenticate(token)
        } catch (AuthenticationException e) {
            println "Auto login $username failed!"
            return false
        }

        SecurityContextHolder.getContext().setAuthentication(token)
        println "Auto login $username successfully!"
        return true
    }
}
