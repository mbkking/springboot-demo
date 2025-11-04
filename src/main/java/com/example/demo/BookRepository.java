package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {


   // c'est un methode qui permet deviter le doublons  elle seras appler dans le controller

    public BookEntity findByNameAndPages(String name, Integer pages);

}
