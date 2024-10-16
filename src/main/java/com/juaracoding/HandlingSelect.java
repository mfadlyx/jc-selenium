package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingSelect {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        //scroll 350px
        js.executeScript("window.scroll(0,350)");

        //tanpa ext selectorHub
        //String txtTittlePage = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/h1")).getText();
        //System.out.println(txtTittlePage);

        //Menggunakan ext SelectorHub
        String txtTittlePage = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
        System.out.println(txtTittlePage);

        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);
        select.selectByIndex(7);
        Utils.delay(3);
        select.selectByValue("red");
        Utils.delay(3);
        select.selectByVisibleText("Indigo");

        //delay 5 detik
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
