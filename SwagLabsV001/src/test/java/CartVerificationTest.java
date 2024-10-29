import org.example.HomePage;
import org.example.LoginPage;
import org.example.YourCartPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CartVerificationTest extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(CartVerificationTest.class);
    private LoginPage loginPage;
    private HomePage homePage;
    private YourCartPage yourCartPage;


    @Test
    public void testCartVerification() throws InterruptedException {
        log.info("---------- Running testCartVerification -----------");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        yourCartPage = new YourCartPage(driver);

        //Login with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");

        //Adding products to cart by product name
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Bolt T-Shirt");
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.addProductToCart("Test.allTheThings() T-Shirt (Red)");

        //Navigating to Your Cart Page
        homePage.navigatToYourCartPage();

        //Displaying all the products in the cart by producat name
        List<String> actualProducts = yourCartPage.displayProductsInCart();
        List<String> expectedProducts = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        );
        //  Verify the actual count matches expected
        Assert.assertEquals(actualProducts.size(), expectedProducts.size(), "The number of products in the cart does not match the expected count.");

        //Assert that all expected products are added in the cart
        Assert.assertTrue(actualProducts.containsAll(expectedProducts),"This cart does not contain all the expected products");

        log.info("--------- Closing testCartVerification ---------");




    }
}
