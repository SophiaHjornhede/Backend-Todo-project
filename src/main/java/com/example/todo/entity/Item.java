package com.example.todo.entity;

import javax.persistence.*;
import java.util.Objects;

//the todo-database is build up with it's entities
@Entity
@Table(name = "db_todo")
public class Item {

	//generate unique ids 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //generate todos 
    @Column(name = "todos", nullable = false, length = 255)
    private String todos;

    //generate todo conditions
    @Column(name = "completed", nullable = false)
    private boolean completed;

    
    public Item() {
    }

    public Item(String todos) {
        this.todos = todos;
        this.completed = false;
    }

    public Item(String todos, boolean done) {
        this.todos = todos;
        this.completed = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
 

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    }

