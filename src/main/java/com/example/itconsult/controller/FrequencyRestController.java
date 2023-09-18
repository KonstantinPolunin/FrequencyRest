package com.example.itconsult.controller;

import com.example.itconsult.service.FrequencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrequencyRestController {
    private final FrequencyService service;

    public FrequencyRestController(FrequencyService service) {
        this.service = service;
    }

    @PostMapping("/api/frequency")
    public ResponseEntity calculateFrequency(@RequestBody String text) {
        return new ResponseEntity<>(service.calculateFrequency(text), HttpStatus.OK);

    }

}
