package com.springboottest.controllers;

import com.springboottest.model.Details;
import com.springboottest.model.Errors;
import com.springboottest.model.TodoItem;
import com.springboottest.service.AgtestService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This is for processing todo action items. It process three actions
 * Used google gson for json conversions
 */
@RestController
public class TodoPostcontroller {
    private final static int InValidData=400;
    private final static int InternalException=500;
    private final static int NotFound=404;
    private AtomicInteger value = new AtomicInteger();
    private Gson gson = new Gson();
    private Map mapValues = new HashMap<Integer, TodoItem>();

    /*
    Todo post method
    First convert string to json and then check validations
    if validations fail return status 400 and error details
    if exception status 500 and error details
     */
    @RequestMapping(value = "/todo", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    public String todoPost(@RequestBody String incomeStr, HttpServletResponse httpServletResponse) {
        try {
            if((incomeStr==null)&&(incomeStr.equals("")))
            {
                httpServletResponse.setStatus(InValidData);
                return AgtestService.getErrorDetails(incomeStr);
            }
            TodoItem todoItemtemp = gson.fromJson(incomeStr, TodoItem.class);
            incomeStr = todoItemtemp.getText();
            if ((null != incomeStr) && (incomeStr.length() > 0) && (incomeStr.length() < 50)) {
                int id = value.incrementAndGet();
                TodoItem todoItem = new TodoItem(id, incomeStr, AgtestService.doValidateMatchingTag(incomeStr), new Date());
                mapValues.put(id, todoItem);
                return gson.toJson(todoItem);
            } else {
                httpServletResponse.setStatus(InValidData);
                return AgtestService.getErrorDetails(incomeStr);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(InternalException);
            return AgtestService.getErrorDetails(incomeStr);
        }
    }

    /*
    Todo get Method
    This is to just get informationn based on id in map
     */
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    public String todoGet(@PathVariable int id, HttpServletResponse httpServletResponse) {
        try {
            TodoItem todoItem = (TodoItem) mapValues.get(id);
            if (todoItem != null)
                return gson.toJson(todoItem);
            else {
                httpServletResponse.setStatus(NotFound);
                Details details = new Details("Item with " + id + " not found");
                return gson.toJson(new Errors(new Details[]{details}, "NotFoundError"));
            }
        }
        catch(Exception e)
        {
            httpServletResponse.setStatus(InternalException);
            return AgtestService.getErrorDetails(new Integer(id).toString());
        }
    }

    /*
    Todo Patch method
    First convert string to json and then check validations
    if validations fail return status 400 and error details
    then it will patch the details by getting an existing string.
     */
    @RequestMapping(value = "/todo", method = RequestMethod.PATCH,produces={"application/json; charset=UTF-8"})
    public String todoPatch(@RequestParam int id, @RequestBody String str, HttpServletResponse httpServletResponse) {
        try {
            if((str==null)&&(!str.equals("")))
            {
                httpServletResponse.setStatus(InValidData);
                return AgtestService.getErrorDetails(str);
            }
            TodoItem todoItem = gson.fromJson(str, TodoItem.class);
            if ((null != todoItem)) {
                if (todoItem.getText() != null)
                    if (!(todoItem.getText().length() > 0) && (todoItem.getText().length() < 50)) {
                        httpServletResponse.setStatus(InValidData);
                        return AgtestService.getErrorDetails(todoItem.getText());
                    }
                TodoItem todoItemfound = (TodoItem) mapValues.get(id);
                if (todoItemfound != null) {
                    patchit(todoItemfound, todoItem);
                    mapValues.put(id, todoItemfound);
                    return gson.toJson(todoItemfound);
                } else {
                    httpServletResponse.setStatus(NotFound);
                    Details details = new Details("Item with " + id + " not found");
                    return gson.toJson(new Errors(new Details[]{details}, "NotFoundError"));
                }
            } else {
                httpServletResponse.setStatus(NotFound);
                return AgtestService.getErrorDetails(str);
            }
        } catch (Exception e) {
            httpServletResponse.setStatus(InternalException);
            return AgtestService.getErrorDetails(str);
        }

    }

    /*
    This method to help  patching values between objects
     */
    private void patchit(TodoItem todoItem, TodoItem todoItemtemp) {
        if (todoItemtemp.getText() != null)
            todoItem.setText(todoItemtemp.getText());
        if (todoItemtemp.getCreatedAt() != null)
            todoItem.setCreatedAt(todoItemtemp.getCreatedAt());
        if (todoItemtemp.getCompleted() != null)
            todoItem.setCompleted(todoItemtemp.getCompleted());
    }


}

