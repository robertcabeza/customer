package com.mailteck.communicalia.logics;

import com.mailteck.communicalia.properties.Properties;
import com.mailteck.communicalia.util.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLogics extends Base {

    private static final Logger logger = LogManager.getLogger(LoginLogics.class);
    private static WebElement loginButton;

    public LoginLogics(WebDriver driver){
        super(driver);
    }

    public static void login() {
        if(isDisplayed(By.name("email"))){
            logger.info("Se esta realizando Login Communicalia con el usuario: "+ Properties.getProperties("username"));
            type( Properties.getProperties("username"), By.name("email"));
            type( Properties.getProperties("password") ,  By.name("password"));
            loginButton = driver.findElement(By.className("btn"));
            loginButton.click();
        }
    }



}
