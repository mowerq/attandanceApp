package com.example.attandanceapp;

public class Members {
    private String name;
    private int attandence;

    public Members(String name) {
        this.name = name;
        this.attandence = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttandence() {
        return attandence;
    }

}
