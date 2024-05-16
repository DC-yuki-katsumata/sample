package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Idea {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Title cannot be empty")
	@Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
	private String title;
	
	private LocalDateTime createdAt;

    @NotBlank(message = "Content cannot be empty")
    private String content;

	public Idea(String title, LocalDateTime createdAt, String content) {
		this.title = title;
		this.createdAt = createdAt;
		this.content = content;
	}

}