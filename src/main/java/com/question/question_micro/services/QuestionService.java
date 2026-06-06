package com.question.question_micro.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.question_micro.dao.QuestionDao;
import com.question.question_micro.models.Questions;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public List<Questions> getQuestionsCategory(String category) {
        return questionDao.findAllByCategory(category);
    }

    public String addQuestion(Questions question){
        questionDao.save(question);
        return "done";
    }
    
}
