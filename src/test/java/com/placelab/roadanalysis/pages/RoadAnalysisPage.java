package com.placelab.roadanalysis.pages;

import com.placelab.roadanalysis.utils.GlobalValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class RoadAnalysisPage {


    private WebDriver driver;
    private final static By DROPDOWN_MENU = By.cssSelector("a[id='create-menu'] i[class='icon icon-angle-down']");
    private final static By ROAD_ANALYSIS_LABEL = By.id("roadanalysis");
    private final static By ROADS_HEADER = By.cssSelector(".report-header");
    private final static By REPORT_NAME = By.id("upload_query_name");
    private final static By UPLOAD_FILE_FIELD = By.id("newDropzonePreview");
    private final static By CREATE_REPORT_BTN = By.cssSelector(".btn.large-btn.run-btn.run-all-btn");


    public RoadAnalysisPage(final WebDriver driver) {
        this.driver = driver;
    }


    public void openRoadAnalysisPage() {
        this.driver.findElement(DROPDOWN_MENU).click();
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ROAD_ANALYSIS_LABEL));
        Assert.assertTrue(this.driver.findElement(ROAD_ANALYSIS_LABEL).isDisplayed(),
                "Validate if the label for Road analysis report is displayed.");
        this.driver.findElement(ROAD_ANALYSIS_LABEL).click();
    }


    public void validateRoadAnalysisPageContent() {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(GlobalValues.ROAD_ANALYSIS_URL));
        Assert.assertEquals(this.driver.getCurrentUrl(), GlobalValues.ROAD_ANALYSIS_URL,
                "Validate if the Road Analysis page URL is correct.");
        Assert.assertTrue(this.driver.findElement(ROADS_HEADER).isDisplayed(),
                "Validate if Road Analysis page header is displayed.");
        Assert.assertTrue(this.driver.findElement(ROADS_HEADER).getText().contains("Create Road Analysis Report"),
                "Validate if Road Analysis page header is correct.");
        Assert.assertTrue(this.driver.findElement(REPORT_NAME).isDisplayed(),
                "Validate if Report name field is displayed.");
        Assert.assertTrue(this.driver.findElement(UPLOAD_FILE_FIELD).isDisplayed(),
                "Validate if Upload file box is displayed");
    }


    public void populateRoadAnalysisReport() {
        Random random = new Random();
        this.driver.findElement(REPORT_NAME).sendKeys("Road Analysis Report " + random.nextInt(1000));
        WebElement fileUploadField = this.driver.findElement(By.xpath("//input[@name='files[0]']"));
        fileUploadField.sendKeys("src/test/resources/roads_sample.txt");
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(CREATE_REPORT_BTN));
        this.driver.findElement(CREATE_REPORT_BTN).click();
    }


    public void openReportAnalysis(final String reportID) {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        final WebElement status = this.driver.findElement(By.xpath("//td[@id='status_" + reportID + "']"));
        wait.until(ExpectedConditions.visibilityOf(status));
        if (status.isDisplayed()) {
            this.driver.get("https://demo.placelab.com/roads/road_analyses/" + reportID);
        }
    }


}
