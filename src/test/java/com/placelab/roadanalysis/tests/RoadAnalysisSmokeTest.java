package com.placelab.roadanalysis.tests;

import com.placelab.roadanalysis.pages.*;
import com.placelab.roadanalysis.utils.GlobalValues;
import com.placelab.roadanalysis.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RoadAnalysisSmokeTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private RoadAnalysisPage roadAnalysisPage;
    private LoadingPage loadingPage;
    private QueriesPage queriesPage;


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(final String browser) {
        this.driver = WebDriverSetup.getWebDriver(browser);
        this.driver.get(GlobalValues.HOST);
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
        this.navigationPage = new NavigationPage(driver);
        this.roadAnalysisPage = new RoadAnalysisPage(driver);
        this.loadingPage = new LoadingPage(driver);
        this.queriesPage = new QueriesPage(driver);
    }


    @Parameters({"email", "password"})
    @Test(priority = 1, description = "Road analysis smoke test")
    public void roadAnalysisReport(final String email, final String password) {
        loginPage.validateLoginPageContent();
        loginPage.enterCredentials(email, password);
        loginPage.clickLoginButton();
        navigationPage.validateNavigationPageElements();
        navigationPage.validateUserRole("Group Admin");
        roadAnalysisPage.openRoadAnalysisPage();
        roadAnalysisPage.validateRoadAnalysisPageContent();
        roadAnalysisPage.populateRoadAnalysisReport();
        final String reportID = loadingPage.getReportID();
        queriesPage.validateQueriesPageContent();
        roadAnalysisPage.openReportAnalysis(reportID);
        this.driver.navigate().back();
        queriesPage.deleteReport(reportID);
        navigationPage.signOut();
    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        this.driver.close();
    }


}
