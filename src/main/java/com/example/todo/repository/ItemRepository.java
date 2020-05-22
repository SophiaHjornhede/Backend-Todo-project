package com.example.todo.repository;

import com.example.todo.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{
    
	//find all the items that was completed
	Iterable<Item> findByCompleted(boolean completed);
    
	//how many of the completed items
	int countByCompleted(boolean completed);
}
