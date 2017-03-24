package com.janakerman.auth

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

    @Override
    void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Authentication has failed, send error.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
        response.addHeader('WWW-Authenticate', "Basic realm=${getRealmName()}")
        response.getWriter().println "HTTP Status 401  : ${authException.getMessage()}"
    }

}
