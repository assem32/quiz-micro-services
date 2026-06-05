package com.question.question_micro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<QuestionDao,Integer>{ //primary key type
    
}
