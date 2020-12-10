package com.rozetka.hooks;

import com.rozetka.driver.DriverManager;
import com.rozetka.driver.DriverName;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setUp() {
        DriverManager.getDriver(DriverName.CHROME);
    }

    @After
    public void cleanDriver() {
        DriverManager.quitDriver();
    }
}
