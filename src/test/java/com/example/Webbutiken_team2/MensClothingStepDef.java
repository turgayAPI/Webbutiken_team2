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
import java.time.Duration; import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MensClothingStepDef {
    static WebDriver driver;

    @Before public void maximizeWindow() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); }

    @Given("user on the Products page")
    public void user_on_the_products_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy( By.xpath("//div[@class = 'col']"))); }

    @When("click on the men's clothing link")
    public void click_on_the_men_s_clothing_link() {
        driver.findElement(By.xpath("//a[@class='nav-link px-2 link-body-emphasis' and text()[contains(.,'Men')]]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllJeweleryDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy( By.xpath("//div[@class = 'col']"))); }

    @Then("the amount of men's clothing products equal {int}")
    public void the_amount_of_men_s_clothing_products_equal(Integer expectedAmountOfAllMensClothing) {
        int actualAmountOfAllMensClothing = driver.findElements(By.xpath("//div[@class='col']")).size();
        assertEquals (expectedAmountOfAllMensClothing,actualAmountOfAllMensClothing);
    }
    @Then("A list of men's clothing products with their names, descriptions, and prices should be displayed")
    public void a_list_of_mens_clothing_products_with_their_names_descriptions_and_prices_should_be_displayed() {
        List<WebElement> productList = driver.findElements(By.className("product"));
        for (WebElement product : productList) {
            WebElement nameElmnt = product.findElement(By.className("product-name"));
            WebElement descriptionElmnt = product.findElement(By.className("product-description"));
            WebElement priceElmnt = product.findElement(By.className("product-price"));
        }
    }
    @Then("The product names on the Men's Clothing page should be descriptive and easy to understand")
    public void the_product_names_on_the_mens_clothing_page_should_be_descriptive_and_easy_to_understand() {
        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement productName : productNames) {
            String name = productName.getText();
            assertNotNull(name, "Product name should not be null");
            assertTrue(!name.isEmpty(), "Product name should not be empty");
            assertTrue(name.matches("^[a-zA-Z0-9\\s]+$"), "Product name should contain only alphanumeric characters and spaces");
        }
    }
    @Then("The product descriptions on the Men's Clothing page should provide relevant information about the items")
    public void the_product_descriptions_on_the_mens_clothing_page_should_provide_relevant_information_about_the_items() {
        List<WebElement> productDescriptions = driver.findElements(By.cssSelector(".product-description"));
        for (WebElement description : productDescriptions) {
            String desc = description.getText();
            assertNotNull(desc, "Product description should not be null");
            assertTrue(!desc.isEmpty(), "Product description should not be empty");
            assertTrue(desc.contains("details") || desc.contains("information"), "Product description should contain relevant details");
        }
    }

    @Then("The product prices on the Men's Clothing page should be clearly visible and accurate")
    public void the_product_prices_on_the_mens_clothing_page_should_be_clearly_visible_and_accurate() {
        List<WebElement> productPrices = driver.findElements(By.cssSelector(".product-price"));
        for (WebElement price : productPrices) {
            String priceText = price.getText();
            assertNotNull(priceText, "Product price should not be null");
            assertTrue(!priceText.isEmpty(), "Product price should not be empty");
            assertTrue(priceText.matches("^\\$\\d+\\.\\d{2}$"), "Product price should be in the format $XX.XX");
        }
    }
}
