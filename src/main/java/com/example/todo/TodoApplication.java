package com.example.todo;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.todo.entity.Item;

import java.util.ArrayList;
import javax.validation.Valid;


//@SpringBootApplication
public class TodoApplication {

    @Valid
    private ArrayList<Item> todoList = new ArrayList<Item>();

    public TodoApplication(){}

    public TodoApplication(ArrayList<Item> todoList){
        this.todoList = todoList;
    }
    public ArrayList<Item> getTodoList(){
        return todoList;
    }

    public void setTodoList(ArrayList<Item> todoList){
        this.todoList = todoList;
    }
    /*public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

     */

}
