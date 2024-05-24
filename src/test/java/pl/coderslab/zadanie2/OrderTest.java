package pl.coderslab.zadanie2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrderTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
    @Test
    public void shouldMakeNewOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("adam.nowak22@wp.pl", "123456");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToMainPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseProduct();
        productPage.chooseSize();
        productPage.customSize('M');
        productPage.chooseQuantity(5);
        productPage.addToCart();
        ProceedToCheckoutPage proceedToCheckoutPage = new ProceedToCheckoutPage(driver);
        proceedToCheckoutPage.proceedToCheckout();
        productPage.goToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.checkout();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.confirmAddresses();
        orderPage.confirmShippingMethod();
        orderPage.choosePaymentOption();
        orderPage.agreeToTheTerms();
        orderPage.placeOrder();
        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);
        orderConfirmedPage.takeScreenshot();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
