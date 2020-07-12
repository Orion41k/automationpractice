package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String url = "http://automationpractice.com/index.php";
    Actions actions = new Actions(driver);

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

    @FindBy(xpath = "//a[@title='Blouse']")
    private WebElement blouseTitle;

    @FindBy(xpath = "//a[@data-id-product='2']")
    private WebElement addProductBlouse;

    @FindBy(xpath = "//a[@title='Printed Chiffon Dress']")
    private WebElement dressTitle;

    @FindBy(xpath = "//a[@data-id-product = '7']")
    private WebElement addProductDress;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueBtn1;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueBtn2;

    @FindBy(css = "div.layer_cart_cart")
    private WebElement productOverlay;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartDropDown;

    @FindBy(className = "cart_block_total")
    private WebElement cartTotalPrice;

    @FindBy(xpath = "//dt[1]/span/a")
    private WebElement removeFirstItemInCartButton;

    @FindBy(css = ".ajax_cart_quantity")
    private WebElement cartProductCounter;

    @FindBy(className = "shopping_cart")
    private WebElement cartProductList;

    @FindBy(css = ".products>dt[class*='item']")
    private List<WebElement> cartProductListReal;


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

    public boolean isAlertMatchesWithExpected(String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(alert));
        return alert.getText().equals(expectedText);
    }

    public void enterText(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearch() {
        searchSubmit.click();
    }

    public void addToCart() {

        actions.moveToElement(blouseTitle).perform();
        addProductBlouse.click();
        wait.until(ExpectedConditions.visibilityOf(continueBtn1));
        continueBtn1.click();
        actions.moveToElement(dressTitle).perform();
        addProductDress.click();
//        wait.until(ExpectedConditions.visibilityOf(productOverlay));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        continueBtn2.click();
    }

    public void removeFromCart() {
        wait.until(ExpectedConditions.visibilityOf(cartDropDown));
        actions.moveToElement(cartDropDown).perform();
        removeFirstItemInCartButton.click();
    }

    public boolean isCartPriceMatches(String expectedPrice) {
        actions.moveToElement(cartDropDown).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String shownPrice = cartTotalPrice.getText();
        return shownPrice.equals(expectedPrice);
    }

    public boolean isCartHasOneProduct() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        int size = cartProductListReal.size();
        return size == 1;
    }
}
