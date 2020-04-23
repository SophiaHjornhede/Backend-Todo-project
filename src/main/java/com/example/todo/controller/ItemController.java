package com.example.todo.controller;

import com.example.todo.TodoApplication;
import com.example.todo.entity.Item;
import com.example.todo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

/*import javax.annotation.Resource;
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
*/

@Controller
//@RequestMapping(path="/todo")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(Model model) {
        ArrayList<Item> todoList = (ArrayList<Item>) itemRepository.findAll();
        model.addAttribute("newitem", new Item());
        model.addAttribute("items", new TodoApplication(todoList));
        return "index";
    }

    @RequestMapping("/add")
    public String addTodo(@ModelAttribute Item requestItem) {
        Item item = new Item(requestItem.getTodos());
        itemRepository.save(item);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateTodo(@ModelAttribute TodoApplication requestItems){
        for (Item requestItem : requestItems.getTodoList()) {
            Item item = new Item(requestItem.getTodos());
            item.setCondition(requestItem.isCondition());
            item.setId(requestItem.getId());
            itemRepository.save(item);
        }
        return "redirect:/";
    }


    /*
    @PostMapping(path="/add")
    public @ResponseBody String addNewItem (@RequestParam String todos
            , @RequestParam String condition) {

        Item n = new Item();
        n.setTodos(todos);
        n.setCondition(condition);
        ItemRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Item> getAllItems() {
        // This returns a JSON or XML with the users
        return itemRepository.findAll();
    }

     */
}