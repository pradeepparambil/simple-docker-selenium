package com.teksenz.simpleseleniumselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Tests {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--allowed-ips");
        driver = new ChromeDriver(options);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void sampleTest(){
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("fish");
        driver.findElement(By.id("search_button_homepage")).click();
        Assert.assertEquals(driver.getTitle(),"fish at DuckDuckGo");
        System.out.println("Test finished successfully");
    }

    @Test
    public void googleTest(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
        System.out.println("Test finished successfully");
    }

}
