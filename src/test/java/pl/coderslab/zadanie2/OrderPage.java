package pl.coderslab.zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private static WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[contains(@class, 'btn-primary') and contains (@name, 'confirm-addresses')]")
    private WebElement confirmAddressesButton;

    @FindBy (xpath = "//input[contains(@type, 'radio') and contains (@id, 'delivery_option_8')]")
    private WebElement selfPickUpButton;
    @FindBy (xpath = "//button[contains(@class, 'btn-primary') and contains (@name, 'confirmDeliveryOption')]")
    private WebElement confirmShippingMethodButton;

    @FindBy (xpath = "//input[contains(@id, 'payment-option-1') and contains (@name, 'payment-option')]")
    private WebElement paymentOptionsButton;

    @FindBy (xpath = "//input[contains(@id, 'conditions_to_approve[terms-and-conditions]')]")
    private WebElement agreeToTheTermsButton;

    @FindBy (xpath = "//div[contains(@class, 'ps-shown-by-js')]//button")
    private WebElement placeOrderButton;


    public void confirmAddresses() {
        confirmAddressesButton.click();
    }

    public void confirmShippingMethod() {
        confirmShippingMethodButton.click();
    }

    public void choosePaymentOption() {

        paymentOptionsButton.click();
    }

    public void agreeToTheTerms() {

        agreeToTheTermsButton.click();
    }

    public void placeOrder() {

        placeOrderButton.click();
    }

}
