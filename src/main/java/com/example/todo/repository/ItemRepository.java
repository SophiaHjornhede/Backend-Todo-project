package com.example.todo.repository;

import com.example.todo.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{
    Iterable<Item> findByCondition(boolean condition);
    int countByCondition(boolean condition);
}
