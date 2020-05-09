package com.example.todo.controller;

import com.example.todo.entity.Item;
import com.example.todo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.stream.StreamSupport;


@Controller
@RequestMapping("/api")

public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    private ItemController(ItemRepository itemRepository){this.itemRepository = itemRepository;}

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView M = new ModelAndView("welcome");
        M.addObject("text", "Welcome your Todo Application!");
        return M;
    }

    @GetMapping("/getItem")
    public @ResponseBody Optional<Item> getinfo(@RequestParam long id) {
        return itemRepository.findById(id);
    }

    @DeleteMapping("/deleteItem")
    public @ResponseBody String deletePost(@RequestParam long id) {
        itemRepository.deleteById(id);
        return "deleted";
    }

    @PostMapping("/addItem")
    public @ResponseBody String addTodoItems(@RequestParam String content) {
        Item todo = new Item(content);
        itemRepository.save(todo);
        return "Stored Todo";
    }

    @PostMapping("/")
    public @ResponseBody String createNewItems(Item todo) {
        itemRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping(path = "/allItems")
    public @ResponseBody Iterable<Item> getAllTodos() {
        return itemRepository.findAll();
    }

    @GetMapping(path = "/howManyInTotal")
    public @ResponseBody long totalNumbers() {
        return itemRepository.count();
    }

    @GetMapping(path = "/activeItems")
    public @ResponseBody Iterable<Item> getAllActive(Model model) {
        return itemRepository.findByCondition(false);
    }

    @GetMapping(path = "/completeItems")
    public @ResponseBody Iterable<Item> getAllComplete(Model model) {
        return itemRepository.findByCondition(true);
    }

    @RequestMapping("/")
    public @ResponseBody String indexNew(Model model) {
        return "indexNew";
    }


    @RequestMapping("/changeOneTodo")
    public @ResponseBody String changeOneTodo(@RequestParam long id) {
        Item todo = itemRepository.findById(id).orElse(null);
        boolean completed = todo.getComplete();
        todo.setComplete(!completed);
        itemRepository.save(todo);
        return"Change todo status";
    }

    @GetMapping("/changeAllstatus")
    public @ResponseBody String changeAllTodos() {
        Iterable<Item> elements= itemRepository.findAll();
        Iterable<Item> elementsCompleted= itemRepository.findByCondition(true);

        if(StreamSupport.stream(elements.spliterator(), false).count() == StreamSupport.stream(elementsCompleted.spliterator(), false).count()) {
            {
                for(Item element:elements) {
                    element.setComplete(false);
                    itemRepository.save(element);
                }
            }
            return "Setting false";
        }
        else
            for(Item element:elements) {

                element.setComplete(true);
                itemRepository.save(element);
            }
            return"Setting true";
        }

}