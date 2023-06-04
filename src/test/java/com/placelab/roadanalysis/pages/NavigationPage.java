package com.placelab.roadanalysis.pages;

import com.placelab.roadanalysis.utils.GlobalValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NavigationPage {

    private WebDriver driver;
    private final static String EXPECTED_PAGE_URL = GlobalValues.NAVIGATION_URL;
    private final static By PLACELAB_LOGO = By.xpath("//a[@class='brand']//img");
    private final static By CREATE_REPORT = By.id("create-menu");
    private final static By TRAFFIC_DASHBOARD = By.id("traffic-dashboard-nav-item");
    private final static By REPORTS = By.cssSelector("#queries-nav-item");
    private final static By DROPDOWN_MENU = By.cssSelector("a[id='create-menu'] i[class='icon icon-angle-down']");
    private final static By RIGHT_CORNER_DROP_DOWN = By.cssSelector("#user-name > i");
    private final static By USER_ROLE = By.cssSelector("#user-role");
    private final static By SIGN_OUT = By.linkText("Sign out");


    public NavigationPage(final WebDriver driver) {
        this.driver = driver;
    }


    public void validateNavigationPageElements() {
        final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(EXPECTED_PAGE_URL));
        Assert.assertEquals(this.driver.getCurrentUrl(), EXPECTED_PAGE_URL,
                "Validate if the Navigation page URL is correct.");
        Assert.assertTrue(this.driver.findElement(PLACELAB_LOGO).isDisplayed(),
                "Validate if the PlaceLab logo is displayed.");
        Assert.assertTrue(this.driver.findElement(CREATE_REPORT).isDisplayed(),
                "Validate if the Create report field is displayed.");
        Assert.assertTrue(this.driver.findElement(TRAFFIC_DASHBOARD).isDisplayed(),
                "Validate if the Traffic Dashboard field is displayed.");
        Assert.assertTrue(this.driver.findElement(REPORTS).isDisplayed(),
                "Validate if the Reports field is displayed.");
        Assert.assertTrue(this.driver.findElement(DROPDOWN_MENU).isEnabled(),
                "Validate if Navigation page drop down menu is enabled.");
        Assert.assertTrue(this.driver.findElement(RIGHT_CORNER_DROP_DOWN).isEnabled(),
                "Validate if Navigation page right corner drop down menu is enabled.");
    }


    public void validateUserRole(final String userRole) {
        Assert.assertEquals(driver.findElement(USER_ROLE).getText(), userRole,
                "Validate if the correct user role is displayed.");
    }


    public void signOut() {
        this.driver.findElement(RIGHT_CORNER_DROP_DOWN).click();
        Assert.assertTrue(this.driver.findElement(SIGN_OUT).isEnabled(),
                "Validate if Sign Out button is enabled.");
        this.driver.findElement(SIGN_OUT).click();
    }


}
