import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageSteps.FirstOrderFormPageSteps;
import pageSteps.HomePageSteps;
import pageSteps.SecondOrderFormPageSteps;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageSteps homePageSteps;
    protected FirstOrderFormPageSteps firstOrderFormPageSteps;
    protected SecondOrderFormPageSteps secondOrderFormPageSteps;


    @Before
    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        homePageSteps = new HomePageSteps(driver);
        firstOrderFormPageSteps = new FirstOrderFormPageSteps(driver);
        secondOrderFormPageSteps = new SecondOrderFormPageSteps(driver);
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
