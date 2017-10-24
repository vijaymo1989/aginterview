package com.springboottest.controllers;


import com.springboottest.model.ValidateBrackets;
import com.springboottest.service.AgtestService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This is for validating string for matching braces
 * Used google gson for json conversions
 */
@RestController("/tasks")
public class ValidateBracketsController {
    Gson gson = new Gson();


    @RequestMapping(value="/tasks/validateBrackets",produces={"application/json; charset=UTF-8"})
    public String greeting(@RequestParam(value = "input") String name, HttpServletResponse response) {
        try {
            if ((null != name) && (name.length() > 0) && name.length() < 50) {
                boolean validate = AgtestService.doValidateMatchingTag(name);
                return gson.toJson(new ValidateBrackets(name, validate));
            } else {
                response.setStatus(400);
                return AgtestService.getErrorDetails(name);
            }
        } catch (Exception e) {
            response.setStatus(500);
            return AgtestService.getErrorDetails(name);
        }
    }
}



