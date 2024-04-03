package com.example.Webbutiken_team2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutStepsDef {
    static WebDriver driver;

    @Before
    public void maximizeWindow(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("the user on the checkout page")
    public void the_user_on_the_checkout_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout");
    }
    @Then("checkout pages title is {string}")
    public void checkout_pages_title_is(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("the title is present")
    public void the_title_is_present() {
        String expectedTitleOnThePage = "Checkout form";
        String actualTitleOnThePage = driver.findElement(By.tagName("h2")).getText();
        assertEquals(expectedTitleOnThePage, actualTitleOnThePage);
    }
    @Then("the welcome message is present")
    public void the_welcome_message_is_present() {
       String expectedMessage = "Fill in the form and edit the cart if you like \uD83D\uDCAB";
       String actualMessage = driver.findElement(By.className("lead")).getText();
       assertEquals(expectedMessage, actualMessage);
    }
   /* @Then("no error is present")
    public void no_error_is_present() {
        List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@class = 'invalid-feedback']"));
        boolean isErrorPresent = errorMessages.getFirst().isDisplayed();
        assertFalse(isErrorPresent);
    }

    */

    @When("fill fields with values {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fill_fields_with_values(String firstName, String lastName, String email, String address, String country, String city, String zip) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zip")).sendKeys(zip);
    }
    @When("choose [debit card] radio button")
    public void choose_debit_card_radio_button() {
        WebElement element = driver.findElement(By.xpath("//*[@class='form-check-label' and text()='Debit card']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    @When("continue filling the fields with values {string}, {string}, {string}, {string}")
    public void continue_filling_the_fields_with_values(String ccName, String ccNumber, String ccExpiration, String ccCvv) {
        driver.findElement(By.id("cc-name")).sendKeys(ccName);
        driver.findElement(By.id("cc-number")).sendKeys(ccNumber);
        driver.findElement(By.id("cc-expiration")).sendKeys(ccExpiration);
        driver.findElement(By.id("cc-cvv")).sendKeys(ccCvv);
    }
    @When("click on the [Continue to checkout] button")
    public void click_on_the_continue_to_checkout_button() {
        WebElement element = driver.findElement(By.xpath("//button[@class = 'w-100 btn btn-primary btn-lg']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
   /* @Then("error messages are present")
    public void error_messages_are_present() {
        List<WebElement> errorMessages = driver.findElements(By.xpath("//*[@class = 'invalid-feedback']"));
        boolean isErrorPresent = errorMessages.getFirst().isDisplayed();
        assertTrue(isErrorPresent);
    }

    */
    @When("choose PayPal by radiobutton")
    public void choose_pay_pal_by_radiobutton() {
        WebElement element = driver.findElement(By.xpath("//*[@class='form-check-label' and text()='PayPal']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    @Then("credit card fields disappear")
    public void credit_card_fields_disappear() {
        boolean isCcNamePresent = driver.findElement(By.id("cc-name")).isDisplayed();
        boolean isCcNumberPresent = driver.findElement(By.id("cc-number")).isDisplayed();//
        boolean isCcExpirationPresent = driver.findElement(By.id("cc-expiration")).isDisplayed();
        boolean isCcCvvPresent = driver.findElement(By.id("cc-expiration")).isDisplayed();

        assertAll(
                () -> assertFalse(isCcNamePresent),
                () -> assertFalse(isCcNumberPresent ),
                () -> assertFalse(isCcExpirationPresent),
                () -> assertFalse(isCcCvvPresent)
        );
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
