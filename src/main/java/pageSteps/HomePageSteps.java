package pageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

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

    // Нажать на актуальный вопрос
    public void findListQuestion(int numberQuestion) {
        driver.findElement(By.xpath(".//div[@class = 'accordion']/div["+ numberQuestion +"]")).click();
    }

    // Получить тест актуального ответа
    public String getActualAnswer(int numberQuestion) {
        return driver.findElement(By.xpath(".//div[@class = 'accordion']/div["+ numberQuestion +"]/div[2]")).getText();
    }

    // Нажать на кнопку "Заказать" в верхней части домашней страницы
    public void clickOrderButtonTopOfPage() {
        driver.findElement(orderButtonTopOfPage).click();
    }

    // Нажать на кнопку "Заказать" в нижней части домашней страницы
    public void clickOrderButtonBottomOfPage() {
        driver.findElement(orderButtonBottomOfPage).click();
    }
}
