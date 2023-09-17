package com.example.itconsult.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FrequencyRestController {

    @PostMapping("/api/frequency")
    public Map<Character, Integer> calculateFrequency(@RequestBody String text) {
        String fieldValue = null;

        try {
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(text);

            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (jsonToken == JsonToken.FIELD_NAME) {
                    parser.nextToken();
                    fieldValue = parser.getText();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        assert fieldValue != null;
        for (char c : fieldValue.toCharArray()) {
            if (c != ' ') {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
