package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-container")
    private List<WebElement> productList;

    public boolean isProductAvailable(String productTitle, String productPrice) {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        for (WebElement element : productList) {
            if (element.getText().contains(productTitle)) {
                return element.getText().contains(productPrice);
            }
        }
        return false;
    }

    public boolean isFoundProductListMatchQuery(String searchQuery) {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        for (WebElement element : productList) {
            if (element.getText().toLowerCase().contains(searchQuery.toLowerCase())) {
                continue;
            }
            else return false;
        }
        return true;
    }
}