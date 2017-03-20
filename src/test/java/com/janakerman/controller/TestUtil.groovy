package com.janakerman.controller

import com.fasterxml.jackson.databind.ObjectMapper

class TestUtil {
    static String toJsonString(obj) { (new ObjectMapper()).writeValueAsString(obj) }
}
