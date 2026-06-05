package com.question.question_micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.question_micro.Questions;

public interface QuestionDao extends JpaRepository<Questions,Integer>{ //primary key type
    
}
