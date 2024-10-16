package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHrm {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        input[@id='user-name
//        input[@placeholder='Username']

        //Negative
        loginUser(driver, "Invalid", "Invalid123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        String allertInvalid = driver.findElement(By.xpath("//p[contains(@class, 'alert-content-text')]")).getText();
        System.out.println(allertInvalid);
        Utils.customAssertEquals(allertInvalid, "Invalid credentials");

        //Positive
        loginUser(driver, "Admin", "admin123");
        WebElement loginButtonInv = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButtonInv.click();

        //gettext dashboard
        String dashboard = driver.findElement(By.xpath("//h6[contains(@class, 'header-breadcrumb-module')]")).getText();
        System.out.println(dashboard);

        //AssertEquals Dashboard
        Utils.customAssertEquals(dashboard, "Dashboard");

        //menubar dan mencoba logout
        WebElement menuBar = driver.findElement(By.xpath("//i[contains(@class, 'oxd-userdropdown-icon')]"));
        menuBar.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        logoutButton.click();

        Utils.delay(3);
        driver.quit();
    }

    public static void loginUser (WebDriver driver,String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }
}
