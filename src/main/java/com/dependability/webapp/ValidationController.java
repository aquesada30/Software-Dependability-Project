package com.dependability.webapp;

import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.math.NumberUtils;

@RestController
@RequestMapping("/validate")
public class ValidationController {

    /**
     * Endpoint: /validate/isNumeric?input=123.45
     * Devuelve "true"/"false" si la cadena es interpretable como número.
     */
    @GetMapping("/isNumeric")
    public String isNumeric(@RequestParam String input) {
        return Boolean.toString(NumberUtils.isCreatable(input));
    }
}
