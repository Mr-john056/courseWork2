package sky.pro.coursework2.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sky.pro.coursework2.exception.FullSetException;
import sky.pro.coursework2.model.Question;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    @Override
    public Set<Question> getQuestion(int amount) {
        if (amount > questionService.size()) {
            throw new FullSetException("Максимальное количество вопросов = " + questionService.size());
        }

        Set<Question> list = new HashSet<>();
        while (list.size() < amount) {
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
