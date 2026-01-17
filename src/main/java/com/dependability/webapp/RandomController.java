package com.dependability.webapp;

import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;

@RestController
@RequestMapping("/random")
public class RandomController {

    /**
     * @requires length >= 0 && length <= 1024;
     * @ensures \result != null;
     * @ensures \result.length() == length;
     * @ensures (\result.length() == 0) ==> (length == 0);
     * @ensures (\forall int i; 0 <= i && i < \result.length();
     *              letters || numbers);
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
