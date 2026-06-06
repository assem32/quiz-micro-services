package com.question.question_micro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private int id;
    private String questionTitle;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
}