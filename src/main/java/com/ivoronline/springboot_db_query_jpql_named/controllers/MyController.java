package com.ivoronline.springboot_db_query_jpql_named.controllers;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import com.ivoronline.springboot_db_query_jpql_named.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
public class MyController {

  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RETURN PERSON INDEXED
  //================================================================
  @RequestMapping("ReturnPersonIndexed")
  Person returnPersonIndexed() {

    //REFERENCE QUERY USING ENTITY MANAGER
    Query  query  = entityManager.createNamedQuery("Person.findByNameAgeIndexed");
           query.setParameter(1, "John");
           query.setParameter(2, 20);

    //GET PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;

  }

  //================================================================
  // RETURN PERSON NAMED
  //================================================================
  @RequestMapping("ReturnPersonNamed")
  Person returnPersonNamed() {

    //REFERENCE QUERY USING ENTITY MANAGER
    Query  query  = entityManager.createNamedQuery("Person.findByNameAgeNamed");
           query.setParameter("name", "John");
           query.setParameter("age" , 20);

    //GET PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN PERSON
    return person;

  }

}


