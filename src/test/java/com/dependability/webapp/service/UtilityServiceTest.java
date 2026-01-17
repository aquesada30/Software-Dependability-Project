package com.dependability.webapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilityServiceTest {

    private final UtilityService service = new UtilityService();

    @Test
    void isNumeric_basicCases() {
        assertTrue(service.isNumeric("123"));
        assertTrue(service.isNumeric("-12.3"));
        assertTrue(service.isNumeric("1e10"));
        assertFalse(service.isNumeric(""));
        assertFalse(service.isNumeric("  "));
        assertFalse(service.isNumeric("12a"));
        assertFalse(service.isNumeric(null));
    }

    @Test
    void randomString_validLengths() {
        assertEquals("", service.randomString(0));
        String s10 = service.randomString(10);
        assertEquals(10, s10.length());
        assertTrue(s10.matches("[A-Za-z0-9]+"));
    }

    @Test
    void randomString_invalidLengths() {
        assertThrows(IllegalArgumentException.class, () -> service.randomString(-1));
        assertThrows(IllegalArgumentException.class, () -> service.randomString(2048));
    }
}
