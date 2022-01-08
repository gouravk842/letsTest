package com.letsTest.entity;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Question {
    private Long questionId;
    private String question;
    private String hint;
    private Quiz quiz;
    private List<Answer> answers;
    private List<CorrectAnswer> correctAnswer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name="quizId")
    @JsonIgnore
    public Quiz getQuiz() {
        return quiz;
    }
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @OneToMany(targetEntity=Answer.class, mappedBy="questions" ,cascade = {CascadeType.ALL})
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @OneToMany(targetEntity=CorrectAnswer.class, mappedBy="question", cascade = {CascadeType.ALL})
    public List<CorrectAnswer> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(List<CorrectAnswer> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }


}
