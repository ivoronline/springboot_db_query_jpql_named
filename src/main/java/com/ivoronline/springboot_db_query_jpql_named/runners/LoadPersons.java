package com.ivoronline.springboot_db_query_jpql_named.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class LoadPersons implements CommandLineRunner {

  //PROPERTIES
  @PersistenceContext EntityManager entityManager;

  //================================================================
  // RUN
  //================================================================
  @Override
  @Transactional
  public void run(String... args) {

    //NATIVE QUERY
    String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
    Query  query  = entityManager.createNativeQuery(insert);
           query.setParameter("name", "John");
           query.setParameter("age" , 20    );

    //INSERT PERSON
    query.executeUpdate();

  }

}
