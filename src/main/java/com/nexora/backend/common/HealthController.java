package com.nexora.backend.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public String health() {
        return "Nexora backend is running";
    }
}