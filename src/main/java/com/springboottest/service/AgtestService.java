package com.springboottest.service;

import com.google.gson.Gson;
import com.springboottest.model.Details;
import com.springboottest.model.Errors;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * this is service class to do operations
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AgtestService {
    private static final Gson gson = new Gson();
    /*
    This is to check validation of brackets with the help of Map
     */
    public static boolean doValidateMatchingTag(String str) {
        Map<Character, Character> openClosePair = new HashMap<Character, Character>();
        openClosePair.put('(', ')');
        openClosePair.put('{', '}');
        openClosePair.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            if (openClosePair.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));

            } else if (openClosePair.containsValue(str.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                if (openClosePair.get(stack.pop()) != str.charAt(i))
                    return false;
            }
            // ignore all other characters
        }
        return stack.isEmpty();
    }


    /*
    This is to give error details by getting message from properties.
     */
    public static String getErrorDetails(String str) {
        Details details = new Details("params", "text","Must be between 1 and 50 chars long", str);
        return gson.toJson(new Errors(new Details[]{details}, "ValidationError"));
    }


}
