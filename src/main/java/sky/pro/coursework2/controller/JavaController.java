package sky.pro.coursework2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework2.model.Question;
import sky.pro.coursework2.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/java")


public class JavaController {

    private final JavaQuestionService ques;

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return ques.add(question1);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return ques.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return ques.getAll();
    }

    @GetMapping("/Find")
    public Question find(@RequestParam String question) {
        return ques.find(question);
    }

}
