package com.juaracoding;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Open Browser");
        driver.get("https://browserstack.com/");

        js.executeScript("window.scrollBy(0,100)", "");

        WebElement menuProducts = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
        WebElement menuDevelopers = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuProducts).build().perform();
        Utils.delay(3);
        actions.moveToElement(menuDevelopers).build().perform();
        Utils.delay(1);
        driver.get("https://www.browserstack.com/docs/");
        driver.navigate().back();

        List<WebElement> menuDev = driver.findElements(By.xpath("//div[@class='bstack-mm-sub-li']"));
        System.out.println(menuDev.size());

        for (WebElement menubar : menuDev ){
            System.out.println(menubar.getText());
        }

        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");

    }

}
