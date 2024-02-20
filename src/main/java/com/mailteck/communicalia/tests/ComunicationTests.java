package com.mailteck.communicalia.tests;


import com.mailteck.communicalia.logics.ComunicationLogics;
import com.mailteck.communicalia.logics.LoginLogics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComunicationTests {

    private static final Logger logger = LogManager.getLogger(ComunicationTests.class);

    private WebDriver driver;
    private ComunicationLogics communicaliaLogic;

    private LoginLogics loginLogic;

    @Before
    public void setUp() {
        communicaliaLogic = new ComunicationLogics(driver);
        driver = communicaliaLogic.chromeDriverConnection();
        logger.info("Accediendo a Communicalia");
        communicaliaLogic.visit("https://pre.communicalia.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testCampana() throws InterruptedException {

        //Login paso 1
        boolean isLogin = this.login();
        Assert.assertEquals(isLogin, true);

        ComunicationLogics.waitTime(5);

        boolean passStep1 = step1();

        Assert.assertEquals(passStep1, true);

        ComunicationLogics.waitTime(5);

        step2();

        ComunicationLogics.waitTime(5);

        step3();

       ComunicationLogics.waitTime(5);

        step4();

        ComunicationLogics.waitTime(5);

        step5();

        ComunicationLogics.waitTime(5);

        step6();

        ComunicationLogics.waitTime(5);

        step7();

        ComunicationLogics.waitTime(5);
    }

    private boolean login() throws InterruptedException {
        loginLogic.login();
        By userLocator = By.name("email");
        return !loginLogic.isDisplayed(userLocator);
    }

    private boolean step1(){
        return communicaliaLogic.searchByInput();
    }
    private boolean step2(){
        return communicaliaLogic.searchByCampain();
    }
    private boolean step3(){
        return communicaliaLogic.searchByEvent();
    }

    private boolean step4(){
        return communicaliaLogic.searchByAction();
    }

    private boolean step5(){
        return communicaliaLogic.searchByChannel();
    }

    private boolean step6(){
        return communicaliaLogic.searchByStage();
    }
    private boolean step7(){
        return communicaliaLogic.searchByProcess();
    }
//    private boolean paso8(){
//        return communicaliaLogic.searchByDateInit();
//    }


    @After
    public void finish() {
        //driver.quit();
    }

}
