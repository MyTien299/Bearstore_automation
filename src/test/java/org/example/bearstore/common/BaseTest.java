package org.example.bearstore.common;

import org.example.bearstore.constants.AppConfig;
import org.example.bearstore.managers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.initBrowser();
        DriverManager.getPage().navigate(AppConfig.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}
