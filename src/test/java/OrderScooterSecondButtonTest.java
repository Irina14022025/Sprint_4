import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterSecondButtonTest extends BaseTest {
    private String valueName;
    private String valueLastname;
    private String valueAddress;
    private String valueStation;
    private String valuePhone;
    private String valueOrderDate;
    private int valueRentalPeriod;
    private String valueColour;
    private String valueComment;

    public OrderScooterSecondButtonTest(String valueName, String valueLastname, String valueAddress, String valueStation, String valuePhone,
                                        String valueOrderDate, int valueRentalPeriod, String valueColour, String valueComment) {
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
                {"Галина", "Васнецова", "ул. Школьная", "Лубянка", "88005553535", "24.03.2025", 1, "grey", "Вход со двора"},
                {"Юра", "Борисов", "ул. Весенняя", "Румянцево", "+79009009090", "25.03.2025", 5, "black", "Осторожно, злая собака!"}
        };
    }

    @Test
    public void orderButtonSecondTest() {
        homePageSteps.openPage();
        homePageSteps.hideCookieMessage();
        homePageSteps.clickOrderButtonBottomOfPage();
        firstOrderFormPageSteps.waitForLoadFirstOrderForm();
        firstOrderFormPageSteps.inputAllFieldFirstOrderForm(valueName, valueLastname, valueAddress, valueStation, valuePhone);
        firstOrderFormPageSteps.clickFurtherButtonFirstOrderForm();
        secondOrderFormPageSteps.waitForLoadSecondOrderForm();
        secondOrderFormPageSteps.inputAllFieldSecondOrderForm(valueOrderDate, valueRentalPeriod, valueColour, valueComment);
        secondOrderFormPageSteps.clickOrderButtonSecondOrderForm();
        secondOrderFormPageSteps.clickYesButtonForOrderconfirm();
        WebElement element = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']"));
        assertTrue("Окно об успешном создании заказа не найдено", element.isDisplayed());
    }
}
