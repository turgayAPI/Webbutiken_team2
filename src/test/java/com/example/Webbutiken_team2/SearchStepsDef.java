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

public class SearchStepsDef { //Jaime Lavalle

    static WebDriver driver;


    @Given("the user is in the products page")
    public void the_user_is_in_the_products_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
       driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
        driver.manage().window().maximize();
    }

    // Search one product
    @When("the user search for {string}")
    public void the_user_search_for(String searched_product) {
        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys(searched_product);

    }

    @Then("the result should display {string}") public void the_result_should_display(String expected_product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy( By.xpath("//*[@class ='card-title fs-4']")));
        String actualProduct = driver.findElement(By.xpath("//*[@class ='card-title fs-4']")).getText();
        Assertions.assertEquals(expected_product, actualProduct); }


    //tear down
    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
