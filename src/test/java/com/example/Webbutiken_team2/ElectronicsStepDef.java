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
public class ElectronicsStepDef { // Jaime Lavalle

    static WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("the user is on the products page of the shop")
    public void the_user_is_on_the_products_page_of_the_shop() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
        driver.manage().window().maximize();
    }

    @Then("the user should be in the correct products page")
    public void the_user_should_be_in_the_correct_products_page() {
        Assertions.assertEquals("The Shop | Products", driver.getTitle());
    }

    //The user navigate to the Home page from Electronics

    @When("the user clicks on the Electronics link")
    public void the_user_clicks_on_the_electronics_link() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[5]/a")).click();
    }

    @Then("the user get the electronics page")
    public void the_user_get_the_electronics_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://webshop-agil-testautomatiserare.netlify.app/products#", currentUrl);
    }

    // The Home link

    @When("the user clicks on the home link")
    public void the_user_clicks_on_the_home_link() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Home")).click();
    }
    @Then("the user should be in the home page")
    public void the_user_should_be_in_the_home_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://webshop-agil-testautomatiserare.netlify.app/", currentUrl);
    }

    // The About link
    @When("the user clicks on the about link")
    public void the_user_clicks_on_the_about_link() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("About")).click();
    }
    @Then("the user should be in the about page")
    public void the_user_should_be_in_the_about_page() {

        Assertions.assertEquals("The Shop | About", driver.getTitle());
    }

    // the Shop link
    @When("the user clicks on the Shop link")
    public void the_user_clicks_on_the_shop_link() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Shop")).click();
    }
    @Then("the user should be in the Shop page")
    public void the_user_should_be_in_the_shop_page() {
        Assertions.assertEquals("The Shop | Products", driver.getTitle());

    }


    // The checkout link
    @When("the user clicks on the Checkout link")
    public void the_user_clicks_on_the_checkout_link() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.linkText("Checkout")).click();
        WebElement element = driver.findElement(By.linkText("Checkout"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

}
