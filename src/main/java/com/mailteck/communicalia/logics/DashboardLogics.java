package com.mailteck.communicalia.logics;

import com.mailteck.communicalia.util.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardLogics extends Base {

    private static final Logger logger = LogManager.getLogger(DashboardLogics.class);
    private static WebElement loginButton;

    public DashboardLogics(WebDriver driver){
        super(driver);
    }


    public static Boolean addWigget() {
        try {
            driver.findElement(By.linkText("Dashboard")).click();
            waitTime(5);
            driver.findElement(By.xpath("//*[@class='btn botonBlue mt-1 btn-secondary btn-sm']")).click();
            waitTime(5);
            driver.findElement(By.xpath("//*[@id=\"selectWidgetModal___BV_modal_body_\"]/div[1]/div[1]/button")).click();

            Thread.sleep(5000   );


  


            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }

    }

    public static Boolean searchByCampain() {

        try {
            /*driver.findElement(By.linkText("Comunicaciones")).click();
            waitTime(5);*/

            //driver.findElement(By.xpath("//*[@class=\"form-group\"]/div[2]/div/div[2]")).click();
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectCampaings']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectCampaings-3")).click();
            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }
    public static Boolean searchByEvent() {

        try {
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectEventos']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectEventos-4")).click();
            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }

    public static Boolean searchByAction() {

        try {
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectAcciones']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectAcciones-1")).click();

            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }

    public static Boolean searchByChannel() {

        try {
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectCanales']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectCanales-2")).click();

            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }
    public static Boolean searchByStage() {

        try {
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectEstados']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectEstados-1")).click();

            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }
    public static Boolean searchByProcess() {

        try {
            driver.findElement(By.xpath("//div[@aria-owns='listbox-multiSelectProcesos']")).click();
            waitTime(5);
            driver.findElement(By.id("multiSelectProcesos-3")).click();

            return true;
        } catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }

//    public static Boolean searchByDateInit() {
//
//        try {
//            driver.findElement(By.xpath("//*[@id=\"fechaIni__outer_\"]")).click();
//            waitTime(5);
//            driver.findElement(By.xpath("//div[@data-date='2019-05-16']")).click();
//            return true;
//        } catch (Exception ex){
//            logger.error(ex.getMessage());
//            return false;
//        }
//    }

    ////*[@id="fechaIni__outer_"]



}
