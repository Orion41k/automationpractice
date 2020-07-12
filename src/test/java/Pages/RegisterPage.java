package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage  {
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
    private WebElement firstName;
    @FindBy(id = "customer_lastname")
    private WebElement lastName;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "days")
    private WebElement daySelect;
    @FindBy(id = "months")
    private WebElement monthSelect;
    @FindBy(id = "years")
    private WebElement yearSelect;
    @FindBy(id = "firstname")
    private WebElement firstNameAddress;
    @FindBy(id = "lastname")
    private WebElement lNameAddress;
    @FindBy(id = "address1")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "id_state")
    private WebElement stateSelect;
    @FindBy(id = "postcode")
    private WebElement postalCode;
    @FindBy(id = "phone_mobile")
    private WebElement mobileNum;
    @FindBy(id = "submitAccount")
    private WebElement submitRegister;

    public void openMe() {
        driver.get(url);
    }
    public void submitRegisterForm(String inputFirstname, String inputLastname, String inputPassword, String inputDayOfBirth, String inputMonthOfBirth, String inputYearOfBirth, String inputAddress, String inputCity, String inputPostalCode, String inputMobileNumber) {
        wait.until(ExpectedConditions.visibilityOf(genderButton));
        Select daySelectS = new Select(daySelect);
        Select monthSelectS = new Select(monthSelect);
        Select yearSelectS = new Select(yearSelect);
        Select stateSelectS = new Select(stateSelect);
        genderButton.click();
        firstName.sendKeys(inputFirstname);
        lastName.sendKeys(inputLastname);
        password.sendKeys(inputPassword);
        daySelectS.selectByValue(inputDayOfBirth);
        monthSelectS.selectByValue(inputMonthOfBirth);
        yearSelectS.selectByValue(inputYearOfBirth);
        firstNameAddress.sendKeys(inputFirstname);
        lNameAddress.sendKeys(inputLastname);
        address.sendKeys(inputAddress);
        city.sendKeys(inputCity);
        stateSelectS.selectByIndex(5);
        postalCode.sendKeys(inputPostalCode);
        mobileNum.sendKeys(inputMobileNumber);
        submitRegister.click();
    }
    public String isTitleLogged() {
        return driver.getTitle();
    }
    public void createNewAcc(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        emailSubmit.click();
    }
}
