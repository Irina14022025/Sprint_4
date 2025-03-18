import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;
import static pages.HomePage.FIRST_ORDER_BUTTON;
import static pages.HomePage.SECOND_ORDER_BUTTON;

@RunWith(Parameterized.class)
public class OrderScooterButtonTest extends BaseTest {
    private String valueOrderButton;
    private String valueName;
    private String valueLastname;
    private String valueAddress;
    private String valueStation;
    private String valuePhone;
    private String valueOrderDate;
    private int valueRentalPeriod;
    private String valueColour;
    private String valueComment;

    public OrderScooterButtonTest(String valueOrderButton, String valueName, String valueLastname, String valueAddress, String valueStation, String valuePhone,
                                  String valueOrderDate, int valueRentalPeriod, String valueColour, String valueComment) {
        this.valueOrderButton = valueOrderButton;
        this.valueName = valueName;
        this.valueLastname = valueLastname;
        this.valueAddress = valueAddress;
        this.valueStation = valueStation;
        this.valuePhone = valuePhone;
        this.valueOrderDate = valueOrderDate;
        this.valueRentalPeriod = valueRentalPeriod;
        this.valueColour = valueColour;
        this.valueComment = valueComment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderValues() {
        return new Object[][]{
                {FIRST_ORDER_BUTTON, "Галина", "Васнецова", "ул. Школьная", "Лубянка", "88005553535", "24.03.2025", 1, "grey", "Вход со двора"},
                {SECOND_ORDER_BUTTON, "Юра", "Борисов", "ул. Весенняя", "Румянцево", "+79009009090", "25.03.2025", 5, "black", "Осторожно, злая собака!"}
        };
    }

    @Test
    public void orderButtonSecondTest() {
        homePageSteps.openPage();
        homePageSteps.hideCookieMessage();
        homePageSteps.selectOrderButton(valueOrderButton);
        firstOrderFormPageSteps.waitForLoadFirstOrderForm();
        firstOrderFormPageSteps.inputAllFieldFirstOrderForm(valueName, valueLastname, valueAddress, valueStation, valuePhone);
        firstOrderFormPageSteps.clickFurtherButtonFirstOrderForm();
        secondOrderFormPageSteps.waitForLoadSecondOrderForm();
        secondOrderFormPageSteps.inputAllFieldSecondOrderForm(valueOrderDate, valueRentalPeriod, valueColour, valueComment);
        secondOrderFormPageSteps.clickOrderButtonSecondOrderForm();
        secondOrderFormPageSteps.clickYesButtonForOrderconfirm();
        assertEquals("Окно об успешном создании заказа не найдено", "Посмотреть статус", secondOrderFormPageSteps.findStatusButtonForOrderCreation());
    }
}
