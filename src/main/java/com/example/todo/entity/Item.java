package com.example.todo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private String todos;
    private String condition;

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public String isCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Item{" +
                "todos='" + todos + '\'' +
                ", condition=" + condition +
                '}';
    }
}
