package com.dependability.webapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

class ReverseControllerTest {

    @Test
    void testReverse() {
        assertEquals("aloh", StringUtils.reverse("hola"));
    }

    @Test
    void testReverseEmpty() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void testReverseNull() {
        // StringUtils.reverse(null) devuelve null
        assertEquals(null, StringUtils.reverse(null));
    }
}
