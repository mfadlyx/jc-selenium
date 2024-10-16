package com.juaracoding;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwagLabs {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");

        //login Standard_User
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //logout
        driver.findElement(By.xpath("//button[normalize-space()='Open Menu']")).click();
        Utils.delay(5);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();


        //delay
        Utils.delay(3);
        driver.quit();


    }

}
