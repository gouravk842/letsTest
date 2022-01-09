package com.letsTest.controller;

import com.letsTest.dto.QuizDto;
import com.letsTest.dto.StudentAnswerDto;
import com.letsTest.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exam")
public class examinationController {
    @Autowired
    ExaminationService examinationService;

    @ResponseBody
    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.GET)
    public ModelAndView register(@PathVariable(value = "id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("examinationDashboard.html");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/start/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> startExam(@PathVariable(value = "id") Long id) {

        QuizDto quizDto = examinationService.startExam(id);
        return new ResponseEntity<>(quizDto, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
    public ResponseEntity<?> saveAnswer(@RequestBody StudentAnswerDto studentAnswerDto) {
        examinationService.saveAnswer(studentAnswerDto);
        String msg = "Success";
        return new ResponseEntity<>("Success", new HttpHeaders(), HttpStatus.OK);
    }
}
