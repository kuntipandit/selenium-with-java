package org.exampleselenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
public
class Frameexample2 {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.addArguments("--disable-geolocation");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }
    @Test
    public void test_iframes(){
        driver.get("https://demoqa.com/frames");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame2"));
        String frameContent = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(frameContent);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame1");
        String frameContent1  = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(frameContent1);
        driver.switchTo().defaultContent();
    }
    @Test
    public void parent_child_frame(){
        driver.get("https://demoqa.com/frames");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame2"));
        String frameContent = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(frameContent);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame1");
        String frameContent1  = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(frameContent1);
        driver.switchTo().defaultContent();
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }


}
