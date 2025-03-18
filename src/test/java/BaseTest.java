import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageSteps.FirstOrderFormPageSteps;
import pageSteps.HomePageSteps;
import pageSteps.SecondOrderFormPageSteps;
import pages.HomePage;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    protected HomePageSteps homePageSteps;
    protected FirstOrderFormPageSteps firstOrderFormPageSteps;
    protected SecondOrderFormPageSteps secondOrderFormPageSteps;

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        homePageSteps = new HomePageSteps(driver);
        firstOrderFormPageSteps = new FirstOrderFormPageSteps(driver);
        secondOrderFormPageSteps = new SecondOrderFormPageSteps(driver);
    }

    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        homePageSteps = new HomePageSteps(driver);
        firstOrderFormPageSteps = new FirstOrderFormPageSteps(driver);
        secondOrderFormPageSteps = new SecondOrderFormPageSteps(driver);
    }


    @Before
    public void initBrowser(){
        String browser = "chrome";
        if (browser.equals("chrome")){
            startBrowserChrome();
        } else if (browser.equals("firefox")){
            startBrowserFirefox();
        }
    }




    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
