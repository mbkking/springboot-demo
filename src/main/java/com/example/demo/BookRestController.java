package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class BookRestController {



    private final BookRepository bookRepository;
    public BookRestController (BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }
//get = lectur
    //post= crratione
    // put = mise a jour
// delete
    @GetMapping("/book")
    public  String get(@RequestParam String bookname , @RequestParam  Integer bookpages) {
     BookEntity existingBook = bookRepository.findByNameAndPages(bookname,bookpages);

     if(existingBook==null){

         BookEntity book = BookEntity.builder()
                 .name(bookname )
                 .pages(bookpages)
                 .build();


         bookRepository.save(book);
         return"livre creer avec success";
     }

     else {
         return "le livre  exite deja !";
     }





    }
}
