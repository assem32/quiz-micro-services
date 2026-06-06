package com.question.question_micro.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.question.question_micro.models.QuestionDto;
import com.question.question_micro.models.Responses;
import com.question.question_micro.services.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("quiz")
public class QuizCotroller {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public String createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title) {
        return quizService.createQuiz(category,num,title);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionDto>> getQuiz(@PathVariable int id){
        return quizService.getQuiz(id);
    }

    @PostMapping("/answer/{id}")
    public ResponseEntity<Integer> submit(@PathVariable int id,@RequestBody List<Responses> responses) {
        return quizService.submit(id,responses);
    }
    
    
    
}
