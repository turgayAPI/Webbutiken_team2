package com.example.Webbutiken_team2;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JeweleryStepsDef {
    static WebDriver driver;

    @Before
    public void maximizeWindow() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Given("the user on the Products page")
    public void the_user_on_the_products_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'col']")));
    }

    @When("click on the jewelery link")
    public void click_on_the_jewelery_link() {
        driver.findElement(By.xpath("//a[@class='nav-link px-2 link-body-emphasis' and text()='Jewelery']")).click();
    }

    @Then("jewelery is present on the page")
    public void jewelery_is_present_on_the_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllJeweryDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'col']")));
        assertNotNull(waitForAllJeweryDisplaying);
        boolean isJeweleryDisplayed = waitForAllJeweryDisplaying.isEmpty();
        assertFalse(isJeweleryDisplayed);
    }

    @Then("the amount of jewelery products equal {int}")
    public void the_amount_of_jewelery_products_equal(Integer expectedAmountOfAllJewelery) {
        int actualAmountOfAllJewelery = driver.findElements(By.xpath("//div[@class='col']")).size();
        assertEquals(expectedAmountOfAllJewelery, actualAmountOfAllJewelery);
    }
    @And("Each product has a name, description, and price")
    public void eachProductHasANameDescriptionAndPrice() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-card"));
        for (WebElement product : products) {
            WebElement nameElement = product.findElement(By.cssSelector(".product-name"));
            WebElement descriptionElement = product.findElement(By.cssSelector(".product-description"));
            WebElement priceElement = product.findElement(By.cssSelector(".product-price"));

            assertNotNull(nameElement.getText());
            assertNotNull(descriptionElement.getText());
            assertNotNull(priceElement.getText());
        }
    }
}


