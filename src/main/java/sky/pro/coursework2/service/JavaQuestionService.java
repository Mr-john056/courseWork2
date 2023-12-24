package sky.pro.coursework2.service;

import sky.pro.coursework2.exception.QuestionNotFound;
import sky.pro.coursework2.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final ArrayList<Question> listQuestion = new ArrayList<>(List.of());

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (listQuestion.contains(question)) {
            throw new IllegalArgumentException("Данный вопрос уже есть в списке");
        }
        listQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (listQuestion.remove(question)) {
            return question;
        }
        throw new QuestionNotFound("Элемента нет в списке");
    }

    @Override
    public Collection<Question> getAll() {
        return listQuestion;
    }

    @Override
    public Question find(String question) {
        return listQuestion.stream()
                .filter(e -> e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(QuestionNotFound::new);
    }

    @Override
    public Question getRandomQuestion() {
        int i = random.nextInt(listQuestion.size());

        return listQuestion.get(i);
    }

    @Override
    public int size() {
        return listQuestion.size();
    }

}
