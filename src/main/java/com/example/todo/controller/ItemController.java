package com.example.todo.controller;

import com.example.todo.TodoApplication;
import com.example.todo.entity.Item;
import com.example.todo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.StreamSupport;


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
@RequestMapping(path="/todo")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView M = new ModelAndView("welcome");
        M.addObject("text", "Welcome your Todo Application!");
        return M;
    }

    @GetMapping("/getItems")
    public @ResponseBody Optional<Item> getinfo(@RequestParam long id) {
        return itemRepository.findById(id);
    }

    @DeleteMapping("/deleteItems")
    public String deletePost(@RequestParam long id) {
        itemRepository.deleteById(id);
        return "deleted";
    }

    @PostMapping("/add")
    public @ResponseBody String addTodoItems(@RequestParam String content) {
        Item todo = new Item(content);
        itemRepository.save(todo);
        return "Stored Todo";
    }


    @PostMapping("/")
    public String createNewItems(Item todo) {
        itemRepository.save(todo);
        return "redirect:/";
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Item> getAllTodos() {
        return itemRepository.findAll();
    }

    @GetMapping(path = "/howManyInTotal")
    public @ResponseBody long totalNumbers() {
        return itemRepository.count();
    }

    @GetMapping(path = "/active")
    public @ResponseBody Iterable<Item> getAllActive(Model model) {
        return itemRepository.findByCondition(false);
    }

    @GetMapping(path = "/complete")
    public @ResponseBody Iterable<Item> getAllComplete(Model model) {
        return itemRepository.findByCondition(true);
    }

    @RequestMapping("/")
    public String indexNew(Model model) {
        return "indexNew";
    }


    @RequestMapping("/changeOneTodo")
    public String changeOneTodo(@RequestParam long id) {
        Item todo = itemRepository.findById(id).orElse(null);
        boolean completed = todo.getComplete();
        todo.setComplete(!completed);
        itemRepository.save(todo);
        return"Change todo status";
    }

    @GetMapping("/changeAll")
    public String changeAllTodos() {
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

 /*
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