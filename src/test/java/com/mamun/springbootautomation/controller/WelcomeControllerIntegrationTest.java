package com.mamun.springbootautomation.controller;

import com.mamun.springbootautomation.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class WelcomeControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WelcomeService welcomeService;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {

        when(welcomeService.getWelcomeMessage("Xyz")).thenReturn("Welcome Xyz!");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome Xyz!")));

        verify(welcomeService).getWelcomeMessage("Xyz");

    }


    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {

        when(welcomeService.getWelcomeMessage("Mamun")).thenReturn("Welcome Mamun!");
        mockMvc.perform(get("/welcome?name=Mamun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome Mamun!")));

        verify(welcomeService).getWelcomeMessage("Mamun");

    }



}