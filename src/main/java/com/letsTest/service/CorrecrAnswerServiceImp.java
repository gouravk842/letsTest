package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import com.letsTest.dto.CorrectAnswerDto;
import com.letsTest.entity.CorrectAnswer;
import com.letsTest.repository.CorrectAnswerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrecrAnswerServiceImp implements CorrecrAnswerService{

    @Autowired
    CorrectAnswerRepository correctAnswerRepository;

    @Autowired
    ModelMapper modelMapper;

   /* public List<CorrectAnswerDto> getAllCorrectAnswerByQuestionId(Long questionId,Long quizId){
        List <CorrectAnswer> correctAnswerList=correctAnswerRepository.getCorrectAnswerDetailById(questionId,quizId);
        List<CorrectAnswerDto> correctAnswerDto = modelMapper.map(correctAnswerList, new TypeToken<List<CorrectAnswerDto>>() {
        }.getType());
        return correctAnswerDto;
    }*/

    public String saveAllCorrectAnswer(List<CorrectAnswerDto> correctAnswerDtos){
        List<CorrectAnswer> correctAnswerList = modelMapper.map(correctAnswerDtos, new TypeToken<List<CorrectAnswer>>() {
        }.getType());
        correctAnswerRepository.saveAll(correctAnswerList);
        return "Success";
    }

    public String saveCorrectAnswer(CorrectAnswerDto correctAnswerDtos){
        CorrectAnswer correctAnswerDto = modelMapper.map(correctAnswerDtos,CorrectAnswer.class);
        correctAnswerRepository.save(correctAnswerDto);
        return "Success";
    }
}
