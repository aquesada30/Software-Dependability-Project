package com.dependability.webapp;

import com.dependability.webapp.service.UtilityService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityControllerUnitTest {

    private final UtilityService service = new UtilityService();
    private final UtilityController ctrl = new UtilityController(service);

    @Test
    void isNumeric_endpoint_directCall() {
        assertTrue(ctrl.isNumeric("123"));
        assertFalse(ctrl.isNumeric("12a"));
    }

    @Test
    void randomString_endpoint_directCall() {
        var ok = ctrl.randomString(5);
        assertEquals(200, ok.getStatusCode().value());
        assertEquals(5, ok.getBody().length());

        var bad = ctrl.randomString(-10);
        assertEquals(400, bad.getStatusCode().value());
        assertTrue(bad.getBody().contains("Invalid length"));
    }
}
