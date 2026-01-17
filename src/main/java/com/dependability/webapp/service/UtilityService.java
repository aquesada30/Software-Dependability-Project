package com.dependability.webapp.service;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

    
    public boolean isNumeric(String value) {
        if (value == null) return false;
        return NumberUtils.isCreatable(value.trim());
    }

    
    public String randomString(int length) {
        if (length < 0 || length > 1024) {
            throw new IllegalArgumentException("length must be between 0 and 1024");
        }
        if (length == 0) return "";
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
