package com.titusfortner.com.selenium_manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class NoSeleniumManagerExamples extends BaseTest {
    @Test
    public void defaultFails() {
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            driver = new ChromeDriver();
        });
        String msg = "The path to the driver executable The path to the driver executable must be set by the webdriver.chrome.driver system property; for more information, see https://chromedriver.chromium.org/. The latest version can be downloaded from https://chromedriver.chromium.org/downloads";
        Assertions.assertEquals(thrown.getMessage(), msg);
    }

    @Test
    public void systemProperty() {
        String knownLocation = "/Users/titusfortner/.drivers/115/chromedriver";
        System.setProperty("webdriver.chrome.driver", knownLocation);
        driver = new ChromeDriver();
    }

    @Test
    public void onPath() throws IOException {
        String knownLocation = "/Users/titusfortner/.drivers/116/chromedriver";
        File source = new File(knownLocation);
        File target = new File("/usr/local/bin/chromedriver");
        target.deleteOnExit();

        Files.copy(source.toPath(), target.toPath());
        driver = new ChromeDriver();
    }

    @Test
    public void serviceLocation() {
        String knownLocation = "/Users/titusfortner/.drivers/116/chromedriver";
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File (knownLocation))
                .build();

        driver = new ChromeDriver(service);
    }
}
