package com.springboottest.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Vijay.Ramineni on 24/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidateBracketsControllerTest {
    @InjectMocks
    ValidateBracketsController validateBracketsController;
    @Test
    public void greeting() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(validateBracketsController).build();
        String inputString="JHJHJHdffhg";
        mockMvc.perform(get("/tasks/validateBrackets?input={inputString}",inputString)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

}