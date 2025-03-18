package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    // Тексты ответов на вопросы о важном
    public static final String FIRST_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SECOND_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String THIRD_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String FOURTH_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String FIFTH_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String SIXTH_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String SEVENTH_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String EIGHTH_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    // Вожможные варианты для вызова кнопок "Заказать"
    public static final String FIRST_ORDER_BUTTON = "Верхняя кнопка заказа";
    public static final String SECOND_ORDER_BUTTON = "Нижняя кнопка заказа";


    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

}
