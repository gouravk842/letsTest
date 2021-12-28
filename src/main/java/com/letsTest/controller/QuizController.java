package com.letsTest.controller;

import com.letsTest.dto.AnswerDto;
import com.letsTest.dto.QuestionDto;
import com.letsTest.dto.QuizDto;
import com.letsTest.service.AnswerService;
import com.letsTest.service.QuestionService;
import com.letsTest.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public String saveQuizDetails(@RequestBody QuizDto quizDto)
    {
        return quizService.SaveQuiz(quizDto);
    }


    @RequestMapping(value="/update",method = RequestMethod.PUT)
    @ResponseBody
    public String editQuizDetails(@RequestBody QuizDto quizDto)
    {
        return quizService.EditQuiz(quizDto);
    }


    @RequestMapping(value="/delete/{quizId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteQuizDetailsById(@PathVariable(value = "quizId") Long quizId)
    {
        return quizService.DeleteQuiz(quizId);
    }

    @RequestMapping(value="/question/save",method = RequestMethod.POST)
    @ResponseBody
    public String saveQuestionDetails(@RequestBody QuestionDto questionDto)
    {
        return questionService.saveQuestions(questionDto);
    }

    @RequestMapping(value="/question/update",method = RequestMethod.PUT)
    @ResponseBody
    public String editQuestionDetails(@RequestBody QuestionDto questionDto)
    {
        return questionService.EditQuestion(questionDto);
    }


    @RequestMapping(value="/question/delete/{questionId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteQuestionDetailsById(@PathVariable(value = "questionId") Long questionId)
    {
        return questionService.deleteQuestion(questionId);
    }


    @RequestMapping(value="/answer/save",method = RequestMethod.POST)
    @ResponseBody
    public String saveAnswerDetails(@RequestBody AnswerDto answerDto)
    {
        return answerService.saveAnswer(answerDto);
    }

    @RequestMapping(value="/answer/update",method = RequestMethod.PUT)
    @ResponseBody
    public String editAnswerDetails(@RequestBody AnswerDto answerDto)
    {
        return answerService.EditOptions(answerDto);
    }

    @RequestMapping(value="/answer/delete/{answerId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAnswerDetailsById(@PathVariable(value = "answerId") Long answerId)
    {
        return answerService.deleteAnswerById(answerId);
    }


}
