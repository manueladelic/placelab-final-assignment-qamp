
![Logo](https://go.placelab.com/assets/logo-526ea19604d26801aca90fe441f7df4775a24a5d74ae273dbc4af85f42241259.png)


## Final assignment QAmp2023

The purpose of this repository is to contain a project that represents the solution for the final assignment of the Atlantbh QAmp educational program.

The final assignment consists of three parts and through each part, the ROADS - Road Analysis module of the PlaceLab application is tested.

The first part of assignment refers to manual testing and consists of:
- defining the smoke test for the specified module;
- testing the module and writing regression test suite;
- reporting of possible bugs and improvements.

The second part of assignment refers to automation Smoke test of Road Analysis module and in the third part of assignment API Smoke test of same PlaceLab module is done using Postman tool.

All tasks are in one IntelliJ project, but solution for each part of the assignment is represented separately. Manual testing such as API testing part of the assignment are in separate folders (manual-testing and API-testing folders)

## About the item under test

ROADS - Road analysis module is one of the modules of the PlaceLab application.
PlaceLab is an advanced analytics tool offering different modules.
Using machine learning, PlaceLab automates the processes used to detect standard data issues, including data evaluation, verification, and enrichment.

When using navigation systems, there are two types of information crucial for good user experience, road existence and accuracy of road name. PlaceLab uses competitive benchmarking to evaluate these two parameters via Road analysis and Road name analysis reports.

The Roads analysis module consists of two main areas of testing. The first item of testing includes the validating Create Analysis Report section. The second item under test is focused on how well data are displayed to the user based on their initial request.
Most important and mandatory filed for this report is upload file which must contain correct geometry specifications of the route.

## Tools

In this part of the README file, tools that are used for this project will be described.

Different tools were used for each part of the final task.

Manual testing:
- Additional tool - Microsoft Office Excel

Automation testing:
- IntelliJ IDEA (Java programming language)
- Maven
- Dependencies for Selenium and TestNG

API testing:
- Postman

## About tests

#Manual testing

The first part of assignment is represented in the folder "manual-testing" and there Excel file with solutions is available for download.
There is also manual.md file where more information about this part of the final assignment are provided.

#Automation testing

The second part of assignment in which solution for automated smoke test of Road analysis module is represented as test folder in source directory of the project and more about how to run these tests and automation tests themselves, is described in parts "How to run tests" and "More about automation part of assignment" .

#API testing

API testing of this module is done using Postman tool where new collection and new environment are created. These files, such as collection runner file, are in "API-testing" folder.
These test can be run through Postman Collection runner, but for running them locally you can use Newman tool also, if you have it installed.
To run these test through Newman use this command:

```bash
  newman run Roads_collection.json -e Roads_environment.json -n (replace with wanted number of iterations)
```
- newman run is Newman command to run collection 
- Road_collection.json is name of the collection 
- -e stands for environment and Road_environment.json is name of the environment created in Postman
- -n is number of iterations 

## How to run tests

This part of the README file describes how to run automated tests.

Smoke test for Road analysis module is done in IntelliJ IDEA using Java programming language and Selenium automation tool. This project is also Maven project that uses TestNG framework.

#Requirements

To run tests, except that you need to have previously mentioned tools installed, you need to have access to PlaceLab application which means that you need valid email and password because these parameters are not provided in the code and user of this code needs to provide it through the terminal.

To run tests, run the following command:

```bash
  mvn clean verify -Dbrowser=chrome -Demail="entervalidemail" -Dpassword="entervalidpassword"
```

Explanation of the command:

- mvn clean verify is Maven command and if you run it, Maven will clean the project by deleting any existing build artifacts and then proceed to verify the project by executing the defined tests
- -D flag allows us to pass system properties to Maven build
- browser, email and password are properties which are provided using @Parameters TestNg annotation
- chrome, "entervalidemail" and "entervalidpassword" are values of the properties and "entervalidemail" and "entervalidpassword" must be replaced with actual email and password for the user who has access to the PlaceLab application.

According to the current command provided in the terminal, the tests are run in the Google Chrome browser.
However, if the user of this code wants to change the browser, it can be changed easily by replacing current browser name with firefox of edge.
Tests were run in all listed browsers, but user of the code can use the one he wants.

Example:
Replace current browser:

```bash
  mvn clean verify -Dbrowser=firefox -Demail="entervalidemail" -Dpassword="entervalidpassword"
```

This is possible because WebDriver Manager dependency is added to a pom.xml file of the project, it is made specific method for getting the browser name and parameter browser is added before method for browser set up as it is shown:

```bash
  @Parameters ("browser")
```

## More about automation part of assignment

As it is mention before, automation part of final assignment is done in IntelliJ IDEA using Java programming language and Selenium automation tool, also this project is Maven project that uses TestNG framework.
Maven is a build automation and dependency management tool primarily used in Java projects. It provides a structured approach to managing the build process, including compiling source code, packaging artifacts, running tests, and managing project dependencies.
The most important part of Maven is pom.xml file where the structure, dependencies, and build configuration of a project are defined.

#Prerequisites

So to run tests, user must have IntelliJ IDE and Java installed.

In IntelliJ, create new Maven project and in the pom.xml file of the project, add dependencies for:

1. Selenium automation tool
2. TestNG framework
3. WebDriverManager

These dependencies are available at this site:

"https://mvnrepository.com/"

Also, it is added build-related configuration where the most important part is suiteXmlFiles. 
This element specifies the test suite XML files that should be executed. In this case, it points to the testng.xml file located in the src/test/resources directory.

#Source directory

Source directory (src) contains src/test directory that contains the test code files: java file where package "com.placelab.roadanalysis" is created and resources file where are testng.xml file and upload file for test report.
Mentioned package has three subpackages: pages, tests, utils, because this test follows Page Object Model as a design pattern.
In pages, there are all pages related to the creation of Road Analysis report. Under tests, there is main smoke test class which is added to the testng.xml file to run it, and utils part has all utils needed.

## Author of the project

- [@manueladelic](https://github.com/manueladelic)

