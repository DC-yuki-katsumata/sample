package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaThemeRepository extends JpaRepository<IdeaTheme, Integer>{
	List<IdeaTheme> findByTitleContaining(String title);
}