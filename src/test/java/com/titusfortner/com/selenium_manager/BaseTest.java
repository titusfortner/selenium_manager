package com.titusfortner.com.selenium_manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;

    @AfterEach
    public void delete() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeAll
    public static void enableLogging() {
        Arrays.stream(Logger.getLogger("").getHandlers()).forEach(handler -> {
            handler.setLevel(Level.FINE);
        });
        Logger.getLogger("").setLevel(Level.FINE);
    }

}
