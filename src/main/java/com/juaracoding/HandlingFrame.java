package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");

        //scroll 350px
        js.executeScript("window.scrollBy(0,350)");

        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        driver.switchTo().defaultContent();

        String txtTittlePage = driver.findElement(By.cssSelector("#framesWrapper > h1")).getText();
        System.out.println(txtTittlePage);

        //delay 5 detik
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
