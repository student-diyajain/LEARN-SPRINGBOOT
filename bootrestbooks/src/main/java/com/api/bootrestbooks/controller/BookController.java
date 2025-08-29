package com.api.bootrestbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.api.bootrestbooks.entities.Book;
import com.api.bootrestbooks.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class BookController {
    @Autowired
    private BookService bookService;


//CREATE:POST
@PostMapping("/books")
public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Book b = null;
    try {
        b = bookService.addBook(book);
        System.out.println("Request book: " + book);
        System.out.println("Saved book: " + b);

        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    } catch (Exception e) {
        e.printStackTrace(); // Log the error
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


//READ:GET
@GetMapping("/books")
public ResponseEntity<List<Book>> getBooks(){
    List<Book> list=bookService.getBooks();
    if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
return  ResponseEntity.status(HttpStatus.CREATED).body(list);
}


@GetMapping("/books/{bookId}")
public ResponseEntity<Book> getBookById(@PathVariable("bookId") int id){
    Book book=bookService.getBookById(id);
    if(book==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
return  ResponseEntity.of(Optional.of(book));
}



//UPDATE:PUT
@PutMapping("/books/{bookId}")
public ResponseEntity<Book> UpdateBookById(@RequestBody Book newBook,@PathVariable("bookId") int id){
    try{
            bookService.updateBook(newBook, id);
            return ResponseEntity.ok().body(newBook);
    }catch(Exception e){
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        
}




//DELETE:DELETE
@DeleteMapping("/books/{bookId}")
public ResponseEntity<Void> deleteBookById(@PathVariable("bookId") int id){
    try{
              bookService.deleteBookById(id);
               return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }catch(Exception e){
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        
}


    
}
