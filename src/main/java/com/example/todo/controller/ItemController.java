package com.example.todo.controller;

import com.example.todo.entity.Item;
import com.example.todo.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemRepository itemRepository;

    @GetMapping("/all")
    public List<Item> allItems(){
        return itemRepository.findAll();
    }
}
