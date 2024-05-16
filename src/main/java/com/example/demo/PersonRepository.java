package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	List<Person> findByAge(int age);
	List<Person> findByAgeLessThan(int age);
	List<Person> findByAgeGreaterThan(int age);
	List<Person> findByAgeBetween(int min_age, int max_age);
	List<Person> findByName(String name);
	List<Person> findByNameLike(String name);
	List<Person> findByNameContaining(String name);
}