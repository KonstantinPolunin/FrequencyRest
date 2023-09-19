package com.example.itconsult;

import com.example.itconsult.controller.FrequencyRestController;
import com.example.itconsult.model.Text;
import com.example.itconsult.service.FrequencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FrequencyRestController.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ItConsultApplicationTests {
    private final MockMvc mock;
    @MockBean
    private final FrequencyService service;
    private final ObjectMapper mapper;
    private ResultActions response;

    @Test
    void sendTextPositiveTest() throws Exception {
        Text text = new Text("IT test");

        response = mock.perform(post("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(text)))
                .andExpect(status().isOk());
    }


}
