package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class LaunchBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C://Users/sahaj/ChromeForTest/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/sahaj/ChromeForTest/chrome-win64/chrome.exe");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.google.com");

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Testing");

//        String windowHandle = driver.getWindowHandle();
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        for(String windowHandles : allWindowHandles) {
//            if(!windowHandle.equals(windowHandle)) {
//                driver.switchTo().window(windowHandles);
//                break;
//            }
//        }
//        System.out.println("Title of the page: "+driver.getTitle());

        //driver.quit();
    }
}
