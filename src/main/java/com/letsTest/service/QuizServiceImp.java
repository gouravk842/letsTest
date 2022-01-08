package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.entity.Answer;
import com.letsTest.entity.CorrectAnswer;
import com.letsTest.entity.Question;
import com.letsTest.entity.Quiz;
import com.letsTest.repository.AnswerRepository;
import com.letsTest.repository.CorrectAnswerRepository;
import com.letsTest.repository.QuestionRepository;
import com.letsTest.repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImp implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CorrectAnswerRepository correctAnswerRepository;


    @Autowired
    private ModelMapper modelMapper;

    public Long SaveQuiz(QuizDto quizDto){
        Quiz quiz=modelMapper.map(quizDto, Quiz.class);
        LocalDate createDate = LocalDate.now();
        quiz.setCreatedDate(createDate);
        Quiz savedQuiz=quizRepository.save(quiz);
        for(Question question:quiz.getQuestion()){
            question.setQuiz(quiz);
            questionRepository.save(question);
            Long i=0L;
            for(Answer answer: question.getAnswers()){
                answer.setQuestions(question);
                answer.setAnswerOrder(++i);
                answerRepository.save(answer);
            }
            for(CorrectAnswer correctAnswer: question.getCorrectAnswer()){
                correctAnswer.setQuestion(question);
                correctAnswerRepository.save(correctAnswer);
            }
        }
        return savedQuiz.getQuizId();
    }

    public String DeleteQuiz(Long quizeId){
        quizRepository.deleteById(quizeId);
        return "Deleted";
    }

    public String EditQuiz(QuizDto quizDto){
        quizRepository.updateQuizById(quizDto.getNameOfTopic(), quizDto.getQuizId());
        return "Success";
    }

    public List<QuizDto> getQuizByCreatedById(Long createdBy){
        List<Quiz> quizList=quizRepository.getQuizDetailById(createdBy);
        List<QuizDto> quizDtos=new ArrayList<>();
        for (Quiz quiz: quizList){
            quiz.setQuestion(null);
            quizDtos.add(modelMapper.map(quiz,QuizDto.class));
        }
      //  List<QuizDto> quizListDtos = modelMapper.map(quizList, new TypeToken<List<QuizDto>>() {
        //}.getType());
        return quizDtos;
    }

    public Quiz getQuiz(Long quizId){
        Quiz quiz=quizRepository.getQuizDetailByQuizId(quizId);
            return quiz;
    }


}
