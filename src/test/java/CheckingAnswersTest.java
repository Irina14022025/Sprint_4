
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;
import static pages.HomePage.*;

@RunWith(Parameterized.class)
public class CheckingAnswersTest extends BaseTest {
    private int numberQuestion;
    private String expectedText;

    public CheckingAnswersTest(int numberQuestion, String expectedText){
        this.numberQuestion = numberQuestion;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][] {
                { 0, FIRST_ANSWER},
                { 1, SECOND_ANSWER},
                { 2, THIRD_ANSWER},
                { 3, FOURTH_ANSWER},
                { 4, FIFTH_ANSWER},
                { 5, SIXTH_ANSWER},
                { 6, SEVENTH_ANSWER},
                { 7, EIGHTH_ANSWER}
        };

    }

    @Test
    public void checkActivity() {

        homePageSteps.openPage();
        homePageSteps.hideCookieMessage();
        homePageSteps.findListQuestions(numberQuestion);
        String actualText = homePageSteps.getActualAnswer(numberQuestion);
        assertEquals("Ожидаемый ответ отличается от фактического", expectedText, actualText);

    }
}


