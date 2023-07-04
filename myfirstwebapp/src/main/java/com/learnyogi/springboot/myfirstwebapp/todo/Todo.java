package com.learnyogi.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Todo {

    public Todo(){

    }

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done, LocalTime remainingTime) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
        this.remainingTime = remainingTime;
    }
    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=10,message = "Enter minimum 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
    private LocalTime remainingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetData) {
        this.targetDate = targetData;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalTime getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(LocalTime remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + done +
                ", remainingTime=" + remainingTime +
                '}';
    }
}
