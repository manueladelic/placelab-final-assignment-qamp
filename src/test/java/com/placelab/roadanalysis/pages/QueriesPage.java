package com.placelab.roadanalysis.pages;

import com.placelab.roadanalysis.utils.GlobalValues;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class QueriesPage {

    private WebDriver driver;
    private final static By QUERIES_HEADER = By.id("action-navbar");
    private static final By REPORTS_TABLE = By.id("queries-table-container");
    private final static By REPORT_CHECKBOXES = By.cssSelector("#table_queries > tbody > tr > td.large > div");
    private static final By DELETE_ICON = By.xpath("//a[@data-original-title='Delete']");
    private static final By DELETE_REPORT_CONFIRM_BUTTON = By.xpath("//a[contains(text(), 'Confirm')]");

    public QueriesPage(final WebDriver driver) {
        this.driver = driver;
    }


    public void validateQueriesPageContent() {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(GlobalValues.QUERIES_URL));
        Assert.assertEquals(this.driver.getCurrentUrl(), GlobalValues.QUERIES_URL,
                "Validate if the Queries page URL is correct.");
        Assert.assertTrue(this.driver.findElement(QUERIES_HEADER).isDisplayed(),
                "Validate if Queries page header is displayed.");
        Assert.assertTrue(this.driver.findElement(QUERIES_HEADER).getText().contains("Reports"),
                "Validate if Queries page header is correct.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(REPORTS_TABLE));
        Assert.assertTrue(this.driver.findElement(REPORTS_TABLE).isDisplayed(),
                "Validate if Report table is displayed.");
    }


    public void deleteReport(final String reportID) {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(getReportCheckbox(reportID))).click();
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_ICON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_REPORT_CONFIRM_BUTTON)).click();
    }


    private WebElement getReportCheckbox(final String reportID) {
        final List<WebElement> checkboxes = this.driver.findElements(REPORT_CHECKBOXES);
        for (final WebElement checkbox : checkboxes) {
            if (checkbox.findElement(By.tagName("input")).getAttribute("value").equals(reportID)) {
                return checkbox;
            }
        }
        throw new NotFoundException();
    }


}
