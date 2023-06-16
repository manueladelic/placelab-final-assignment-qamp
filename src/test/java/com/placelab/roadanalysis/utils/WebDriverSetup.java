package com.placelab.roadanalysis.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

    public static WebDriver getWebDriver(String browserName) {
        if (browserName.toLowerCase().equals("chrome")) {
            return getChromeDriver();
        } else if (browserName.toLowerCase().equals("firefox")) {
            return getFirefoxDriver();
        } else if (browserName.toLowerCase().equals("edge")) {
            return getEdgeDriver();
        } else {
            throw new IllegalArgumentException("Match not found for the following browser name: " + browserName);
        }
    }


    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }


}
