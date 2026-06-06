package com.question.question_micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.question_micro.models.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{
    
    
}
