package com.dependability.webapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ValidationControllerTest {

    @Test
    void isNumeric_true_cases() {
        ValidationController c = new ValidationController();
        assertEquals("true", c.isNumeric("123"));
        assertEquals("true", c.isNumeric("12.3"));
        assertEquals("true", c.isNumeric("-0.5"));
        assertEquals("true", c.isNumeric("1e6"));
    }

    @Test
    void isNumeric_false_cases() {
        ValidationController c = new ValidationController();
        assertEquals("false", c.isNumeric("abc"));
        assertEquals("false", c.isNumeric("12a"));
        assertEquals("false", c.isNumeric(""));
        assertEquals("false", c.isNumeric(" "));
    }
}
