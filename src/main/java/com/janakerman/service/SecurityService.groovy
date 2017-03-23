package com.janakerman.service

interface SecurityService {
    String findLoggedInUsername()
    boolean autoLogin(String username, String password)
}
