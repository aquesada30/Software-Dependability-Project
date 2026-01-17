package com.dependability.webapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RandomControllerTest {

    @Test
    void randomString_basic() {
        RandomController c = new RandomController();
        String s = c.randomString(8, true, true);
        assertNotNull(s);
        assertEquals(8, s.length());
    }

    @Test
    void randomString_letters_only() {
        RandomController c = new RandomController();
        String s = c.randomString(5, true, false);
        assertTrue(s.matches("[A-Za-z]{5}"));
    }

    @Test
    void randomString_numbers_only() {
        RandomController c = new RandomController();
        String s = c.randomString(4, false, true);
        assertTrue(s.matches("\\d{4}"));
    }

    @Test
    void randomString_invalid_length() {
        RandomController c = new RandomController();
        assertThrows(IllegalArgumentException.class, () -> c.randomString(-1, true, true));
        assertThrows(IllegalArgumentException.class, () -> c.randomString(2048, true, true));
    }
}
