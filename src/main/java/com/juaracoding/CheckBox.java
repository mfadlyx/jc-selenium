package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        //scroll 200px
        js.executeScript("window.scrollBy(0,200)");

        //locator : CssSelector
        //checklist Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();
        //Unchecklist Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();
        //checklist : Desktop Documents
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label")).click();

        //delay selama 5 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
