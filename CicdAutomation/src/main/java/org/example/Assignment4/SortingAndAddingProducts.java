package org.example.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SortingAndAddingProducts {
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

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

        //Selecting 'Name(Z to A)' from dropdown menu
        dropdown.selectByIndex(1);

        WebElement sauceLabsBackpack = driver.findElement(By.xpath(""));
        WebElement sauceLabsBikeLight = driver.findElement(By.xpath(""));
        WebElement sauceLabsBoltTShirt = driver.findElement(By.xpath(""));
        WebElement sauceLabsFleeceJacket = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
        WebElement sauceLabsOnesie = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
        WebElement sauceLabsBTestAllTShirt= driver.findElement(By.xpath(""));


    }
}
