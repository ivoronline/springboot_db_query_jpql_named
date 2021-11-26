package com.ivoronline.springboot_db_query_jpql_named.controllers;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import com.ivoronline.springboot_db_query_jpql_named.services.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired DBAccess dbAccess;

  //================================================================
  // SELECT PERSON
  //================================================================
  @RequestMapping("SelectPerson")
  Person selectPersonByNameAge() {
    Person person = dbAccess.selectPerson();
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

}


