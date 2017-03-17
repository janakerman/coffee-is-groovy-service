package com.janakerman.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType

import java.nio.charset.Charset


class TestUtil {
    static String toJsonString(obj) { (new ObjectMapper()).writeValueAsString(obj) }
}
