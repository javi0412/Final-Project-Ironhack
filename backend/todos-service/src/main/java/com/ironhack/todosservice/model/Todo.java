package com.ironhack.todosservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date creationDate;
    private String description;
    private Date dueDate;
    private boolean isDone;

    public Todo(Date creationDate, String description, Date dueDate, boolean isDone) {
        this.creationDate = new Date();
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = isDone;
    }

    public Todo(Integer id, Date creationDate, String description, Date dueDate, boolean isDone) {
        this.id = id;
        this.creationDate = new Date();
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = isDone;
    }

    public Todo() {
        this.creationDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
