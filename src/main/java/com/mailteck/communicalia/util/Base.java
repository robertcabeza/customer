package com.mailteck.communicalia.util;


import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    private static final Logger logger = LogManager.getLogger(Base.class);
    protected static WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/
        return driver;
    }

    public WebElement findelemente(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    public static void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public static boolean isDisplayed(By locator) {
        try {
            boolean isLogin = driver.findElement(locator).isDisplayed();
            if(isLogin)
                logger.info("Se realizo el login correctamente ");
            else
                logger.error("No se ha podido realizar el login");
            return isLogin;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);

    }
    public static void waitTime(long l){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(l));
    }


}


