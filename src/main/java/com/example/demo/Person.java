package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private int id;	
	
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	private String name;

	@Min(value = 0, message = "Age must be positive")
	private int age;

	@NotBlank(message = "Address cannot be empty")
	private String address;
	
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	
}