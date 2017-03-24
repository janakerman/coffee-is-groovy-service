package com.janakerman.auth

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Seems to be a handler for unauthorized requests. No idea why the base class is named in such a misleading way?
 */
class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    /**
     * Overrides the default implementation of redirecting the client to a login page when not authentication.
     *
     * We're using HttpBasic - there is no login page.
     */
    @Override
    void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Authentication has failed, send error.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
        response.addHeader('WWW-Authenticate', "Basic realm=${getRealmName()}")
        response.getWriter().println "HTTP Status 401  : ${authException.getMessage()}"
    }

}
