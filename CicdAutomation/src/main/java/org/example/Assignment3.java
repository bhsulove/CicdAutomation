package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment3 {
    private static WebDriver driver;
    private static WebDriverWait myWait;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C://Users/sahaj/ChromeForTest/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/sahaj/ChromeForTest/chrome-win64/chrome.exe");

        driver = new ChromeDriver(options);
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.sakraworldhospital.com/");

        String originalWindow = driver.getWindowHandle();

        // Link Home Health Care
        WebElement buttonHomeHealthCare = driver.findElement(By.xpath("//a[@class='top-nav-btn bgclr-c'][normalize-space()='Home Health Care']"));
        buttonHomeHealthCare.click();
        driver.switchTo().window(originalWindow);

        //Link Sakra Premium Clinic
        WebElement buttonSakraPremiumClinic = driver.findElement(By.linkText("Sakra Premium Clinic"));
        buttonSakraPremiumClinic.click();
        driver.switchTo().window(originalWindow);

        //Link Sakra Clinic
        WebElement buttonSakraClinic = driver.findElement(By.cssSelector("div[class='right-nav'] a:nth-child(3)"));
        buttonSakraClinic.click();
        driver.switchTo().window(originalWindow);

        //Link Robotic Surgery
        WebElement buttonRoboticSurgery = driver.findElement(By.partialLinkText("Robotic Surge"));
        buttonRoboticSurgery.click();
        driver.switchTo().window(originalWindow);

        Actions actions = new Actions(driver);
        // Initial actions...
        WebElement flyoutMenu = driver.findElement(By.xpath("//div[@class='sidebar-dropdown']//div[@class='hamburger-menu']"));
        WebElement menuCareers = driver.findElement(By.xpath("//a[@class='side-menu-item'][normalize-space()='Careers']"));
        WebElement menuOraganTransAuth = driver.findElement(By.xpath("//a[@class='side-menu-item'][normalize-space()='Organ Transplant Authorization']"));
        // Hover on flyout menu and clik 'Careers'
        actions.moveToElement(flyoutMenu).moveToElement(menuCareers).click().perform();
        driver.navigate().back();

       /* actions.moveToElement(flyoutMenu).moveToElement(menuOraganTransAuth).click().perform();
        driver.navigate().back();  */

        driver.findElement(By.xpath("//div[@id='carousel-banner']//span[@aria-label='Next'][contains(text(),'›')]")).click();
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bann-form']//div[@class='helpNum-holder']")));
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='newTab']")));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bann-form']//p[@class='help-msg'][normalize-space()='How can we help you today?']")));

        //Select Book an Appointment
        dropdown.selectByVisibleText("Book an Appointment");
        driver.switchTo().window(originalWindow);

        //Select Request Medical Records
       /* myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bann-form']//div[@class='helpNum-holder']")));
        dropdown.selectByVisibleText("Pay My Bills");
        driver.switchTo().window(originalWindow);*/

        WebElement aboutUs = driver.findElement(By.linkText("About Us"));
        WebElement qualityAndSafety = driver.findElement(By.xpath("//a[contains(text(),'Quality & Safety')]"));

        //Hover to About Us and click 'Quality & Safety'
        actions.moveToElement(aboutUs).moveToElement(qualityAndSafety).click().perform();

        driver.quit();


    }


}
