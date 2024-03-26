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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AllProductsStepsDef { //Yevheniia Kornilova
    static WebDriver driver;
    @Before
    public void maximizeWindow(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @Given("the user on the products page")
    public void the_user_on_the_products_page() throws InterruptedException {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
               By.xpath("//div[@class = 'col']")));
    }
    @When("click on the All products link")
    public void click_on_the_all_products_link(){
        driver.findElement(By.xpath("//a[@class='nav-link px-2 link-body-emphasis' and text()='All']")).click();
    }
    @Then("all products are present on the page")
    public void all_products_are_present_on_the_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class = 'col']")));
        assertNotNull(waitForAllProductsDisplaying);
        boolean isProductsDisplayed = waitForAllProductsDisplaying.isEmpty();
        assertFalse(isProductsDisplayed);
    }
    @Then("the amount of products equal {int}")
    public void the_amount_of_products_equal(Integer expectedAmountOfAllProducts){
        int actualAmountOfAllProducts = driver.findElements(By.xpath("//div[@class='col']")).size();
        assertEquals(expectedAmountOfAllProducts,actualAmountOfAllProducts);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
