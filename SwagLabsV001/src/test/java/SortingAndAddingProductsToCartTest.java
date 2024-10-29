import org.example.HomePage;
import org.example.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingAndAddingProductsToCartTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void testSortingAndAddingProductsToCart() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        //Login with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");

        //Sorting Dropdown -> Z to A --- (0-Name(A-Z), 1-Name(Z-A), 2-Price(low to high), 3-Price(high to low)) ---
        homePage.sortDropdownByIndex(1);

        //Adding products By Products name
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Bolt T-Shirt");
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.addProductToCart("Test.allTheThings() T-Shirt (Red)");

        int cartItemCount = homePage.getCartItemCount();

        //Asserting 6 products are diplayed in the cart
        Assert.assertEquals(cartItemCount, 6,"The cart should contain 6 items");


        Thread.sleep(9000);



    }
}
