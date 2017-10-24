package com.springboottest.model;

import java.util.Date;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This if for incoming json
 */
public class TodoItem {
    private int id;
    private String text;
    private Boolean isCompleted;
    private Date createdAt;

    public TodoItem(int id, String text, boolean isCompleted, Date date) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
        this.createdAt = date;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
