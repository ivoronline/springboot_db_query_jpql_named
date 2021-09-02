package com.ivoronline.springboot_db_query_jpql_named.repositories;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import org.springframework.data.repository.CrudRepository;

//PersonRepository is only used to  INSERT Record since INSERT is not supported by JPQL
public interface PersonRepository extends CrudRepository<Person, Integer> { }


