package com.ivoronline.springboot_db_query_jpql_named.controllers;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import com.ivoronline.springboot_db_query_jpql_named.repositories.PersonRepository;
import com.ivoronline.springboot_db_query_jpql_named.services.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired DBAccess         dbAccess;
  @Autowired PersonRepository personRepository;    //Only for INSERT

  //================================================================
  // SELECT PERSON BY NAME AGE
  //================================================================
  @RequestMapping("SelectPersonByNameAge")
  Person selectPersonByNameAge() {
    Person person = dbAccess.selectPersonByNameAge();
    return person;
  }

  //================================================================
  // UPDATE PERSON
  //================================================================
  @RequestMapping("UpdatePerson")
  String updatePerson() {
    Integer updatedRecords = dbAccess.updatePerson();
    return  updatedRecords + " Records Updated";
  }

  //================================================================
  // DELETE PERSON
  //================================================================
  @RequestMapping("DeletePerson")
  String deletePerson() {
    Integer deletedRecords = dbAccess.deletePerson();
    return  deletedRecords + " Records Deleted";
  }

  //================================================================
  // INSERT PERSON
  //================================================================
  // INSERT is not supported by JPQL so we use Repository
  @RequestMapping("InsertPerson")
  String insertPerson() {
    personRepository.save(new Person("John" , 20));
    return "Person Inserted into DB";
  }

}


