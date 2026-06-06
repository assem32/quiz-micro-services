package com.question.question_micro.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.question.question_micro.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("quiz")
public class QuizCotroller {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public String createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title) {
        
        
        return quizService.createQuiz(category,num,title);
    }
    
}
