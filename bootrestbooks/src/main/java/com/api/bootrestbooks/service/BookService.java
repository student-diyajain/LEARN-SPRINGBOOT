package com.api.bootrestbooks.service;
import com.api.bootrestbooks.dao.BookRepository;
import com.api.bootrestbooks.entities.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
        // private static List<Book> list =new ArrayList<>();
        // static{
        //     list.add(new Book(101,"i am a student","diya jain"));
        //     list.add(new Book(102,"i am a teacher","charu jain"));
        //     list.add(new Book(103,"i am a musician","priya jain"));
        // }
      


    
//CREATE:POST
public Book addBook (Book b){
    Book book=bookRepository.save(b);
    return book;
}    

//READ:GET
public List<Book> getBooks(){
   List<Book> list=(List<Book>)bookRepository.findAll();
   return list;
}

public Book getBookById(int bookId){
        Book book=null;
        try{
        // book=list.stream().filter(b->b.getId()==bookId).findFirst().get();
        book=bookRepository.findById(bookId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
}

//UPDATE:PUT
public void updateBook(Book book,int bookId){
    // list=list.stream().map(b->{ 
    //      if(b.getId()==bookId){
    //            b.setTitle(book.getTitle());
    //            b.setAuthor(book.getAuthor());
    //      }     
    //      return b;    
    // }).collect(Collectors.toList());
     book.setId(bookId);  //to make sure hm ise id ki book change kr rhe ho new book na create horhi ho
     bookRepository.save(book);
     
}



//DELETE:DELETE
public void deleteBookById(int bookId){
    //list= list.stream().filter(b->b.getId()!=bookId).collect(Collectors.toList());
    //jo id se match nhi horha unhe list m daal degi

    bookRepository.deleteById(bookId);


}

    
}
