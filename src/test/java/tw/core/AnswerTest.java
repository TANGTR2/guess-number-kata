package tw.core;


import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_get_correct_answer_format_when_call_validate_given_1234(){
        try {
            actualAnswer.validate();
        } catch (AnswerFormatIncorrectException e) {
            fail("should given validate");
        }
    }

    @Test
    public void should_get_incorrect_answer_format_when_call_validate_given_012(){
        Answer answer = Answer.createAnswer("0 1 2");
        try {
            answer.validate();
        } catch (AnswerFormatIncorrectException e) {
        }
    }


    @Test
    public void should_get_incorrect_answer_format_when_call_validate_given_12345(){
        Answer answer = Answer.createAnswer("1 2 3 4 5");
        try {
            answer.validate();
        } catch (AnswerFormatIncorrectException e) {
            fail("should given validate");
        }
    }
}