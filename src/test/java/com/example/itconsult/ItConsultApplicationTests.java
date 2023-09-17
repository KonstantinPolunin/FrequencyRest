package com.example.itconsult;

import com.example.itconsult.controller.FrequencyRestController;
import com.example.itconsult.model.Text;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(FrequencyRestController.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItConsultApplicationTests {

    private final MockMvc mockMvc;
    @MockBean
    private final ObjectMapper objectMapper;

    @Test
    public void contextLoads() throws Exception {
        Text text = new Text("ItConsult");
        mockMvc.perform(post("/api/frequency")
                        .content(objectMapper.writeValueAsString(text))
                        .contentType(MediaType.APPLICATION_JSON)
        );

    }

}
