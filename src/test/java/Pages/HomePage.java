package Pages;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String url = "http://automationpractice.com/index.php";

    @FindBy(id = "homepage-slider")
    private WebElement slider;

    @FindBy(id = "newsletter-input")
    private WebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    private WebElement newsletterSubmit;

    @FindBy(css = ".alert")
    private WebElement alert;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchSubmit;

//    // CASE #4
//    @FindBy(xpath = "//a[@data-id-product = '2']")
//    private WebElement addProduct1;
//
//    @FindBy(xpath = "//a[@data-id-product = '7']")
//    private WebElement addProduct2;
//
//    @FindBy(linkText = "Continue Shopping")
//    private WebElement continueBtn;
//
//    @FindBy(className = "cart_block_total")
//    private WebElement cartTotalPrice;
//
//    @FindBy(xpath = "//dt[1]/span/a")
//    private WebElement removeFirstItemInCartButton;
//
//    @FindBy(className = "ajax_cart_quantity")
//    private WebElement cartProductCounter;
//
//    @FindBy(className = "cart_block_list")
//    private WebElement cartProductList;

//    @FindBy(css = ".products>dt")
//    private List<WebElement> cartProductListReal;


    public void openMe() {
        driver.get(url);
    }

    public boolean checkSlider() {
        return slider.isDisplayed();
    }

    public String pageTitle() {
        return driver.getTitle();
    }


    public void enterEmail(String email) {
        newsletterInput.sendKeys(email);
    }

    public void clickEnterKeyboard() {
        newsletterInput.sendKeys(Keys.ENTER);
    }

    public boolean isAlertDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alert));
        return alert.isDisplayed();
    }

    public void enterText(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearch() {
        searchSubmit.click();
    }

//    // CASE #4
//    public void addToCart() {
//        addProduct1.click();
//        continueBtn.click();
//        addProduct2.click();
//        continueBtn.click();
//    }
//
//    public void removeFromCart() {
//        removeFirstItemInCartButton.click();
//    }
//
//    public String getCartTotalPrice() {
//        return cartTotalPrice.getText();
//    }
//
//    public boolean isItemInCart(String itemName) {
//        if (cartProductCounter.getText() != "1") {
//            return false;
//        }
//        return cartProductList.getText().contains(itemName);
//    }
}
