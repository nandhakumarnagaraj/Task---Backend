package com.financial.sync.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class StatusController {

    @GetMapping
    public Map<String, Object> getStatus() {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "OK");
        response.put("timestamp", Instant.now().toString());
        response.put("message", "Appointment Booking API is running");

        return response;
    }
}

