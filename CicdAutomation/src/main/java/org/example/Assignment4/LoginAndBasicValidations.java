package org.example.Assignment4;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class LoginAndBasicValidations {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C://Users/sahaj/ChromeForTest/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/sahaj/ChromeForTest/chrome-win64/chrome.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/v1/");

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordFiled = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        //Providing username
        usernameField.sendKeys("standard_user");
        //Providing password
        passwordFiled.sendKeys("secret_sauce");
        //Click on login button
        loginButton.click();

        WebElement logoSwagLabs = driver.findElement(By.xpath("//div[@class='app_logo']"));
        boolean logoSwagLabsDisplayeddisplayed = logoSwagLabs.isDisplayed();

        //Verifying that "Swag Labs" is displayed on the top of the page
        Assert.isTrue(logoSwagLabsDisplayeddisplayed, "Logo is not displayed");

        WebElement sortDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        boolean sortDropdownDisplayed = sortDropdown.isDisplayed();

        //Verifying that sorting dropdown is displayed
        Assert.isTrue(sortDropdownDisplayed, "SortDropdown is not displayed");




    }
}
