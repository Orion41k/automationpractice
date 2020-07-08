package my.test.Page;

import Utils.PageManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    protected PageManager fakeStore;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }
//    static void beforeAll()    {  WebDriverManager.firefoxdriver().setup();   }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        fakeStore = new PageManager(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
