package my.test.Page;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class POMTests extends BaseTest {


    @Test
    @DisplayName("Check page behavior when user opens home page via url")
    void WhenUserOpensHomePageTitleShouldBePresent() {
        //Given
        String expectedTitle = "My Store";
        //When
        fakeStore.homePage().openMe();
        //Then
        Assertions.assertEquals(fakeStore.homePage().pageTitle(), expectedTitle);
        Assertions.assertTrue(fakeStore.homePage().checkSlider());
    }

    @Test
    @DisplayName("Check newsletter subscription with registered email via “Enter” key")
    void WhenUserSubscribesWithExistingEmailThenAlertShouldBeDisplayed() {
        //Given
        String validExistingEmail = "asdasd@asd.asd";
        String alertExistingEmailText = "Newsletter : This email address is already registered.";
        //When
        fakeStore.homePage().openMe();
        fakeStore.homePage().enterEmail(validExistingEmail);
        fakeStore.homePage().clickEnterKeyboard();
        //Then
        Assertions.assertTrue(fakeStore.homePage().isAlertMatchesWithExpected(alertExistingEmailText));
    }

    @Test
    @DisplayName("Check search functionality when user enters name of the existing product")
    void WhenUserSearchesThenProductShouldBeDisplayed() {
        //Given
        String searchText = "t-shirt";
        String expectedItemTitle = "Faded Short Sleeve T-shirts";
        String expectedItemPrice = "$16.51";
        //When
        fakeStore.homePage().openMe();
        fakeStore.homePage().enterText(searchText);
        fakeStore.homePage().clickSearch();
        //Then
        Assertions.assertTrue(fakeStore.resultsPage().isProductAvailable(expectedItemTitle, expectedItemPrice));
    }

    //CASE #4
    @Test
    @DisplayName("Check remove functionality from drop-down cart on Home Page")
    void WhenUserRemovesItemFromCartThenItemShouldBeRemoved() {
        //Given
        String itemName = "Printed Chiffon Dress";
        String totalPrice = "$18.40";
        String expectedResult = "true";
        //When
        fakeStore.homePage().openMe();
        fakeStore.homePage().addToCart();
        fakeStore.homePage().removeFromCart();
        //Then
        Assertions.assertTrue(fakeStore.homePage().isCartPriceMatches(totalPrice));
        Assertions.assertTrue(fakeStore.homePage().isCartHasOneProduct());

    }

    @Test
    @DisplayName("Check system behavior when user creates an account with non-registered valid email")
    void WhenUserCreateNewAccountThenAccountShouldBeCreated() {
        //Given
        double suffix = Math.random();
        String newEmail = "new@ema.il"+suffix;
        String expectedTitle = "My account - My Store";
        //When
        fakeStore.registerPage().openMe();
        fakeStore.registerPage().createNewAcc(newEmail);
        fakeStore.registerPage().submitRegisterForm();
        //Then
        Assertions.assertEquals(expectedTitle, fakeStore.registerPage().isTitleLogged());
    }

    @Test
    @DisplayName("Check search functionality if found products match query")
    void WhenUserSearchesThenFoundProductMatchesQuery() {
        //Given
        String searchText = "dress";
        //When
        fakeStore.homePage().openMe();
        fakeStore.homePage().enterText(searchText);
        fakeStore.homePage().clickSearch();
        //Then
        Assertions.assertTrue(fakeStore.resultsPage().isFoundProductListMatchQuery(searchText));
    }
}
