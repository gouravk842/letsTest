package com.letsTest.service;

import com.letsTest.dto.QuestionDto;
import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Question;
import com.letsTest.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService{

    @Autowired
    public QuestionRepository questionRepository;

    @Autowired
    public ModelMapper modelMapper;

    public String saveQuestions(QuestionDto questionDto){
        Question question=modelMapper.map(questionDto,Question.class);
        questionRepository.save(question);
        return "Success";
    }
    public String deleteQuestion(Long questionId){
        questionRepository.deleteById(questionId);
        return "Success";
    }

    public String EditQuestion(QuestionDto questionDto){
        questionRepository.updateQuestionById(questionDto.getQuestion(), questionDto.getQuestionId());
        return "Success";
    }

}
