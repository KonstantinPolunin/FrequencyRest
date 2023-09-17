package com.example.itconsult.service;

import com.example.itconsult.model.Text;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FrequencyService {

    public Text jsonParsing(String string) {
        Text text = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            text = objectMapper.readValue(string, Text.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public Map<Character, Integer> calculateFrequency(String string) {
        /*String fieldValue = null;

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

*/
        Map<Character, Integer> frequencyMap = new HashMap<>();
        assert jsonParsing(string).getText() != null;
        for (char c : jsonParsing(string).getText().toCharArray()) {
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
