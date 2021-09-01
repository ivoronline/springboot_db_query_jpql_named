package com.ivoronline.springboot_db_query_jpql_named.repositories;

import com.ivoronline.springboot_db_query_jpql_named.entities.Person;
import org.springframework.data.repository.CrudRepository;

// JUST NEEDED TO LOAD DATA
public interface PersonRepository extends CrudRepository<Person, Integer> { }


