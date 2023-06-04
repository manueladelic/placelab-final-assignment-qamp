package com.placelab.roadanalysis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;
    private final static String PAGE_TITLE = "PlaceLab";
    private final static By LOGIN_HEADER = By.cssSelector(".bold.headline");
    private final static String LOGIN_PAGE_HEADER_TEXT = "Turn your data into information, information into insight and insight into business decisions.";
    private final static By EMAIL_INPUT_FIELD = By.id("email");
    private final static By PASSWORD_INPUT_FIELD = By.id("password");
    private final static By FORGET_YOUR_PASSWORD_LINK = By.cssSelector("#password-area a");
    private final static String FORGET_YOUR_PASSWORD_LINK_TEXT = "Forgot your password?";
    private final static By LOGIN_BUTTON_FIELD = By.cssSelector("input[type='submit']");
    private final static By LOGIN_SUBMIT_BUTTON = By.cssSelector("input[type='submit']");
    private final static By ACTUAL_WARNING_MESSAGE = By.xpath("//div[text()='Invalid credentials!']");
    final static String EXPECTED_WARNING_MESSAGE = "Invalid credentials!";


    public LoginPage(final WebDriver driver) {
        this.driver = driver;
    }


    public void validateLoginPageContent() {
        Assert.assertEquals(this.driver.getTitle(), PAGE_TITLE,
                "Validate if Login Page title is correct");
        Assert.assertTrue(this.driver.findElement(LOGIN_HEADER).isDisplayed(),
                "Validate if Login Page header is displayed");
        Assert.assertEquals(this.driver.findElement(LOGIN_HEADER).getText(), LOGIN_PAGE_HEADER_TEXT,
                "Validate if Login Page header is correct");
        Assert.assertTrue(this.driver.findElement(EMAIL_INPUT_FIELD).isDisplayed(),
                "Validate if Email field is displayed");
        Assert.assertTrue(this.driver.findElement(PASSWORD_INPUT_FIELD).isDisplayed(),
                "Validate if Password field is displayed");
        Assert.assertTrue(driver.findElement(FORGET_YOUR_PASSWORD_LINK).isEnabled(),
                "Validate if 'Forgot your password?' link on Login page is clickable.");
        Assert.assertEquals(driver.findElement(FORGET_YOUR_PASSWORD_LINK).getText(), FORGET_YOUR_PASSWORD_LINK_TEXT,
                "Validate if 'Forgot your password?' link text on Login page is correct.");
        Assert.assertTrue(this.driver.findElement(LOGIN_BUTTON_FIELD).isDisplayed(),
                "Validate if Login button is displayed");
    }


    public void enterCredentials(final String email, final String password) {
        this.driver.findElement(EMAIL_INPUT_FIELD).sendKeys(email);
        this.driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    }


    public void clickLoginButton() {
        this.driver.findElement(LOGIN_SUBMIT_BUTTON).click();
    }


    public void validateWarningMessages() {
        Assert.assertEquals(this.driver.findElement(ACTUAL_WARNING_MESSAGE).getText(), EXPECTED_WARNING_MESSAGE,
                "Validate if the expected warning message is equal to actual warning message.");
    }


    public void clearLoginFormInputs() {
        this.driver.findElement(EMAIL_INPUT_FIELD).clear();
        this.driver.findElement(PASSWORD_INPUT_FIELD).clear();
    }


}