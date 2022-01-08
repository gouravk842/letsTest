package com.letsTest.controller;

import com.letsTest.dto.QuizDto;
import com.letsTest.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exam")
public class examinationController {
    @Autowired
    ExaminationService examinationService;

    @ResponseBody
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("examinationDashboard.html");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/start/{id}", method = RequestMethod.GET)
    public QuizDto startExam(@PathVariable(value = "id") Long id) {
        return examinationService.startExam(id);
    }
}
