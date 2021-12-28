package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import com.letsTest.dto.QuestionDto;
import com.letsTest.entity.Answer;
import com.letsTest.repository.AnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImp implements AnswerService{

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveAnswer(AnswerDto answerDto){
        Answer answer=modelMapper.map(answerDto, Answer.class);
        answerRepository.save(answer);
        return "Success";
    }

    public String deleteAnswerById(Long answerId){
        answerRepository.deleteById(answerId);
        return "Success";
    }

    public String EditOptions(AnswerDto answerDto){
        answerRepository.updateAnswerById(answerDto.getQuestionOption(), answerDto.getAnswerId());
        return "Success";
    }
}
