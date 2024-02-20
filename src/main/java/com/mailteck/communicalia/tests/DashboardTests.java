package com.mailteck.communicalia.tests;


import com.mailteck.communicalia.logics.ComunicationLogics;
import com.mailteck.communicalia.logics.ContactLogics;
import com.mailteck.communicalia.logics.DashboardLogics;
import com.mailteck.communicalia.logics.LoginLogics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardTests {

    private static final Logger logger = LogManager.getLogger(DashboardTests.class);

    private WebDriver driver;
    private DashboardLogics dashboardLogics;

    private LoginLogics loginLogic;

    @Before
    public void setUp() {
        dashboardLogics = new DashboardLogics(driver);
        driver = dashboardLogics.chromeDriverConnection();
        logger.info("Accediendo a Communicalia");
        dashboardLogics.visit("https://pre.communicalia.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testAllDashboard() throws InterruptedException {

        //Login paso 1
        boolean isLogin = this.login();
        Assert.assertEquals(isLogin, true);

        ComunicationLogics.waitTime(5);

        boolean passStep1 = step1();

        Assert.assertEquals(passStep1, true);

        ComunicationLogics.waitTime(5);


    }

    private boolean login() throws InterruptedException {
        loginLogic.login();
        By userLocator = By.name("email");
        return !loginLogic.isDisplayed(userLocator);
    }

    private boolean step1(){
        return dashboardLogics.addWigget();
    }


    @After
    public void finish() {
        //driver.quit();
    }

}
