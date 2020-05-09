package com.example.todo.bussinessLogic;

import com.example.todo.entity.Item;

import java.util.ArrayList;

public class ViewList {

    private ArrayList<Item> todoList = new ArrayList<>();

    public ViewList(){}

    public ViewList(ArrayList<Item> todoList) {this.todoList = todoList;}

    public ArrayList<Item> getTodoList() {return todoList;}

    public void setTodoList(ArrayList<Item> todoList){this.todoList = todoList;}

}
