package com.dependability.webapp;

import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

@RestController
@RequestMapping("/random")
public class RandomController {

    /**
     * Endpoint: /random/string?length=8&letters=true&numbers=true
     * Genera una cadena aleatoria con Commons Lang.
     */
    @GetMapping("/string")
    public String randomString(
            @RequestParam int length,
            @RequestParam(defaultValue = "true") boolean letters,
            @RequestParam(defaultValue = "true") boolean numbers) {

        if (length < 0 || length > 1024) {
            throw new IllegalArgumentException("length must be between 0 and 1024");
        }
        return RandomStringUtils.random(length, letters, numbers);
    }
}
