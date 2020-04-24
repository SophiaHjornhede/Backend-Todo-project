package com.example.todo.entity;

import java.util.ArrayList;

public class List {
    private ArrayList<Item> todoList = new ArrayList<>();

    public List(){}

    public List(ArrayList<Item> todoList) {this.todoList = todoList;}

    public ArrayList<Item> getTodoList() {return todoList;}

    public void setTodoList(ArrayList<Item> todoList){this.todoList = todoList;}
}
