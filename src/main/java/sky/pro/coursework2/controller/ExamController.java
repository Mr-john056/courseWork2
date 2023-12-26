package sky.pro.coursework2.controller;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework2.model.Question;
import sky.pro.coursework2.service.ExaminerService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/get")

public class ExamController {

    private final ExaminerService examinerService;


    @GetMapping("{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }

}
