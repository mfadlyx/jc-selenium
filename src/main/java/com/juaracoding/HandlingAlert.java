package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        //scroll 350
        js.executeScript("window.scrollBy(0,350)");

        //alert Button
        driver.findElement(By.id("alertButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().accept();//ok
        System.out.println("Alert Button");

        //alert Button
        driver.findElement(By.id("timerAlertButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().accept();//ok
        System.out.println("Timer Alert Button");

        //confirm Button
        driver.findElement(By.id("confirmButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().dismiss();//cancel
        System.out.println("confirm Button");

        //promt Button
        driver.findElement(By.id("promtButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().sendKeys("JuaraCoding");
        driver.switchTo().alert().accept();//ok
        System.out.println("promt Button");


        //delay 5 detik
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
