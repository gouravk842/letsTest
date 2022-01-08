package com.letsTest.service;

import com.letsTest.dto.QuestionDto;
import com.letsTest.entity.Question;
import com.letsTest.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String saveAllQuestions(List<QuestionDto> questionDtoList){
        List<Question> questionList = modelMapper.map(questionDtoList, new TypeToken<List<Question>>() {
             }.getType());
        questionRepository.saveAll(questionList);
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


   // public List<QuestionDto> getAllQuestionByQuizId(Long quizId){
       // List <Question> questionList=questionRepository.getQuestionDetailById(quizId);
     //   List<QuestionDto> questionListDtos = modelMapper.map(questionList, new TypeToken<List<QuestionDto>>() {
      //  }.getType());
      //  return questionListDtos;
   // }

}
