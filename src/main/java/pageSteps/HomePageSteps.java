package pageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;


import static pages.HomePage.FIRST_ORDER_BUTTON;
import static pages.HomePage.SECOND_ORDER_BUTTON;

public class HomePageSteps {
    private WebDriver driver;
    private HomePage homePage;

    public HomePageSteps(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    // Кнопка скрытия сообщения о куки
    private By cookieHidingButton = By.id("rcc-confirm-button");

    // Заголовок домашней страницы "Самокат на пару дней"
    private By homeHeader = By.className("Home_Header__iJKdX");

    // Список вопросов раздела "Вопросы о важном"
    private By listQuestions = By.className("accordion__item");

    // Актуальный ответ раздела "Вопросы о важном"
    private By ActualAnswer = By.xpath(".//div[@class = 'accordion__panel']");

    // Кнопка "Заказать" в верхней части домашней страницы
    private By orderButtonTopOfPage = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[1]");

    // Кнопка "Заказать" в нижней части домашней страницы
    private By orderButtonBottomOfPage = By.cssSelector(".Button_Middle__1CSJM");


    // Открыть домашнюю страницу браузера
    public void openPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(homeHeader));
    }


    // Скрыть сообщение о куки
    public void hideCookieMessage(){

        driver.findElement(cookieHidingButton).click();
    }

    // Найти список вопросов
    public void findListQuestions(int numberQuestion) {
        driver.findElements(listQuestions).get(numberQuestion).click();

    }

    // Найти текст актуального ответа
     public String getActualAnswer(int numberQuestion) {
        return driver.findElements(ActualAnswer).get(numberQuestion).getText();
    }

    // Нажать на кнопку "Заказать" в верхней части домашней страницы
    public void clickOrderButtonTopOfPage() {

        driver.findElement(orderButtonTopOfPage).click();
    }

    // Нажать на кнопку "Заказать" в нижней части домашней страницы
    public void clickOrderButtonBottomOfPage() {

        driver.findElement(orderButtonBottomOfPage).click();
    }

    // Выбор кнопки "Заказать"
    public void selectOrderButton(String valueOrderButton){
        if (valueOrderButton.equals(FIRST_ORDER_BUTTON)){
            clickOrderButtonTopOfPage();
        } else if (valueOrderButton.equals(SECOND_ORDER_BUTTON)){
            clickOrderButtonBottomOfPage();
        }
    }
}
