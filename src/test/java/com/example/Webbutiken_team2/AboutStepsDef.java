package com.example.Webbutiken_team2;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AboutStepsDef {
    private WebDriver driver;

    @Before //Turgay
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Given("the user is  on the Homepage") //Turgay
    public void the_user_is_on_the_homepage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

    }

    @When("the user clicks on the {string} link in the navigation bar") //Turgay
    public void the_user_clicks_on_the_link_in_the_navigation_bar(String string) {
        WebElement aboutLink = driver.findElement(By.xpath("//a[@class='nav-link px-2 text-white' and text()='About']\n"));
        aboutLink.click();
    }

    @Then("I should be redirected to the About page") //Turgay
    public void i_should_be_redirected_to_the_about_page() {

        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/about";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("The user should be redirected to the About page", expectedUrl, actualUrl);

    }

    @Then("the title of the page should be {string}") //Turgay
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The page title should match the expected title", expectedTitle, actualTitle);

    }

    @Given("the user is on the About page") //Turgay
    public void the_user_is_on_the_about_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/about");
    }

    @When("the user scrolls down the webpage") //Turgay
    public void the_user_scrolls_down_the_webpage() {

        WebElement header = driver.findElement(By.xpath("//h2[@class='h2 fw-bold lh-1' and text()='About The Shop']\n"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", header);

    }

    @Then("the user sees the heading {string}") //Turgay
    public void the_user_sees_the_heading(String string) {
        WebElement header = driver.findElement(By.xpath("//h2[@class='h2 fw-bold lh-1' and text()='About The Shop']\n"));
        Assert.assertTrue(header.isDisplayed());

    }

    @Then("the user sees the text about the shop") //Turgay
    public void the_user_sees_the_text_about_the_shop() {

        WebElement paragraph = driver.findElement(By.xpath("//p[contains(text(), 'Welcome to The Shop, your premier online destination for all things fashion')]"));

        Assert.assertTrue("The text is not displayed on the page", paragraph.isDisplayed());
    }

    @Then("the user sees a navigation link for the The Shop logo") //Turgay
    public void theUserSeesANavigationLinkForTheTheShopLogo() {
        WebElement theShopLogo = driver.findElement(By.xpath("//a[contains(@class, 'text-white text-decoration-none') and contains(@href, '/')]/h1[text()='\uD83D\uDECD\uFE0F The Shop']\n"));
        Assert.assertTrue(theShopLogo.isDisplayed());
    }

    @And("the user sees navigation link for Home") //Turgay
    public void theUserSeesNavigationLinkForHome() {
        WebElement homeLogo = driver.findElement(By.xpath("//a[@class='nav-link px-2 text-white' and @href='/' and text()='Home']\n"));
        Assert.assertTrue(homeLogo.isDisplayed());
    }

    @And("the user sees a navigation link for Shop") //Turgay
    public void theUserSeesANavigationLinkForShop() {
        WebElement shopLogo = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'text-white') and @href='/products' and contains(text(), 'Shop')]\n"));
        Assert.assertTrue(shopLogo.isDisplayed());
    }

    @And("the user sees a navigation link for About") //Turgay
    public void theUserSeesANavigationLinkForAbout() {
        WebElement aboutLogo = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'text-white') and @href='/about' and contains(text(), 'About')]\n"));
        Assert.assertTrue(aboutLogo.isDisplayed());
    }

    @And("the user sees a navigation link for Checkout") //Turgay
    public void theUserSeesANavigationLinkForCheckout() {
        WebElement checkOutLogo = driver.findElement(By.xpath("//a[@class='btn btn-warning' and @href='/checkout' and contains(text(), '\uD83D\uDED2 Checkout')]\n"));
        Assert.assertTrue(checkOutLogo.isDisplayed());
    }

    @And("the user sees see a link or button for To all products") //Turgay
    public void theUserSeesSeeALinkOrButtonForToAllProducts() {
        WebElement toAllProducts = driver.findElement(By.xpath("//button[@type='button' and contains(@class, 'btn btn-primary btn-lg px-4 me-md-2 fw-bold') and contains(@onclick, \"window.location='products.html'\") and text()='To all products']\n"));
        Assert.assertTrue(toAllProducts.isDisplayed());
    }

    @Then("I should see the footer text {string}") //Turgay
    public void i_should_see_the_footer_text(String string) {
        WebElement footer = driver.findElement(By.xpath("//p[contains(@class, 'col-md-4') and contains(@class, 'mb-0') and contains(@class, 'text-muted') and contains(text(), '© 2024 The Shop')]\n"));
        Assert.assertTrue(footer.isDisplayed());
    }

    @When("the user clicks on the Shop navigation link") //Turgay
    public void the_user_clicks_on_the_shop_navigation_link() {
        WebElement theShopLogo = driver.findElement(By.xpath("//a[contains(@class, 'text-white text-decoration-none') and contains(@href, '/')]/h1[text()='\uD83D\uDECD\uFE0F The Shop']\n"));
        theShopLogo.click();


    }

    @Then("the user is redirected to the shop page") //Turgay
    public void the_user_is_redirected_to_the_shop_page() {
        String expectedTitle = "The Shop";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("the user clicks on the Home navigation link") //Turgay
    public void the_user_clicks_on_the_home_navigation_link() {
        WebElement homeLogo = driver.findElement(By.xpath("//a[@class='nav-link px-2 text-white' and @href='/' and text()='Home']\n"));
        homeLogo.click();
    }

    @Then("the user is redirected to the homepage") //Turgay
    public void the_user_is_redirected_to_the_homepage() {
        String expectedTitle = "The Shop";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("the user clicks on the About navigation link") //Turgay
    public void the_user_clicks_on_the_about_navigation_link() {
        WebElement aboutLogo = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'text-white') and @href='/about' and contains(text(), 'About')]\n"));
        aboutLogo.click();

    }

    @Then("the user is redirected to the about page") //Turgay
    public void the_user_is_redirected_to_the_about_page() {
        String expectedTitle="The Shop | About";
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @When("the user clicks on the Checkout navigation link") //Turgay
    public void the_user_clicks_on_the_checkout_navigation_link() {
        WebElement checkOutLogo = driver.findElement(By.xpath("//a[@class='btn btn-warning' and @href='/checkout' and contains(text(), '\uD83D\uDED2 Checkout')]\n"));
        checkOutLogo.click();
    }

    @Then("the user is redirected to the checkout page") //Turgay
    public void the_user_is_redirected_to_the_checkout_page() {

        String expectedTitle="The Shop | Checkout";
        Assert.assertEquals(expectedTitle,driver.getTitle());

    }

    @When("the user clicks on the To all products link") //Turgay
    public void the_user_clicks_on_the_to_all_products_link() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[onclick*='products.html']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('button[onclick*=\\'products.html\\']').click();");
        } catch (TimeoutException e) {
            System.out.println("Element not found within timeout period.");

        }
    }


    @Then("the user is redirected to the products page") //Turgay
    public void the_user_is_redirected_to_the_products_page() {

        String expectedTitle="The Shop | Checkout";
        Assert.assertEquals(expectedTitle,driver.getTitle());

    }


    @After //Turgay
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
