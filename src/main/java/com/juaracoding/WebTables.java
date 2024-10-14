package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        //scroll 200px
        js.executeScript("window.scrollBy(0,500)");

        //locator button add
        driver.findElement(By.id("addNewRecordButton")).click();

        //mengisi form
        driver.findElement(By.id("firstName")).sendKeys("Juara");
        driver.findElement(By.id("lastName")).sendKeys("Coding");
        driver.findElement(By.id("userEmail")).sendKeys("admin@juaracoding.co.id");
        driver.findElement(By.id("age")).sendKeys("10");
        driver.findElement(By.id("salary")).sendKeys("1500");
        driver.findElement(By.id("department")).sendKeys("BigBoss");
        driver.findElement(By.cssSelector("#submit")).click();

        //fitur searchbox
        driver.findElement(By.id("searchBox")).sendKeys("Juara");

        //masuk menu modifikasi(edit)
        driver.findElement(By.cssSelector("#edit-record-4 > svg")).click();

        //merubah umur
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("15");
        driver.findElement(By.cssSelector("#submit")).click();

        //menghapus data yang telah ditambahkan
        driver.findElement(By.cssSelector("#delete-record-4 > svg")).click();

        //mengembalikan tabel seperti awal
        driver.findElement(By.id("searchBox")).clear();


        //delay 5detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
