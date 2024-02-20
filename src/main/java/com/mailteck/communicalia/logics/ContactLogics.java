package com.mailteck.communicalia.logics;

import com.mailteck.communicalia.util.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactLogics extends Base {

    private static final Logger logger = LogManager.getLogger(ComunicationLogics.class);
    private static WebElement loginButton;

    public ContactLogics(WebDriver driver){
        super(driver);
    }


    public static Boolean searchByInput() {
        try {
            Actions act = new Actions(driver);

            driver.findElement(By.linkText("Contactos")).click();
            waitTime(5);
            driver.findElement(By.xpath("//input[@placeholder='Buscar']")).sendKeys("02909182G");
            waitTime(5);
            driver.findElement(By.xpath("//*[@class='btn btn-outline-secondary']")).click();
            WebElement ele =driver.findElement(By.xpath("//*[@id=\"vgt-table\"]/tbody/tr/td[1]/span"));
            act.doubleClick(ele).perform();


            //
            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }

    }


}

