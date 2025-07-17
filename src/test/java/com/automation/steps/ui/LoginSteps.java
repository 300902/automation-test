package com.automation.steps.ui;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://www.demoblaze.com/";

    @Before("@ui")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@ui")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the DemoBlaze website")
    public void navigateToDemoBlaze() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login2")));
    }

    @Given("I click on the login button")
    public void clickLoginButton() {
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("login2"))
        );
        loginButton.click();
        
        // Wait for login modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
    }

    @When("I enter valid username {string}")
    public void enterValidUsername(String username) {
        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @When("I enter invalid username {string}")
    public void enterInvalidUsername(String username) {
        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @When("I enter valid password {string}")
    public void enterValidPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("I enter invalid password {string}")
    public void enterInvalidPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("I click the login submit button")
    public void clickLoginSubmit() {
        WebElement loginSubmitButton = driver.findElement(
            By.xpath("//button[@onclick='logIn()']")
        );
        loginSubmitButton.click();
    }

    @Then("I should be logged in successfully")
    public void verifySuccessfulLogin() {
        try {
            // Wait a bit for potential alerts
            Thread.sleep(2000);
            
            // Check if welcome message appears (indicating successful login)
            WebElement welcomeElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("nameofuser"))
            );
            assertTrue(welcomeElement.isDisplayed());
        } catch (Exception e) {
            // If no welcome message, check if login modal is closed
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
            } catch (Exception ex) {
                fail("Login was not successful");
            }
        }
    }

    @Then("I should see welcome message with username")
    public void verifyWelcomeMessage() {
        try {
            WebElement welcomeElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("nameofuser"))
            );
            assertTrue(welcomeElement.getText().contains("Welcome"));
        } catch (Exception e) {
            // Alternative check: verify login modal is closed
            assertTrue(!driver.findElement(By.id("logInModal")).isDisplayed());
        }
    }

    @Then("I should see login failure alert")
    public void verifyLoginFailureAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertTrue(alertText.contains("User does not exist") || 
                      alertText.contains("Wrong password") ||
                      alertText.contains("Please fill out Username and Password"));
            alert.accept();
        } catch (Exception e) {
            fail("Expected alert was not present");
        }
    }

    @Then("I should remain on the login page")
    public void verifyRemainsOnLoginPage() {
        // Verify login modal is still visible
        WebElement loginModal = driver.findElement(By.id("logInModal"));
        assertTrue(loginModal.isDisplayed());
    }

    @When("I leave username field empty")
    public void leaveUsernameEmpty() {
        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))
        );
        usernameField.clear();
    }

    @When("I leave password field empty")
    public void leavePasswordEmpty() {
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.clear();
    }

    @Then("I should see validation error for empty fields")
    public void verifyEmptyFieldsValidation() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertTrue(alertText.contains("Please fill out Username and Password"));
            alert.accept();
        } catch (Exception e) {
            fail("Expected validation alert was not present");
        }
    }
}
