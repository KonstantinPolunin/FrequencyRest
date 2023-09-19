package com.example.itconsult.controller;

import com.example.itconsult.service.FrequencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FrequencyRestController {
    private final FrequencyService service;

    public FrequencyRestController(FrequencyService service) {
        this.service = service;
    }

    @PostMapping("/api/frequency")
    public ResponseEntity<Map<Character, Integer>> calculateFrequency(@RequestBody String text) {
        return ResponseEntity.ok(service.calculateFrequency(text));
    }

}
