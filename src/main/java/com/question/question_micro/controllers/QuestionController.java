package com.question.question_micro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.question_micro.models.Questions;
import com.question.question_micro.services.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public ResponseEntity<List<Questions>> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getMethodName(@PathVariable String category) {
        return questionService.getQuestionsCategory(category);
    }

    @PostMapping("/add")
    public String addQuesiton(@RequestBody Questions question) {        
        return questionService.addQuestion(question);
    }
    
    
    
    
}
