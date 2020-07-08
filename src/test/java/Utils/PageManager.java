package Utils;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.ResultsPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    public PageManager(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;

    private HomePage homePage;

    public HomePage homePage() {
        if (homePage == null) {
            return homePage = new HomePage(driver);
        } else {
            return homePage;
        }
    }

    private ResultsPage resultsPage;
    public ResultsPage resultsPage() {
        if (resultsPage == null) {
            return resultsPage = new ResultsPage(driver);
        } else {
            return resultsPage;
        }
    }

    private RegisterPage registerPage;
    public RegisterPage registerPage() {
        if (registerPage == null) {
            return registerPage = new RegisterPage(driver);
        } else {
            return registerPage;
        }
    }
}
