package com.dependability.webapp;

import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.math.NumberUtils;

@RestController
@RequestMapping("/validate")
public class ValidationController {

    /**
     * @requires input != null;
     * @ensures \result.equals("true") || \result.equals("false");
     * @ensures (\result.equals("true") <==> org.apache.commons.lang3.math.NumberUtils.isCreatable(input));
     */
    @GetMapping("/isNumeric")
    public String isNumeric(@RequestParam String input) {
        return Boolean.toString(NumberUtils.isCreatable(input));
    }
}
