package com.example.quizzapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

@Data
public class QuestionWrapper {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    public QuestionWrapper(Long id, String option4, String option3, String option2, String questionTitle, String option1) {
        this.id = id;
        this.option4 = option4;
        this.option3 = option3;
        this.option2 = option2;
        this.questionTitle = questionTitle;
        this.option1 = option1;
    }
}
