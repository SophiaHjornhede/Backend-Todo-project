package com.example.todo.entity;

//import com.example.todo.controller.ItemController;
//import com.example.todo.repository.ItemRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String todos;
    private boolean condition;

    public Item(String todos) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

 /*

    @Override
    public String toString() {
        return "Item{" + "id=" + id +
                "todos=" + todos + '\'' +
                ", condition=" + condition +
                '}';
    }

    */
}
