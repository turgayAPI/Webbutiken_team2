package com.example.Webbutiken_team2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndToEndCase2StepDef { // Jaime Lavalle
    static WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("the user is in the TheShop page")
    public void the_user_is_in_the_the_shop_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

    }

    @When("the user clicks on the All Products button")
    public void the_user_clicks_on_the_all_products_button() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/button")).click();

    }

    @When("the user clicks on the Add to cart button to add a product")
    public void the_user_clicks_on_the_add_to_cart_button_to_add_a_product() {
        WebElement element = driver.findElement(By.xpath("/html/body/main/div[1]/div/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    @When("the user clicks on the Add to cart button to add a new product")
    public void the_user_clicks_on_the_add_to_cart_button_to_add_a_new_product() {
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/div/div/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    @When("the user clicks on the Checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/header/div/div/div/a")).click();
    }

    @When("the user clicks on the Remove button to remove a product")
    public void the_user_clicks_on_the_remove_button_to_remove_a_product() {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/ul/li[2]/div/button")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/ul/li[1]/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    // fills out the form
    @When("the user with first-name {string} with last-name {string} with email {string} with address {string} with country {string} with city {string} with zip {string} with name-on-card {string} with credit-card-number {string} with expiration {string} with CVV {string} fills out the form")
    public void the_user_with_first_name_with_last_name_with_email_with_address_with_country_with_city_with_zip_with_name_on_card_with_credit_card_number_with_expiration_with_cvv_fills_out_the_form(String first, String last, String email, String address, String country, String city, String zip, String nameoncard, String cardnumber, String expiration, String cvv) {
        driver.findElement(By.id("firstName")).sendKeys(first);
        driver.findElement(By.id("lastName")).sendKeys(last);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zip")).sendKeys(zip);
        driver.findElement(By.id("cc-name")).sendKeys(cardnumber);
        driver.findElement(By.id("cc-expiration")).sendKeys(expiration);
        driver.findElement(By.id("cc-cvv")).sendKeys(cvv);

    }
    @When("the user clicks on the Continue to check button")
    public void the_user_clicks_on_the_continue_to_check_button() {
        WebElement element = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/form/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    @Then("the user would succeed with the order")
    public void the_user_would_succeed_with_the_order() {
        Assertions.assertEquals("The Shop | Checkout", driver.getTitle());
    }
    //tear down
    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
