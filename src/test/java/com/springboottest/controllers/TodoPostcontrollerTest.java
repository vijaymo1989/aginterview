package com.springboottest.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Vijay.Ramineni on 24/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TodoPostcontrollerTest {
    @InjectMocks
    TodoPostcontroller todoPostcontroller;
    @Test
    public void todoPost() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(todoPostcontroller).build();
        String inputString="{\n" +
                "  \"text\": \"Uulwi ifis halahs gag erh'ongg w'ssh.\"\n" +
                "}";
        mockMvc.perform(post("/todo").content(inputString)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));


    }

    @Test
    public void todoGet() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(todoPostcontroller).build();
        String inputString1="1";
        mockMvc.perform(get("/todo/{id}", inputString1)
        ).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json("{\"details\":[{\"message\":\"Item with 1 not found\"}],\"name\":\"NotFoundError\"}"));

    }

    @Test
    public void todoPatch() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(todoPostcontroller).build();
        String inputString="{\n" +
                "  \"text\": \"Uulwi ifis halahs gag erh'ongg w'ssh.\"\n" +
                "}";
        String inputString2="{\n" +
                "  \"text\": \"Uulwi ifis hgfshgfhsfhsgfhs gag erh'ongg w'ssh.\"\n" +
                "}";
        mockMvc.perform(post("/todo").content(inputString)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        String inputString1="1";
        mockMvc.perform(patch("/todo?id={id}", inputString1).content(inputString2)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void integrationTest() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(todoPostcontroller).build();
        String inputString="{\n" +
                "  \"text\": \"Uulwi ifis halahs gag erh'ongg w'ssh.\"\n" +
                "}";
        mockMvc.perform(post("/todo").content(inputString)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        String inputString1="1";
        mockMvc.perform(get("/todo/{id}", inputString1)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        String inputString2="{\n" +
                "  \"text\": \"Uulwi ifis hgfshgfhsfhsgfhs gag erh'ongg w'ssh.\"\n" +
                "}";
        mockMvc.perform(patch("/todo?id={id}", inputString1).content(inputString2)
        ).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));


    }
}