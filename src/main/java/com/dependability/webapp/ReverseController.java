package com.dependability.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
public class ReverseController {

    @GetMapping("/reverse")
    public String reverse(@RequestParam String input) {
        return StringUtils.reverse(input);
    }
}
