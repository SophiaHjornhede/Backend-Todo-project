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


    // inject constructor
    private ItemRepository itemRepository;
	
    @Autowired  // constructor injection
    private ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView M = new ModelAndView("welcome");
        M.addObject("text", "Welcome your Todo Application!");
        return M;
    }

    
    /**
     * check the repository for a specific id     * 
     * @param id
     * @return
     */
    @GetMapping("/getItem")
    @ResponseBody
    public Optional<Item> getinfo(@RequestParam long id) {
        return itemRepository.findById(id);
    }
    
    /**
     * Total item numbers in the repository 
     * @return
     */
    @GetMapping(path = "/howManyInTotal")
    @ResponseBody
    public  long totalNumbers() {
        return itemRepository.count();
    }
    

    /**
     * add one todo item to the repository
     * @param content
     * @return
     */
    @PostMapping("/addItem")
    @ResponseBody
    public  String addTodoItems(@RequestParam String content) {
        Item todo = new Item(content);
        itemRepository.save(todo);
        return "Stored Todo";
    }
    
    
    /**
     * delete an item in the repository
     * @param id
     * @return
     */
    @DeleteMapping("/deleteItem")
    @ResponseBody
    public String deletePost(@RequestParam long id) {
        itemRepository.deleteById(id);
        return "deleted";
    }

    /**
     * Change one items status: completed or active
     * @param id
     * @return
     */
    @RequestMapping("/changeOneTodo")
    @ResponseBody
    public  String changeOneTodo(@RequestParam long id) {
        Item todo = itemRepository.findById(id).orElse(null);
        boolean done = todo.getComplete();
        todo.setComplete(!done);
        itemRepository.save(todo);
        return"Change todo status";
    }
    
    
    /**
     * show all the items in the repository
     * @return
     */
    @GetMapping(path = "/allItems")
    @ResponseBody
    public  Iterable<Item> getAllTodos() {
        return itemRepository.findAll();
    }  
   
    /**
     * all the active items of the todos 
     * @param model
     * @return
     */
    @GetMapping(path = "/activeItems")
    @ResponseBody
    public  Iterable<Item> getAllActive(Model model) {
        return itemRepository.findByCompleted(false);
    }

    /**
     * all the completed items of todos in the repository
     * @param model
     * @return
     */
    @GetMapping(path ="/completeItems")
    @ResponseBody
    public  Iterable<Item> getAllComplete(Model model) {
        return itemRepository.findByCompleted(true);
    }

    
    /**
     * Moved Logic to another class called TodoLogic.java
     * @return
     * @throws Exception
     */
    @SuppressWarnings("null")
	@GetMapping("/changeall")
	@ResponseBody
	public String changeAllconditions() throws Exception {
		
		TodoLogic logic = new TodoLogic();

		return logic.extractedRequest(itemRepository);
	}
  
}   
    
