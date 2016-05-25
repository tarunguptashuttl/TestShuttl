package com.testshuttl.pack;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.assertEquals;

/**
 * Created by tarun on 23/5/16.
 */


//import static org.junit.Assert.assertEquals;

/**
 * Created by tarun on 10/5/16.
 */
public class reportReach {
    AppiumDriver driver;
    @Before
    public void Setup()throws  Exception
    {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        //   cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        cap.setCapability(MobileCapabilityType.APP, "/home/tarun/AndroidStudioProjects/TestShuttl/app/src/androidTest/Myapps/app-qa.apk");
        // cap.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          /*  Location loc =new Location(20.0,12.5,1000);
            driver.setLocation(loc);
            MobileElement myDynamicElement = (MobileElement) (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));*/
    }

    @Test   //  TC_Report_1 Landed to reporting schedule screen successfully
    public void SuccessfullReportReachScreen() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        String reportButtonStatus=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").getAttribute("enabled");
        System.out.println(reportButtonStatus);
        assertEquals(reportButtonStatus,"true");
    }

    @Test   //  TC_Report_2 Early reporting not allowed
    public void earlyReport() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").click();
        String reportButtonStatus=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").getAttribute("enabled");
        assertEquals(reportButtonStatus,"true");
    }
    @Test   //  TC_Report_3  Reporting within time defined in repoerties table
    public void reportWithInTime() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").click();
        String reachButtonStatus=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/reached_button").getAttribute("enabled");
        assertEquals(reachButtonStatus,"true");
    }


    @Test  //  TC_Report_3  Reporting within before time defined in properties table
    public void reportWithInBeforeTime() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").click();
        String reachButtonStatus=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/reached_button").getAttribute("enabled");
        assertEquals(reachButtonStatus,"true");
    }

@Test   //  TC_Report_4  Reporting within after time defined in properties table
    public void reportWithInAfterTime() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").click();
        String reachButtonStatus=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/reached_button").getAttribute("enabled");
        assertEquals(reachButtonStatus,"true");
    }

    @Test   //  TC_Report_5 Reporting schedule of next session after buffer time
    public void nextSessionScheduleAfterBufferTime() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect = "RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        String oldSchedule = driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_date").getText()+driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_time").getText();
        Thread.sleep(300000);
        String newSchedule = driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_date").getText()+driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_time").getText();
        assertEquals(oldSchedule,newSchedule);
        }

   @Test  // TC_Report_6 Reach enable after successful reporting
   public void reachButtonAfterSuccessfulReporting() throws InterruptedException, IOException {
       driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
       driver.hideKeyboard();
       driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
       Thread.sleep(10000);
       String VehicleToSelect = "RJ5TA0004";
       driver.scrollToExact(VehicleToSelect).click();
       Thread.sleep(5000);
       driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
       WebDriverWait wait = new WebDriverWait(driver, 120);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
       driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_report_duty_button").click();
       String reachButtonStatus = driver.findElementById("app.goplus.in.myapplication.driver.qa:id/reached_button").getAttribute("enabled");
       assertEquals(reachButtonStatus, "true");
   }
    @After
    public void testCaseTearDown()
    {

    //    driver.quit();
    }
}


