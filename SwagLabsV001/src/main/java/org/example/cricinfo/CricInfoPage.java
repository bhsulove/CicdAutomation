package org.example.cricinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CricInfoPage extends BasePage{
    public CricInfoPage(WebDriver driver) {
        super(driver);
    }

    public void readTableData(){
        WebElement table = driver.findElement(By.cssSelector(".ds-w-full .ds-table .ds-table-md .ds-table-auto  .ci-scorecard-table"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");  // Print the cell value with a tab space
            }
            System.out.println();  // New line after each row
        }
    }
}
