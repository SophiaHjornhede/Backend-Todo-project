
package com.example.todo.controller;

import com.example.todo.entity.Item;
import com.example.todo.repository.*;


public class TodoLogic {
	
	/**
	 * Method to change all the todo-items' conditions in group.	 * 
	 * 
	 * @param repository
	 * @return
	 * @throws Exception
	 */
	public String extractedRequest(ItemRepository repository) throws Exception {
		//read all the items from repository
		Iterable<Item> todoItems = repository.findAll();
		
		//read all the completed items from the repository
		Iterable<Item> todoItemsCompleted = repository.findByCompleted(true);
		
		//Compare the two iterable lists and set same complete status
		if (todoItems.equals(todoItemsCompleted)) {
			for (Item todoItem : todoItems) {
				todoItem.setComplete(false);
				repository.save(todoItem);
			}
		} else {
			for (Item todoItem : todoItems) {
				todoItem.setComplete(true);
				repository.save(todoItem);
			}
		}
		return "Setting all true";

	}	

}
