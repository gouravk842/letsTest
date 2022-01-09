package com.letsTest.service;

import com.letsTest.dto.AnswerDto;
import com.letsTest.dto.QuestionDto;
import com.letsTest.dto.QuizDto;
import com.letsTest.dto.StudentAnswerDto;
import com.letsTest.entity.Answer;
import com.letsTest.entity.Question;
import com.letsTest.entity.Quiz;
import com.letsTest.entity.StudentAnswer;
import com.letsTest.repository.QuizRepository;
import com.letsTest.repository.StudentAnswerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    StudentAnswerRepo studentAnswerRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public QuizDto startExam(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        for (Question question : quiz.get().getQuestion()) {
            question.setCorrectAnswer(null);
            question.setQuiz(null);
            for (Answer answer : question.getAnswers()) {
                answer.setQuestions(null);

            }
        }
        QuizDto quizDto = null;
        if (quiz.isPresent()) {
            quizDto = modelMapper.map(quiz.get(), new TypeToken<QuizDto>() {
            }.getType());
        }
        return quizDto;
    }

    @Override
    public void saveAnswer(StudentAnswerDto studentAnswerDto) {
        StudentAnswer studentAnswer = modelMapper.map(studentAnswerDto, new TypeToken<StudentAnswer>() {
        }.getType());
        studentAnswerRepo.save(studentAnswer);


    }
}
