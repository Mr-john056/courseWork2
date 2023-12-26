package sky.pro.coursework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sky.pro.coursework2.exception.QuestionNotFound;
import sky.pro.coursework2.model.Question;
import sky.pro.coursework2.service.JavaQuestionService;
import sky.pro.coursework2.service.QuestionService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {

    QuestionService out = new JavaQuestionService();

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of("Вопрос 1", "Ответ 1"),
                Arguments.of("Вопрос 2", "Ответ 2"),
                Arguments.of("Вопрос 3", "Ответ 3")
        );
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTest")
    public void addTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.getAll().contains(new Question(question, answer)));
    }

    @Test
    public void addTestWhenIsElement() {
        out.add("Вопрос 4", "Ответ 4");
        assertThrows(IllegalArgumentException.class, () -> {
            out.add("Вопрос 4", "Ответ 4");
        });
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void removeTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.remove(new Question(question, answer))
                .equals(new Question(question, answer)));
        assertThrows(QuestionNotFound.class, () ->
                out.find(question));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void getAllTest(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.getAll().contains(new Question(question, answer)));
        assertEquals(out.getAll().size(), 11);
    }

    @Test
    public void findTest() {
        out.add("Вопрос 4", "Ответ 4");
        assertEquals(out.find("Вопрос 4"),
                new Question("Вопрос 4", "Ответ 4"));
        assertThrows(QuestionNotFound.class, () ->
                out.find("Вопрос"));
    }
}
