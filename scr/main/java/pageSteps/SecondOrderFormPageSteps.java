package pageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstOrderFormPage;
import pages.SecondOrderFormPage;

import java.time.Duration;

public class SecondOrderFormPageSteps {
    private WebDriver driver;
    private SecondOrderFormPage secondOrderFormPage;

    public SecondOrderFormPageSteps(WebDriver driver){
        this.driver = driver;
        secondOrderFormPage = new SecondOrderFormPage(driver);
    }

    // Заголовок страницы второй формы заказа "Про аренду"
    private By secondOrderHeader = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Про аренду']");

    // Поле "Когда привезти самокат"
    private By fieldDateOrderForm = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Выбранная дата календаря поля "Когда привезти самокат"
    private By selectedCalendarDate = By.cssSelector(".react-datepicker__day--selected");

    // Поле "Срок аренды"
    private By fieldRentalPeriodOrderForm = By.xpath(".//div[text() = '* Срок аренды']");

    // Поле "Комментарий для курьера"
    private By fieldCommentOrderForm = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Кнопка "Заказать" в форме "Про аренду"
    private By orderButtonSecondOrderForm = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");

    // Кнопка "Да" во всплывающем окне "Хотите оформить заказ?"
    private By yesButtonForOrderconfirmation = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");

    // Заголовок "Заказ ооформлен" во всплывающем окне при успешном создании заказа
    private By headerForSuccessfulOrderCreation = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");


    // Подождали, пока загрузится форма заказа "Про аренду"
    public void waitForLoadSecondOrderForm() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(secondOrderHeader));
    }

    // Заполнили поле "Когда привезти самокат"
    public void inputFieldDateOrderForm(String DateOrder) {
        driver.findElement(fieldDateOrderForm).clear();
        driver.findElement(fieldDateOrderForm).sendKeys(DateOrder);
        driver.findElement(selectedCalendarDate).click();
    }

    // Заполнили поле "Срок аренды"
    public void inputFieldRentalPeriodOrderForm(int rentalPeriod) {
        driver.findElement(fieldRentalPeriodOrderForm).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-menu']/div["+ rentalPeriod +"]")).click();
    }

    // Указали цвет самоката
    public void choiceColourScooter(String colourScooter) {
        driver.findElement(By.id("" + colourScooter + "")).click();
    }

    // Заполнили поле "Комментарий для курьера"
    public void inputFieldCommentOrderForm(String comment) {
        driver.findElement(fieldCommentOrderForm).clear();
        driver.findElement(fieldCommentOrderForm).sendKeys(comment);
    }

    // Нажали на кнопку "Заказать" из формы "Про аренду"
    public void clickOrderButtonSecondOrderForm() {
        driver.findElement(orderButtonSecondOrderForm).click();
    }

    // Подтвердили создание заказа
    public void clickYesButtonForOrderconfirm(){
        driver.findElement(yesButtonForOrderconfirmation).click();
    }

    // Нашли заголовок "Заказ ооформлен" во всплывающем окне при успешном создании заказа
    public void findHeaderForSuccessfulOrderCreation(){
        driver.findElement(headerForSuccessfulOrderCreation);
    }

    // Заполнили все поля формы "Про аренду"
    public void inputAllFieldSecondOrderForm(String DateOrder, int rentalPeriod, String colourScooter, String comment){
        inputFieldDateOrderForm(DateOrder);
        inputFieldRentalPeriodOrderForm(rentalPeriod);
        choiceColourScooter(colourScooter);
        inputFieldCommentOrderForm(comment);
    }
}
