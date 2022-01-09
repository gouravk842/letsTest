package com.letsTest.service;

import com.letsTest.dto.QuizDto;
import com.letsTest.dto.ResultDto;
import com.letsTest.entity.*;
import com.letsTest.repository.CorrectAnswerRepository;
import com.letsTest.repository.QuizRepository;
import com.letsTest.repository.ResultRepository;
import com.letsTest.repository.StudentAnswerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ResultServiceImp implements ResultService {

    @Autowired
    ResultRepository resultRepository;
    @Autowired
    StudentAnswerRepo studentAnswerRepo;
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    ModelMapper modelMapper;

    public String SaveResultMarks(Long quizId) {
        Integer mark = 0;
        Map answer = new HashMap();
        Optional<Quiz> q = quizRepository.findById(quizId);
        List<StudentAnswer> studentAnswer = studentAnswerRepo.getAnswerList(quizId);
        Map total = new HashMap();
        if (q.isPresent()) {
            for (Question r : q.get().getQuestion()) {
                answer.put(r.getQuestionId(), r.getCorrectAnswer().get(0).getCorrectAnswerId());
            }

        }
        for (StudentAnswer s : studentAnswer) {
            if (s.getAnswerId() == answer.get(s.getQuestionId())) {
                if (total.get(s.getStudentId()) == null) {
                    total.put(s.getStudentId(), 1);
                } else {
                    total.put(s.getStudentId(), 1 + (Integer) total.get(s.getStudentId()));
                }
            }
        }
        for(Object h:total.keySet()){
            Result r=new Result();
            r.setQuizId(quizId);
            r.setTotalMarks(((Integer) total.get(h))*1l);
            r.setUserId((Long) h);
            resultRepository.save(r);
        }
        return "Success";
    }

    public List<ResultDto> getResultMarks(Long quizId, Long createdById) {
        List<Result> resultList = resultRepository.getResultDetailById(createdById, quizId);
        List<ResultDto> resultDtos = modelMapper.map(resultList, new TypeToken<List<ResultDto>>() {
        }.getType());
        return resultDtos;
    }
}
