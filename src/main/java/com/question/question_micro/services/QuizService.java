package com.question.question_micro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.question_micro.dao.QuestionDao;
import com.question.question_micro.dao.QuizDao;
import com.question.question_micro.models.Questions;
import com.question.question_micro.models.Quiz;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuizDao quizDao;
    
    public String createQuiz(String category,int numQ,String title){
        List<Questions> questions =questionDao.findRandomQuestionsBuCategory(category, numQ);
        
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "hey";
    }
}
