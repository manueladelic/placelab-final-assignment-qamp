package com.placelab.roadanalysis.pages;

import com.placelab.roadanalysis.utils.GlobalValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingPage {

    private WebDriver driver;

    public LoadingPage(final WebDriver driver) {
        this.driver = driver;
    }


    public String getReportID() {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlContains(GlobalValues.LOADING_REPORT_CREATION_URL));
        return this.driver.getCurrentUrl().substring(this.driver.getCurrentUrl().lastIndexOf("/") + 1);
    }


}
