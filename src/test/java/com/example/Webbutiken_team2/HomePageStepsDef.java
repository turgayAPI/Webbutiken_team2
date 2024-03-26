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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageStepsDef { //Yevheniia Kornilova
    static WebDriver driver;

    @Before
    public void maximizeWindow(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("the user on the home page")
    public void the_user_on_the_home_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app");
    }
    @Then("home pages title is {string}")
    public void home_pages_title_is(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @Then("Home link is present")
    public void home_link_is_present() {
        boolean isHomeLinkPresent = driver.findElement(By.xpath(
                "//*[@class = 'nav-link px-2 text-white' and text()='Home']")).isDisplayed();
        assertTrue(isHomeLinkPresent);
    }
    @When("click on the Home link")
    public void click_on_the_home_link() {
        driver.findElement(By.xpath(
                "//*[@class = 'nav-link px-2 text-white' and text()='Home']")).click();
    }
    @Then("the user goes to the home page")
    public void the_user_goes_to_the_home_page() {
        String expectedPagesTitle = "Webbutiken";
        String actualPagesTitle = driver.getTitle();
        assertEquals(expectedPagesTitle,actualPagesTitle);
    }
    @Then("Shop link is present")
    public void shop_link_is_present() {
        boolean isHomeLinkPresent = driver.findElement(By.xpath(
                "//*[@class = 'nav-link px-2 text-white' and text()='Shop']")).isDisplayed();
        assertTrue(isHomeLinkPresent);
    }
    @When("click on the Shop link")
    public void click_on_the_shop_link() {
        driver.findElement(By.xpath(
                "//*[@class = 'nav-link px-2 text-white' and text()='Shop']")).click();
    }

    @Then("the user goes to the shop page")
    public void the_user_goes_to_the_shop_page() {
        String expectedPagesTitle = "Webbutiken";
        String actualPagesTitle = driver.getTitle();
        assertEquals(expectedPagesTitle, actualPagesTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> waitForAllProductsDisplaying = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class = 'col']")));
        assertNotNull(waitForAllProductsDisplaying);
    }
    @Then("Checkout button is present")
    public void checkout_button_is_present() {
        boolean isCheckoutButtonDisplayed = driver.findElement(By.xpath(
                "//a[@class = 'btn btn-warning']")).isDisplayed();
        assertTrue(isCheckoutButtonDisplayed);
    }
    @When("click on the Checkout button")
    public void click_on_the_checkout_button() {
        driver.findElement(By.xpath("//a[@class = 'btn btn-warning']")).click();
    }
    @When("the user goes to the checkout page")
    public void the_user_goes_to_the_checkout_page() {
        String expectedPagesTitle = "Webbutiken";
        String actualPagesTitle = driver.getTitle();
        assertEquals(expectedPagesTitle, actualPagesTitle);

        WebElement isCheckoutFormPresent = driver.findElement(By.cssSelector("div[class='row g-5']"));
        assertNotNull(isCheckoutFormPresent);
    }
    @Then("title on the home page is present")
    public void title_on_the_home_page_is_present() {
        String expectedTitleOnTheHomePage = "This shop is all you need";
        String actualTitleOnTheHomePage = driver.findElement(By.tagName("h2")).getText();
        assertEquals(expectedTitleOnTheHomePage,actualTitleOnTheHomePage);
    }
    @Then("description of Webshop is present on the home page")
    public void description_of_webshop_is_present_on_the_home_page() {
        boolean webshopsDescription = driver.findElement(By.className("lead")).isDisplayed();
        assertTrue(webshopsDescription);
    }
    @Then("the image with the product is present on the home page")
    public void the_image_with_the_product_is_present_on_the_home_page() {
       boolean imageOfProductIsPresent = driver.findElement(By.className("rounded-lg-3")).isDisplayed();
       assertTrue(imageOfProductIsPresent);
    }
    @Then("the [All products] button is present on the home page")
    public void the_all_products_button_is_present_on_the_home_page() {
        boolean isTheAllProductsButtonPresent = driver.findElement(By.xpath(
                "//button[@class = 'btn btn-primary btn-lg px-4 me-md-2 fw-bold' and text()='All products']")).isDisplayed();
        assertTrue(isTheAllProductsButtonPresent);
    }
    @When("click on the [All products] button")
    public void click_on_the_all_products_button() {
        driver.findElement(By.xpath(
                "//button[@class = 'btn btn-primary btn-lg px-4 me-md-2 fw-bold' and text()='All products']")).click();
    }
    @Then("the user navigates to the Products page")
    public void the_user_navigates_to_the_products_page() {
        String expectedPagesTitle = "Webbutiken";
        String actualPagesTitle = driver.getTitle();
        assertEquals(expectedPagesTitle, actualPagesTitle);

        WebElement isAllProductsPresent = driver.findElement(By.id("main"));
        assertNotNull(isAllProductsPresent);
    }
    @Then("the copyright is present on the page")
    public void the_copyright_is_present_on_the_page() {
        boolean isCopyrightIsPresent = driver.findElement(By.xpath(
                "//p[@class = 'col-md-4 mb-0 text-muted' and text()='© 2023 The Shop']")).isDisplayed();
        assertTrue(isCopyrightIsPresent);
    }
    @Then("titles of navigation links should match:")
    public void titles_of_navigation_links_should_match(List<String> expectedTitles) {
        List<WebElement> actualTitles = driver.findElements(By.className("nav-item"));
        for (String expectedTitle: expectedTitles){
            boolean valueFound = false;
            for(WebElement element: actualTitles){
                if(element.getText().equals(expectedTitle)){
                    valueFound = true;
                    break;
                }
            }
            assertTrue(valueFound);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


