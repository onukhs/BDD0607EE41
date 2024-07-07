package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserSetup;

public class LoginStepsDefinition {

    private WebDriver driver = BrowserSetup.getDriver();

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage(){
        driver.get("https://www.saucedemo.com/");
        System.out.println("I opened a login page");
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        System.out.println("I entered valid credentials");
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.id("login-button")).click();
        System.out.println("I click on Login button");
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        System.out.println("I am logged in, for sure");
    }

    @When("I enter {word} and valid password")
    public void iEnterUsernameAndValidPassword(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        System.out.println("I entered username: " + username + " and valid password");
    }

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
        driver.findElement(By.id("login-button"));
    }

    @And("Error message {string} should be displayed")
    public void errorMessageErrorShouldBeDisplayed(String errorMessage) {
        driver.findElement(By.xpath("//*[contains(text(), 'Epic sadface: " + errorMessage + "')]"));
    }
}
