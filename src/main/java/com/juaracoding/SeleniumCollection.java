package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumCollection {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
//        System.out.println("Jumlah tag html input = "+listInput.size());
//
//        for (int i = 0; i < listInput.size(); i++) {
//            System.out.println(listInput.get(i).getAttribute("type"));;
//        }
//
//        for (WebElement input : listInput){
//            System.out.println(input.getAttribute(input.getText()));
//        }
//
//        for (int i = 1; i < listInput.size(); i++) { //3 < 3
//            listInput.get(i).sendKeys("invalid");
//        }
//
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        String txtInvalid = driver.findElement(By.xpath("//p[contains(@class, 'alert-content-text')]")).getText();
//        System.out.println(txtInvalid);

          driver.findElement(By.xpath("//input[@name='username']")).sendKeys("selenium");
          driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.CONTROL+"A");
          Utils.delay(3);
          driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.DELETE);
          Utils.delay(3);


          OrangeHrm.loginUser(driver, "Admin", "admin123");
          driver.findElement(By.xpath("//button[@type='submit']")).click();

//        driver.get("https://www.tokopedia.com/");
//        List<WebElement> trends = driver.findElements(By.xpath("//a[@data-testid='trendkingKeywordList']"));
//        System.out.println(trends.size());
//
//        for (WebElement trend : trends){
//            System.out.println(trend.getText());
//        }
//
//        trends.get(4).click();
//
//        String price = "3.699.000";
//        String priceClr = price.replace("Rp", "");
//        double priceConv = Double.parseDouble(priceClr.replace(".", ""));
//        System.out.println(priceConv+1000);

        List<WebElement>  menuBar = driver.findElements(By.xpath("//span[contains(@class, 'menu-item--name')]"));
        System.out.println(menuBar.size());

        for (WebElement menu : menuBar){
            System.out.println(menu.getText());
        }

        //delay
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
