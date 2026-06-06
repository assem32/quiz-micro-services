package com.question.question_micro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.question.question_micro.models.Questions;

public interface QuestionDao extends JpaRepository<Questions,Integer>{//primary key type

    List<Questions> findAllByCategory(String category);

    @Query(value = "SELECT * FROM questions q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questions> findRandomQuestionsBuCategory(String category, int numQ);
    
}
