package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Quiz;
import com.letsTest.repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class QuizServiceImp implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String SaveQuiz(QuizDto quizDto){
        Quiz quiz=modelMapper.map(quizDto, Quiz.class);
        LocalDate createDate = LocalDate.now();
        quiz.setCreatedDate(createDate);
        quizRepository.save(quiz);
        return "Success";
    }

    public String DeleteQuiz(Long quizeId){
        quizRepository.deleteById(quizeId);
        return "Deleted";
    }

    public String EditQuiz(QuizDto quizDto){
        quizRepository.updateQuizById(quizDto.getNameOfTopic(), quizDto.getQuizId());
        return "Success";
    }


}
