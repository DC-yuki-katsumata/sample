package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	   // 全てのPersonを取得するメソッド
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
