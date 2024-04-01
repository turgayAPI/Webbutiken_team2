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



public class WomensClothingStepDef {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User is on the Shop page")
    public void user_is_on_the_shop_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
        driver.manage().window().maximize();
        WebElement shopBtn = driver.findElement(By.xpath("//a[text()='Shop']"));
        shopBtn.click();
    }

    @When("User selects the 'Women's Clothing' section")
    public void user_selects_the_women_s_clothing_section() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement womenClothingBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"renderProducts('women')\"]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenClothingBtn).click().perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("renderProducts('women');");

    }

    @When("User scrolls down to the 'Women's Clothing' section")
    public void user_scrolls_down_to_the_women_s_clothing_section() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @Then("User should see total {int} products from Women's Clothing section")
    public void user_should_see_total_products_from_women_s_clothing_section(int totalProduct) {
        List<WebElement> productElements = driver.findElements(By.xpath("//div[contains(@class, 'col')]//div[contains(@class, 'card h-100 p-3')]"));
        int productCount = productElements.size();
        System.out.println("Total products found: " + productCount);
        Assert.assertEquals("The number of products in the Women's Clothing section is not as expected.", totalProduct, productCount);
    }


    @When("the user clicks the Add to cart button for the first product")
    public void the_user_clicks_the_add_to_cart_button_for_the_first_product() {
        final int MAX_ATTEMPTS = 3;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, 'BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats')]"));
                Actions actions = new Actions(driver);
                actions.moveToElement(addToCartButton).click().perform();
                break;
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS) throw e; // Rethrow the exception on the last attempt
                // Optionally, add a short wait here before retrying
            }
        }

    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        WebElement checkOutBtn = driver.findElement(By.xpath("//a[contains(@class, 'btn btn-warning') and contains(text(), 'Checkout')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkOutBtn);
        Assert.assertTrue(checkOutBtn.isDisplayed());
    }

    @Then("the cart count should increase by {int}")
    public void the_cart_count_should_increase_by(Integer int1) {
        WebElement cartBadge = driver.findElement(By.id("buttonSize"));
        String itemCount = cartBadge.getText();
        Assert.assertEquals(int1.toString(), itemCount);

    }

    @When("the user clicks the Add to cart button for the second product")
    public void the_user_clicks_the_add_to_cart_button_for_the_second_product() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, \"Lock and Love Womens Removable Hooded Faux Leather Moto Biker Jacket\")]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    @And("the user clicks the Add to cart button for the third product")
    public void theUserClicksTheAddToCartButtonForTheThirdProduct() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, \"Rain Jacket Women Windbreaker Striped Climbing Raincoats\")]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    @And("the user clicks the Add to cart button for the fourth product")
    public void theUserClicksTheAddToCartButtonForTheFourthProduct() {
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary' and contains(text(),'Add to cart')])[4]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    @And("the user clicks the Add to cart button for the fifth product")
    public void theUserClicksTheAddToCartButtonForTheFifthProduct() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, 'Opna Womens Short Sleeve Moisture')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    @And("the user clicks the Add to cart button for the sixth product")
    public void theUserClicksTheAddToCartButtonForTheSixthProduct() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick, 'DANVOUY Womens T Shirt Casual Cotton Short')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    @Then("User sees the first product's image")
    public void user_sees_the_first_product_s_image() {
        WebElement image = driver.findElement(By.xpath("//img[@alt=concat('BIYLACLESEN Women', \"'\", 's 3-in-1 Snowboard Jacket Winter Coats')]\n"));
        Assert.assertTrue(image.isDisplayed());

    }

    @Then("User sees the first product's name")
    public void user_sees_the_first_product_s_name() {
        WebElement name = driver.findElement(By.xpath("//h3[@class='card-title fs-4']"));
        Assert.assertTrue(name.isDisplayed());

    }

    @And("User sees the first product's price")
    public void userSeesTheFirstProductSPrice() {
        WebElement price = driver.findElement(By.xpath("//strong[text()='$ 56.99']"));
        Assert.assertTrue(price.isDisplayed());
    }

    @Then("User sees the first product's description")
    public void user_sees_the_first_product_s_description() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and contains(text(), 'cool och åker snowboard')]\n"));
        Assert.assertTrue(description.isDisplayed());
    }


    @Then("User sees the second product's image")
    public void userSeesTheSecondProductSImage() {
        WebElement image = driver.findElement(By.xpath("//img[@src='https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg']\n"));
        Assert.assertTrue(image.isDisplayed());
    }

    @And("User sees the second product's name")
    public void userSeesTheSecondProductSName() {
        WebElement name = driver.findElement(By.xpath("//h3[text()='Rain Jacket Women Windbreaker Striped Climbing Raincoats']\n"));
        Assert.assertTrue(name.isDisplayed());
    }

    @And("User sees the second product's price")
    public void userSeesTheSecondProductSPrice() {

        WebElement price = driver.findElement(By.xpath("//p[@class='fs-5'][strong[text()='$ 39.99']]\n"));
        Assert.assertTrue(price.isDisplayed());

    }

    @And("User sees the second product's description")
    public void userSeesTheSecondProductSDescription() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and text()='Lättviktsjacka och som andas .']\n"));
        Assert.assertTrue(description.isDisplayed());
    }


    @Then("User sees the third product's image")
    public void userSeesTheThirdProductSImage() {
        WebElement image = driver.findElement(By.xpath("//img[@class='card-img-top' and @alt='Rain Jacket Women Windbreaker Striped Climbing Raincoats']\n"));
        Assert.assertTrue(image.isDisplayed());
    }

    @And("User sees the third product's name")
    public void userSeesTheThirdProductSName() {
        WebElement name = driver.findElement(By.xpath("//h3[text()='Rain Jacket Women Windbreaker Striped Climbing Raincoats']\n"));
        Assert.assertTrue(name.isDisplayed());
    }

    @And("User sees the third product's price")
    public void userSeesTheThirdProductSPrice() {
        WebElement price = driver.findElement(By.xpath("//p[@class='fs-5'][strong[text()='$ 39.99']]\n"));
        Assert.assertTrue(price.isDisplayed());

    }

    @And("User sees the third product's description")
    public void userSeesTheThirdProductSDescription() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and text()='Lättviktsjacka och som andas .']\n"));
        Assert.assertTrue(description.isDisplayed());
    }

    @Then("User sees the fourth product's image")
    public void userSeesTheFourthProductSImage() {
        WebElement image = driver.findElement(By.xpath("//img[@src='https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg']\n"));
        Assert.assertTrue(image.isDisplayed());

    }

    @And("User sees the fourth product's name")
    public void userSeesTheFourthProductSName() {
        WebElement name = driver.findElement(By.xpath("//h3[contains(text(), 'MBJ Women')]\n"));
        Assert.assertTrue(name.isDisplayed());

    }

    @And("User sees the fourth product's price")
    public void userSeesTheFourthProductSPrice() {
        WebElement price = driver.findElement(By.xpath("//strong[text()='$ 9.85']"));
        Assert.assertTrue(price.isDisplayed());

    }

    @And("User sees the fourth product's description")
    public void userSeesTheFourthProductSDescription() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and contains(text(), 'Snygg och bara att sätta på sig')]\n"));
        Assert.assertTrue(description.isDisplayed());

    }

    @Then("User sees the fifth product's image")
    public void userSeesTheFifthProductSImage() {
        WebElement image = driver.findElement(By.xpath("//img[@alt=concat('Opna Women', \"'\", 's Short Sleeve Moisture')]\n"));
        Assert.assertTrue(image.isDisplayed());

    }

    @And("User sees the fifth product's name")
    public void userSeesTheFifthProductSName() {
        WebElement name = driver.findElement(By.xpath("//h3[contains(text(), 'Opna Women')]\n"));
        Assert.assertTrue(name.isDisplayed());

    }

    @And("User sees the fifth product's price")
    public void userSeesTheFifthProductSPrice() {
        WebElement price = driver.findElement(By.xpath("//strong[text()='$ 7.95']\n"));
        Assert.assertTrue(price.isDisplayed());

    }

    @And("User sees the fifth product's description")
    public void userSeesTheFifthProductSDescription() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and contains(text(), 'Kort i ärmarna')]\n"));
        Assert.assertTrue(description.isDisplayed());
    }

    @Then("User sees the sixth product's image")
    public void userSeesTheSixthProductSImage() {
        WebElement image = driver.findElement(By.xpath("//img[@alt=concat('Opna Women', \"'\", 's Short Sleeve Moisture')]\n"));
        Assert.assertTrue(image.isDisplayed());
    }

    @And("User sees the sixth product's name")
    public void userSeesTheSixthProductSName() {
        WebElement name = driver.findElement(By.xpath("//h3[contains(text(), 'Opna Women')]\n"));
        Assert.assertTrue(name.isDisplayed());
    }

    @And("User sees the sixth product's price")
    public void userSeesTheSixthProductSPrice() {
        WebElement price = driver.findElement(By.xpath("//strong[text()='$ 7.95']\n"));
        Assert.assertTrue(price.isDisplayed());
    }

    @And("User sees the sixth product's description")
    public void userSeesTheSixthProductSDescription() {
        WebElement description = driver.findElement(By.xpath("//p[@class='card-text' and contains(text(), 'Kort i ärmarna')]\n"));
        Assert.assertTrue(description.isDisplayed());
    }

    @And("the user navigates the cart page")
    public void theUserNavigatesTheCartPage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout");

    }

    @And("the user enters {string} in the first name field")
    public void theUserEntersInTheFirstNameField(String firstName) {
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='firstName']\n"));
        firstNameInput.sendKeys(firstName);
    }


    @And("the user enters {string} in the last name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='lastName']\n"));
        lastNameInput.sendKeys(lastName);
    }

    @And("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email' and @class='form-control' and @id='email']\n"));
        emailInput.sendKeys(email);

    }

    @And("the user enters {string} in the address field")
    public void theUserEntersInTheAddressField(String address) {
        WebElement addressInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='address']\n"));
        addressInput.sendKeys(address);
    }

    @And("the user enter {string} in the country field")
    public void theUserEnterInTheCountryField(String country) {
        WebElement countryInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='country']\n"));
        countryInput.sendKeys(country);
    }

    @And("the user enters {string} in the city field")
    public void theUserEntersInTheCityField(String city) {
        WebElement cityInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='city']\n"));
        cityInput.sendKeys(city);
    }

    @And("the user enters {string} in the zip code field")
    public void theUserEntersInTheZipCodeField(String zip) {
        WebElement zipInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='zip']\n"));
        zipInput.sendKeys(zip);
    }

    @And("the user enters {string} in the name on card field")
    public void theUserEntersInTheNameOnCardField(String name) {
        WebElement nameInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-name']\n"));
        nameInput.sendKeys(name);
    }

    @And("the user enters {string} in the credit card number field")
    public void theUserEntersInTheCreditCardNumberField(String creditCard) {
        WebElement creditCardInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-number']\n"));
        creditCardInput.sendKeys(creditCard);
    }

    @And("the user enters {string} in the expiration field")
    public void theUserEntersInTheExpirationField(String expiration) {
        WebElement expirationInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-expiration']\n"));
        expirationInput.sendKeys(expiration);
    }

    @And("the user enters {string} in the CVV field")
    public void theUserEntersInTheCVVField(String cvv) {
        WebElement cvvInput = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @id='cc-cvv']\n"));
        cvvInput.sendKeys(cvv);
    }

    @And("the user submits the checkout form")
    public void theUserSubmitsTheCheckoutForm() {
        WebElement checkoutBtn = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary') and text()='Continue to checkout']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);


    }

    @And("the user selects the {string} as payment method")
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

    @Then("the user sees a warning about redirecting to paypal")
    public void theUserSeesAWarningAboutRedirectingToPaypal() {
        WebElement paypalSign = driver.findElement(By.xpath("//i[text()='You will be redirected to PayPal in the next step.']\n"));
        Assert.assertTrue(paypalSign.isDisplayed());

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
