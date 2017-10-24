package com.springboottest.model;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This is for validate bracket json model
 */
public class ValidateBrackets {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        return isBalanced;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }

    private boolean isBalanced;

    public ValidateBrackets(String input,boolean isBalanced)
    {
        this.input=input;
        this.isBalanced=isBalanced;
    }

}
