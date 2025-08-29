package com.api.bootrestbooks.dao;
import org.springframework.data.repository.CrudRepository;

import com.api.bootrestbooks.entities.Book;



public interface BookRepository extends CrudRepository<Book,Integer>{
    //custom method-
    public Book findById(int id);
    
}
