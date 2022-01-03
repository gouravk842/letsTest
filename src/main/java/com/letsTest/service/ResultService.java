package com.letsTest.service;

import com.letsTest.dto.ResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {

    String SaveResultMarks(ResultDto resultDto);

    List<ResultDto> getResultMarks(Long quizId, Long createdById);
}
