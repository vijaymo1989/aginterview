package com.springboottest.model;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This is for error details json model
 */
public class Errors {
    private Details details[];
    private String name;

    public Details[] getDetails() {
        return details;
    }

    public void setDetails(Details[] details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Errors(Details details[],String name)
    {
        this.details=details;
        this.name=name;
    }
}
