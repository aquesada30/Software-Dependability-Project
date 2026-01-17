package com.dependability.webapp;

import com.dependability.webapp.service.UtilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UtilityController {

    private final UtilityService service;

    public UtilityController(UtilityService service) {
        this.service = service;
    }

   
    @GetMapping("/isNumeric")
    public boolean isNumeric(@RequestParam String value) {
        return service.isNumeric(value);
    }

 
    @GetMapping("/randomString")
    public ResponseEntity<String> randomString(@RequestParam int length) {
        try {
            return ResponseEntity.ok(service.randomString(length));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid length: " + ex.getMessage());
        }
    }
}
