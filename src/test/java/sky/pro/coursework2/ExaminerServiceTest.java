package sky.pro.coursework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.coursework2.exception.FullSetException;
import sky.pro.coursework2.model.Question;
import sky.pro.coursework2.service.ExaminerServiceImpl;
import sky.pro.coursework2.service.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;


    public static final Question QUESTION_1 = new Question("Вопрос 1", "Ответ 1");
    public static final Question QUESTION_2 = new Question("Вопрос 2", "Ответ 2");
    public static final Question QUESTION_3 = new Question("Вопрос 3", "Ответ 3");
    public static final Question QUESTION_4 = new Question("Вопрос 4", "Ответ 4");
    public static final Question QUESTION_5 = new Question("Вопрос 5", "Ответ 5");


    @Test
    public void getQuestionTestOnThrow() {
        when(questionService.size()).thenReturn(5);
        assertThrows(FullSetException.class, () -> out.getQuestion(7));
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5);
        when(questionService.size()).thenReturn(10);
        assertEquals(out.getQuestion(5).size(), 5);
    }

    @Test
    public void getQuestionTestOnContains() {
        when(questionService.getRandomQuestion());
    }
}
