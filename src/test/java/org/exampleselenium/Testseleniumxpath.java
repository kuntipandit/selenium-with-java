package org.exampleselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public
class Testseleniumxpath {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        driver = new ChromeDriver(ops);

    }

    @Test(enabled = false)
    public void firsttest() {
        driver.get("https://www.saucedemo.com/");

        String title = driver.getTitle();

        if (title.equals("Swag Labs")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Title didn't match");
        }
    }

    @Test(enabled = false)
    public void positive_login_scenario() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        Thread.sleep(2000);
        String errortext = driver.findElement(By.xpath("//div[contains(@class,'error-message-container')]/h3[contains(text(),'Sorry, this user has been locked out.')]")).getText();
        if (errortext.contains("this user has been locked out.")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Text doesn't contains locked out user");
        }
        Thread.sleep(3000);
    }

    @Test
    public void cart_scenario() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        Thread.sleep(1000);

        for (int i=1; i <= 2; i++){
            driver.findElement(By.xpath("(//button[text()='Add to cart'])["+i+"]")).click();
            Thread.sleep(1000);
        }

        String cartItems = driver.findElement(By.xpath("//div[@id='shopping_cart_container']//span")).getText();

        if (Integer.parseInt(cartItems) == 2){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Cart don't have exactly 2 items");
        }
        Thread.sleep(2000);
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }


}
