package com.letsTest.controller;

import com.letsTest.dto.ResultDto;
import com.letsTest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/results")
public class StudentController {

    @Autowired
    ResultService resultService;

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public String SaveResultMarks(@RequestBody ResultDto resultDto){
        return resultService.SaveResultMarks(resultDto);
    }

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public List<ResultDto> getResultMarks(@RequestParam Long quizId, @RequestParam Long createdById){
        return resultService.getResultMarks(quizId,createdById);
    }
}
