package com.mamun.springbootautomation.controller;

import com.mamun.springbootautomation.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {

    @Test
    void shouldWelcome() {

        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelcomeMessage("Jon")).thenReturn("Welcome Jon!");
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        assertEquals("Welcome Jon!", welcomeController.welcome("Jon"));

    }
}