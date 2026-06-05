package com.question.question_micro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.question_micro.Questions;
import com.question.question_micro.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Questions> getQuestions() {
        return questionDao.findAll();
    }
    
}
