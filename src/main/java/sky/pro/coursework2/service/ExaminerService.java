package sky.pro.coursework2.service;

import sky.pro.coursework2.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);
}
