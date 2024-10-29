import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAndBasicValidationsTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void testLogin(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        //Login in with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");
        //Validate "Swag Labs" is displayed
        Assert.assertEquals(homePage.getProductPageTitle(),"Swag Labs");
        //Validate sorting dropdown is visible
        Assert.assertTrue(homePage.getSortingDropdown());
    }
}
