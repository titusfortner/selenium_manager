package com.titusfortner.com.selenium_manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome410Test extends BaseTest {
    String CHROME_115 = "115";

    @Test
    public void usesDefaultInstall() {
        driver = new ChromeDriver();

        Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
        Assertions.assertTrue(capabilities.getBrowserVersion().contains(CHROME_115));
    }

    @Test
    public void ignoresOldVersion() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("113");
        driver = new ChromeDriver(options);

        Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
        Assertions.assertTrue(capabilities.getBrowserVersion().contains(CHROME_115));
    }

    @Test
    public void ignoresInvalidVersion() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("banana");
        driver = new ChromeDriver(options);

        Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
        Assertions.assertTrue(capabilities.getBrowserVersion().contains("113"));
    }

    @Test
    public void usesInstalledNamedVersion() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("dev");
        driver = new ChromeDriver(options);

        Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
        Assertions.assertTrue(capabilities.getBrowserVersion().contains("dev"));
    }

    @Test
    public void ignoresNamedVersionNotInstalled() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("dev");
        driver = new ChromeDriver(options);

        Capabilities capabilities = ((ChromeDriver) driver).getCapabilities();
        Assertions.assertTrue(capabilities.getBrowserVersion().contains("dev"));
    }
}
