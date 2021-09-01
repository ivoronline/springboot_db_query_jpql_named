package com.ivoronline.springboot_db_query_jpql_named.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(
  name  = "Person.findByNameAgeIndexed",
  query = "SELECT person FROM Person person WHERE person.name = ?1 AND person.age = ?2"
)
@NamedQuery(
  name  = "Person.findByNameAgeNamed",
  query = "SELECT person FROM Person person WHERE person.name = :name AND person.age = :age"
)
@Entity
public class Person {

  //PROPERTIES
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

  //CONSTRUCTORS
  public Person() { }                               //Forced by @Entity
  public Person(String name, Integer age) {         //To simplify PersonLoader
    this.name = name;
    this.age  = age;
  }

}
