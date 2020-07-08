package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    @FindBy(id = "email_create")
    private WebElement emailField;
    @FindBy(id = "SubmitCreate")
    private WebElement emailSubmit;
    @FindBy(id = "id_gender1")
    private WebElement genderButton;
    @FindBy(id = "customer_firstname")
    private WebElement fName;
    @FindBy(id = "customer_lastname")
    private WebElement lName;
    @FindBy(id = "customer_passwd")
    private WebElement pwd;
    @FindBy(id = "days")
    private Select daySelect;
    @FindBy(id = "months")
    private Select monthSelect;
    @FindBy(id = "years")
    private Select yearSelect;
    @FindBy(id = "firstname")
    private WebElement fNameAdd;
    @FindBy(id = "lastname")
    private WebElement lNameAdd;
    @FindBy(id = "address1")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private Select stateSelect;
    @FindBy(id = "postcode")
    private WebElement postalCode;
    @FindBy(id = "phone_mobile")
    private WebElement mobileNum;
    @FindBy(id = "submitAccount")
    private WebElement submitRegister;

    public void openMe() {
        driver.get(url);
    }

    public void submitRegisterForm() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        genderButton.click();
        fName.sendKeys("fName");
        lName.sendKeys("lName");
        pwd.sendKeys("1234567");
        daySelect.selectByValue("1");
        monthSelect.selectByValue("January");
        yearSelect.selectByValue("1999");
        fNameAdd.sendKeys("fName");
        lNameAdd.sendKeys("lName");
        address.sendKeys("StreetName");
        city.sendKeys("CityName");
        stateSelect.selectByIndex(5);
        postalCode.sendKeys("12345");
        mobileNum.sendKeys("333444555");
        submitRegister.click();
    }

    public String isTitleLogged() {
        return driver.getTitle();
    }

    public void createNewAcc(String email) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        emailField.sendKeys(email);
        emailSubmit.click();
    }
}
