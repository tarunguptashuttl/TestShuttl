package com.testshuttl.pack;

import org.junit.Before;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//import static org.junit.Assert.assertEquals;

/**
 * Created by tarun on 10/5/16.
 */
public class login {
        AppiumDriver driver;
@Before
public void testCaseSetup()throws  Exception
        {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
     //   cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        cap.setCapability(MobileCapabilityType.APP, "/home/tarun/AndroidStudioProjects/TestShuttl/app/src/androidTest/Myapps/app-qa.apk");
       // cap.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
          /*  Location loc =new Location(20.0,12.5,1000);
            driver.setLocation(loc);


            MobileElement myDynamicElement = (MobileElement) (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));*/
        }

        @Test   // driver not found message
        public void AinvalidPnumber() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270000");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String getButtonText=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        System.out.println("printing screen");
        assertEquals(getButtonText,"SIGN UUP");
        }


       @Test     // login with IVR confirmation true
        public void BivrConfirmationTrue() throws InterruptedException {
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
            driver.hideKeyboard();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
            Thread.sleep(10000);
            String VehicleToSelect="RJ5TA0004";
            driver.scrollToExact(VehicleToSelect).click();
            Thread.sleep(5000);
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
            String loginSuccessText="Your reporting schedule";
            WebDriverWait wait=new WebDriverWait(driver,120);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
            String loginSuccessTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text").getText();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
            assertEquals(loginSuccessText,loginSuccessTextMobile);
        }

    @Test  // login with IVR confirmation false
    public void CivrConfirmationFalse() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
        assertEquals(signUpButtonTextMobile,signUpButtonText);
     // Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }

       @Test       // change vehicle ivr confirmation true
    public void DchangeVehicleIvrConfirmationTrue() throws InterruptedException, IOException {
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
        String vehicleNumberTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_subtitle").getText();
        assertEquals(vehicleNumberTextMobile,VehicleToSelect);
       }

     @Test // change vehicle ivr confirmation false
    public void EchangeVehicleIvrConfirmationFalse() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        System.out.println("here before");
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
        System.out.println("here1 : "+ signUpButtonTextMobile);
        assertEquals(signUpButtonTextMobile,signUpButtonText);
        //    Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }
   // 9935828842

    @Test    // vehicle is already assigned to some other driver (pass vehicle that is already allocated trip)
    public void FchangeVehicleVehicleAlreadyAssigned() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="SHUTTL0000";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
        System.out.println("here1 : "+ signUpButtonTextMobile);
        assertEquals(signUpButtonTextMobile,signUpButtonText);
     //   Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }



     @Test    // driver cannot access vehicle that is mark as absent (pass vehicle name that is already allocated trip)
      public void GvehicleMarkAsAbsent() throws InterruptedException, IOException {
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
          driver.hideKeyboard();
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
          Thread.sleep(10000);
          String VehicleToSelect="SHUTTL0000";
          driver.scrollToExact(VehicleToSelect).click();
          Thread.sleep(5000);
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
          WebDriverWait wait=new WebDriverWait(driver,120);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
          String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
          String signUpButtonText="SIGN UP";
          System.out.println("here1 : "+ signUpButtonTextMobile);
          assertEquals(signUpButtonTextMobile,signUpButtonText);
         // Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
      }
    @After
public void testCaseTearDown()
        {
           driver.quit();
        }
    }
