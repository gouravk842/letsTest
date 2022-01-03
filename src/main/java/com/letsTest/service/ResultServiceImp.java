package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.dto.ResultDto;
import com.letsTest.entity.CorrectAnswer;
import com.letsTest.entity.Quiz;
import com.letsTest.entity.Result;
import com.letsTest.repository.ResultRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResultServiceImp implements ResultService{

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    ModelMapper modelMapper;

    public String SaveResultMarks(ResultDto resultDto){
        Result result=modelMapper.map(resultDto, Result.class);
        resultRepository.save(result);
        return "Success";
    }

    public List<ResultDto> getResultMarks(Long quizId, Long createdById){
        List<Result> resultList=resultRepository.getResultDetailById(createdById,quizId);
        List<ResultDto> resultDtos = modelMapper.map(resultList, new TypeToken<List<ResultDto>>() {
        }.getType());
        return resultDtos;
    }
}
