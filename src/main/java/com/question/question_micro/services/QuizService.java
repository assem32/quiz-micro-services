package com.question.question_micro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.question_micro.dao.QuestionDao;
import com.question.question_micro.dao.QuizDao;
import com.question.question_micro.models.QuestionDto;
import com.question.question_micro.models.Questions;
import com.question.question_micro.models.Quiz;
import com.question.question_micro.models.Responses;

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

    public ResponseEntity<List<QuestionDto>> getQuiz(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionDb = quiz.get().getQuestions();
        List<QuestionDto> questionUser = new ArrayList<>();

        for(Questions q : questionDb){
            QuestionDto questionDto = new QuestionDto(
                q.getId(),
                q.getQuestionTitle(),
                q.getOptionOne(),
                q.getOptionTwo(),
                q.getOptionThree(),
                q.getOptionFour()
            );
            questionUser.add(questionDto);
        }
        return new ResponseEntity<>(questionUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submit(int id, List<Responses> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questions = quiz.get().getQuestions();
        int score=0;
        for (Responses response : responses) {
            for (Questions question : questions) {
                if (question.getId() == response.getId()) {
                    if (response.getAnswer().equals(question.getRightAnswer())) {
                        score++;
                    }
                    break;
                }
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
