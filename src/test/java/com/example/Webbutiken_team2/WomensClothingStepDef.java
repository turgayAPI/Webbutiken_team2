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

import static org.junit.Assert.assertEquals;


public class WomensClothingStepDef {
    private WebDriver driver;

    @Before //Turgay
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User is on the Shop page") //Turgay
    public void user_is_on_the_shop_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
        driver.manage().window().maximize();
        WebElement shopBtn = driver.findElement(By.xpath("//a[text()='Shop']"));
        shopBtn.click();
    }

    @When("User selects the 'Women's Clothing' section") //Turgay
    public void user_selects_the_women_s_clothing_section() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement womenClothingBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"renderProducts('women')\"]")));
        Actions actions = new Actions(driver);

        for (int i = 0; i < 3; i++) {
            try {
                actions.moveToElement(womenClothingBtn).click().perform();
                break;
            } catch (WebDriverException e) {
                Thread.sleep(1000);
            }
        }


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("renderProducts('women');");

    }

    @When("User scrolls down to the 'Women's Clothing' section") //Turgay
    public void user_scrolls_down_to_the_women_s_clothing_section() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @Then("User should see total {int} products from Women's Clothing section") //Turgay
    public void user_should_see_total_products_from_women_s_clothing_section(int totalProduct) {
        int actualAmountOfAllProducts = driver.findElements(By.xpath("//div[@class='col']")).size();
        assertEquals(totalProduct, actualAmountOfAllProducts);
    }


    @When("the user clicks the Add to cart button for the first product") //Turgay
    public void the_user_clicks_the_add_to_cart_button_for_the_first_product() {
        final int MAX_ATTEMPTS = 3;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, 'BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats')]"));
                Actions actions = new Actions(driver);
                actions.moveToElement(addToCartButton).click().perform();
                break;
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS) throw e;

            }
        }

    }

    @Then("the product should be added to the cart") //Turgay
    public void the_product_should_be_added_to_the_cart() {
        WebElement checkOutBtn = driver.findElement(By.xpath("//a[contains(@class, 'btn btn-warning') and contains(text(), 'Checkout')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkOutBtn);
        Assert.assertTrue(checkOutBtn.isDisplayed());
    }

    @Then("the cart count should increase by {int}") //Turgay
    public void the_cart_count_should_increase_by(Integer int1) {
        WebElement cartBadge = driver.findElement(By.id("buttonSize"));
        String itemCount = cartBadge.getText();
        assertEquals(int1.toString(), itemCount);

    }

    @And("the user navigates the cart page") //Turgay
    public void theUserNavigatesTheCartPage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout");

    }

    @And("the user enters {string} in the first name field") //Turgay
    public void theUserEntersInTheFirstNameField(String firstName) {
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='firstName']\n"));
        firstNameInput.sendKeys(firstName);
    }


    @And("the user enters {string} in the last name field") //Turgay
    public void theUserEntersInTheLastNameField(String lastName) {
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='lastName']\n"));
        lastNameInput.sendKeys(lastName);
    }

    @And("the user enters {string} in the email field") //Turgay
    public void theUserEntersInTheEmailField(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email' and @class='form-control' and @id='email']\n"));
        emailInput.sendKeys(email);

    }

    @And("the user enters {string} in the address field") //Turgay
    public void theUserEntersInTheAddressField(String address) {
        WebElement addressInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='address']\n"));
        addressInput.sendKeys(address);
    }

    @And("the user enter {string} in the country field") //Turgay
    public void theUserEnterInTheCountryField(String country) {
        WebElement countryInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='country']\n"));
        countryInput.sendKeys(country);
    }

    @And("the user enters {string} in the city field") //Turgay
    public void theUserEntersInTheCityField(String city) {
        WebElement cityInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='city']\n"));
        cityInput.sendKeys(city);
    }

    @And("the user enters {string} in the zip code field") //Turgay
    public void theUserEntersInTheZipCodeField(String zip) {
        WebElement zipInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='zip']\n"));
        zipInput.sendKeys(zip);
    }

    @And("the user enters {string} in the name on card field") //Turgay
    public void theUserEntersInTheNameOnCardField(String name) {
        WebElement nameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-name']\n"));
        nameInput.sendKeys(name);
    }

    @And("the user enters {string} in the credit card number field") //Turgay
    public void theUserEntersInTheCreditCardNumberField(String creditCard) {
        WebElement creditCardInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-number']\n"));
        creditCardInput.sendKeys(creditCard);
    }

    @And("the user enters {string} in the expiration field") //Turgay
    public void theUserEntersInTheExpirationField(String expiration) {
        WebElement expirationInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-expiration']\n"));
        expirationInput.sendKeys(expiration);
    }

    @And("the user enters {string} in the CVV field") //Turgay
    public void theUserEntersInTheCVVField(String cvv) {
        WebElement cvvInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-cvv']\n"));
        cvvInput.sendKeys(cvv);
    }

    @And("the user submits the checkout form") //Turgay
    public void theUserSubmitsTheCheckoutForm() {
        WebElement checkoutBtn = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary') and text()='Continue to checkout']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);


    }

    @And("the user selects the {string} as payment method") //Turgay
    public void theUserSelectsTheAsPaymentMethod(String paymentMethod) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton;

        switch (paymentMethod.toLowerCase()) {
            case "credit card":
                radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("credit")));
                break;
            case "debit card":
                radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("debit")));
                break;
            case "paypal":
                radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("paypal")));
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

        if (!radioButton.isSelected()) {
            try {
                radioButton.click();
            } catch (ElementClickInterceptedException e) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
            }
        }
    }

    @Then("the user sees a warning about redirecting to paypal") //Turgay
    public void theUserSeesAWarningAboutRedirectingToPaypal() {
        WebElement paypalSign = driver.findElement(By.xpath("//i[text()='You will be redirected to PayPal in the next step.']\n"));
        Assert.assertTrue(paypalSign.isDisplayed());

    }

    @Then("User sees all the product's image") //Turgay
    public void userSeesAllTheProductSImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("main#main .col .card-img-top")));

        List<WebElement> images = driver.findElements(By.cssSelector("main#main .col .card-img-top"));

        Assert.assertEquals("The number of images does not match the expected value.", 12, images.size());

    }

    @And("User sees all the product's name") //Turgay
    public void userSeesAllTheProductSName() {
        List<WebElement> elementsWithCardTitleClass = driver.findElements(By.className("card-title"));
        int count = 0;
        for (WebElement element : elementsWithCardTitleClass) {
            if (element.getAttribute("class").contains("fs-4")) {
                count++;
            }
        }
        assertEquals(6, count);
    }

    @And("User sees all the product's price") //Turgay
    public void userSeesAllTheProductSPrice() {

        List<WebElement> elementsWithDollarSign = driver.findElements(By.xpath("//*[contains(text(),'$')]"));
        assertEquals(12, elementsWithDollarSign.size());
    }

    @And("User sees all the product's description") //Turgay
    public void userSeesAllTheProductSDescription() {
        List<WebElement> elementsWithCardTextClass = driver.findElements(By.className("card-text"));
        assertEquals(12, elementsWithCardTextClass.size());
    }

    @And("the user clicks the Add to cart button for all the products") //Turgay
    public void theUserClicksTheAddToCartButtonForAllTheProducts() {
        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
        for (WebElement button : buttons) {
            button.click();
        }
    }

    @After //Turgay
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
