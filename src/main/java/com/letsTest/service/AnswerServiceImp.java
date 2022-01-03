package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import com.letsTest.dto.QuestionDto;
import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Answer;
import com.letsTest.entity.Question;
import com.letsTest.repository.AnswerRepository;
import com.letsTest.repository.CorrectAnswerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService{

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    CorrectAnswerRepository correctAnswerRepository;

    @Autowired
    ModelMapper modelMapper;

    public String saveAnswer(AnswerDto answerDto){
        Answer answer=modelMapper.map(answerDto, Answer.class);
        answerRepository.save(answer);
        //correctAnswerRepository.save()
        return "Success";
    }
    public String saveAllAnswer(List<AnswerDto> answerDto){
        List<Answer> answers = modelMapper.map(answerDto, new TypeToken<List<Answer>>() {
        }.getType());
        answerRepository.saveAll(answers);
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

    public List<AnswerDto> getAllAnswerByQuestionId(Long questionId,Long quizId){
        List <Answer> answerList=answerRepository.getAnswerDetailById(questionId,quizId);
        List<AnswerDto> answerDtos = modelMapper.map(answerList, new TypeToken<List<AnswerDto>>() {
        }.getType());
        return answerDtos;
    }

}
