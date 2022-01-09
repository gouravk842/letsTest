package com.letsTest.controller;

import com.google.gson.Gson;
import com.letsTest.dto.ResultDto;
import com.letsTest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/results")
public class StudentController {

    @Autowired
    ResultService resultService;
    @Autowired
    Gson gson;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> SaveResultMarks(@RequestParam Long quizId) {
        resultService.SaveResultMarks(quizId);
        String msg = "Saved Successful";
        String msgJson = gson.toJson(msg);
        return new ResponseEntity<>(msgJson, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<ResultDto> getResultMarks(@RequestParam Long quizId, @RequestParam Long createdById) {
        return resultService.getResultMarks(quizId, createdById);
    }

    @ResponseBody
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentdashboard.html");
        return mv;
    }
}
