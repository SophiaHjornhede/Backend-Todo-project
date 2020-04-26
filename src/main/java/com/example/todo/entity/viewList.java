package com.example.todo.entity;

import java.util.ArrayList;

public class viewList {
    private ArrayList<Item> todoList = new ArrayList<>();

    public viewList(){}

    public viewList(ArrayList<Item> todoList) {this.todoList = todoList;}

    public ArrayList<Item> getTodoList() {return todoList;}

    public void setTodoList(ArrayList<Item> todoList){this.todoList = todoList;}
}
