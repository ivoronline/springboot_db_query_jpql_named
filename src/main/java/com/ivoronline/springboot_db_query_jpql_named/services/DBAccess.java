package com.ivoronline.springboot_db_query_jpql_named.services;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import com.ivoronline.springboot_db_query_jpql_named.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class DBAccess {

  //PersonRepository is used only for INSERT through Repository since JPQL doesn't support INSERT
  @Autowired          PersonRepository personRepository;
  @PersistenceContext EntityManager    entityManager;

  //================================================================
  // SELECT PERSON BY NAME AGE
  //================================================================
  public Person selectPersonByNameAge() {

    //REFERENCE QUERY USING ENTITY MANAGER
    Query  query  = entityManager.createNamedQuery("Person.selectPersonByNameAge");
           query.setParameter(1, "John");
           query.setParameter(2 , 20);

    //SELECT PERSON
    Person person = (Person) query.getSingleResult();

    //RETURN
    return person;

  }

  //================================================================
  // INSERT PERSON
  //================================================================
  // INSERT is not supported by JPQL so we use Repository
  @Transactional
  public void insertPerson() {
    personRepository.save(new Person("John" , 20));
  }

  //================================================================
  // UPDATE PERSON
  //================================================================
  @Transactional
  public Integer updatePerson() {

    //REFERENCE QUERY USING ENTITY MANAGER
    Query  query  = entityManager.createNamedQuery("Person.updatePerson");
           query.setParameter("name"  , "John");
           query.setParameter("newAge", 200);

    //GET PERSON
    Integer updatedRecords = query.executeUpdate();

    //RETURN
    return updatedRecords;

  }

  //================================================================
  // DELETE PERSON
  //================================================================
  @Transactional
  public Integer deletePerson() {

    //REFERENCE QUERY USING ENTITY MANAGER
    Query  query  = entityManager.createNamedQuery("Person.deletePerson");
           query.setParameter("name", "John");

    //GET PERSON
    Integer deletedRecords = query.executeUpdate();

    //RETURN
    return deletedRecords;

  }

}
