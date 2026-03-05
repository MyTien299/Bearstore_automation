package org.example.bearstore.common;

import org.example.bearstore.constants.AppConfig;
import org.example.bearstore.managers.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        DriverManager.initPlaywrightAndBrowser();
    }

    @BeforeMethod
    public void setUp() {
        DriverManager.initContextAndPage();
        DriverManager.getPage().navigate(AppConfig.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeContext();
    }

    @AfterClass
    public void afterClass() {
        DriverManager.quit();
    }
//    @BeforeMethod
//    public void setUp() {
//        DriverManager.initBrowser();
//        DriverManager.getPage().navigate(AppConfig.BASE_URL);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        DriverManager.quit();
//    }
}
