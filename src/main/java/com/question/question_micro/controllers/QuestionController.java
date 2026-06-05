package com.question.question_micro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.question.question_micro.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public String getQuestions() {
        return questionService.getQuestions();
    }
    
    
}
