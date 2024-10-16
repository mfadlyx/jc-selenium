package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        //scroll 500
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        Utils.delay(5);

        //kembali tab awal
        driver.switchTo().window(tab.get(0));
        String txtTittlePage = driver.findElement(By.cssSelector("#browserWindows > h1")).getText();
        System.out.println(txtTittlePage);

        //navigate
        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println("Current URL : "+driver.getCurrentUrl());
        driver.findElement(By.id("showSmallModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("closeSmallModal")).click();
        Utils.delay(3);

        driver.navigate().back();
        System.out.println("Current URL : "+driver.getCurrentUrl());
        Utils.delay(3);

        driver.navigate().refresh();



        //delay 5 detik
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
