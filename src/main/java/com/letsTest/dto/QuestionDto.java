package com.letsTest.dto;

import java.util.List;


public class QuestionDto {


    private Long questionId;
    private String question;
    private String hint;
    private QuizDto quiz;
    private List<AnswerDto> answers;
    private List<CorrectAnswerDto> correctAnswer;

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

    public QuizDto getQuiz() {
        return quiz;
    }
    public void setQuiz(QuizDto quiz) {
        this.quiz = quiz;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public List<CorrectAnswerDto> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(List<CorrectAnswerDto> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }



}
