package com.example.todo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.todo.entity.Item;
import com.example.todo.controller.ItemController;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface ItemRepository extends CrudRepository<Item,Integer>{
}
