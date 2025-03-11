package pageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FirstOrderFormPage;
import pages.HomePage;

import java.time.Duration;

public class FirstOrderFormPageSteps {
    private WebDriver driver;
    private FirstOrderFormPage firstOrderFormPage;

    public FirstOrderFormPageSteps(WebDriver driver){
        this.driver = driver;
        firstOrderFormPage = new FirstOrderFormPage(driver);
    }

    // Заголовок страницы первой формы заказа "Для кого самокат"
    private By firstOrderHeader = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Для кого самокат']");

    // Поле "Имя"
    private By fieldNameOrderForm = By.xpath(".//input[@placeholder = '* Имя']");

    // Поле "Фамилия"
    private By fieldLastnameOrderForm = By.xpath(".//input[@placeholder = '* Фамилия']");

    // Поле "Адрес"
    private By fieldAddressOrderForm = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private By fieldStationOrderForm = By.xpath(".//input[@placeholder = '* Станция метро']");

    // Станция из выпадающего списка
    private By dropdownListStation = By.xpath(".//div[@class = 'select-search__select']");

    // Поле "Телефон: на него позвонит курьер"
    private By fieldPhoneOrderForm = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Кнопка "Далее" первой формы заказа
    private By furtherButtonFirstOrderForm = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button");


    // Подождали, пока загрузится форма заказа "Для кого самокат"
    public void waitForLoadFirstOrderForm() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(firstOrderHeader));
    }

    // Заполнили поле "Имя"
    public void inputFieldNameOrderForm(String name) {
        driver.findElement(fieldNameOrderForm).clear();
        driver.findElement(fieldNameOrderForm).sendKeys(name);
    }

    // Заполнили поле "Фамилия"
    public void inputFieldlastnameOrderForm(String lastname) {
        driver.findElement(fieldLastnameOrderForm).clear();
        driver.findElement(fieldLastnameOrderForm).sendKeys(lastname);
    }

    // Заполнили поле "Адрес: куда привезти заказ"
    public void inputFieldAddressOrderForm(String address) {
        driver.findElement(fieldAddressOrderForm).clear();
        driver.findElement(fieldAddressOrderForm).sendKeys(address);
    }

    // Заполнили поле "Станция метро"
    public void inputFieldStationOrderForm(String station) {
        driver.findElement(fieldStationOrderForm).clear();
        driver.findElement(fieldStationOrderForm).sendKeys(station);
        driver.findElement(dropdownListStation).click();
    }

    // Заполнили поле "Телефон: на него позвонит курьер"
    public void inputFieldPhoneOrderForm(String phone) {
        driver.findElement(fieldPhoneOrderForm).clear();
        driver.findElement(fieldPhoneOrderForm).sendKeys(phone);
    }

    // Нажали на кнопку "Далее" формы "Для кого самокат"
    public void clickFurtherButtonFirstOrderForm(){
        driver.findElement(furtherButtonFirstOrderForm).click();
    }

    // Заполнили все поля формы "Для кого самокат"
    public void inputAllFieldFirstOrderForm(String name, String lastname, String address, String station, String phone) {
        inputFieldNameOrderForm(name);
        inputFieldlastnameOrderForm(lastname);
        inputFieldAddressOrderForm(address);
        inputFieldStationOrderForm(station);
        inputFieldPhoneOrderForm(phone);
    }
}
