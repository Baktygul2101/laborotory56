package com.example.task.dto;

import java.util.Date;

public class Answer {
    private String id;
    private String result;

    public Answer(String result) {
        this.id = Long.toString(new Date().getTime());
        this.result = result;
    }

    public Answer(String id, String result) {
        this.id = id;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
