package pl.coderslab.extam_task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {

    private static WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[href$='brown-bear-printed-sweater&controller=product#/1-size-s']")
    private WebElement printedSweater;
    @FindBy (xpath = "//select[contains(@id, 'group_1')]")
    private WebElement chooseSweaterSize;
    @FindBy (xpath = "//select//option[contains(@title, 'M')]")
    private WebElement chooseMSize;

    @FindBy (xpath = "//select//option[contains(@title, '$x')]")
    private WebElement customSize;

    @FindBy (xpath = "//button[contains(@class, 'add-to-cart')]")
    private WebElement addToCartButton;

 @FindBy (xpath = "//div[contains(@class, 'cart-content-btn')]//button")
    private WebElement proceedToCheckoutButton;
    @FindBy (xpath = "//input[@id = 'quantity_wanted']")
    private WebElement quantityButton;
    @FindBy (xpath = "//span[contains(text(), 'Cart')]")
    private WebElement cartButton;



    public void chooseProduct() {
        printedSweater.click();
    }

    public void chooseSize() {
        chooseSweaterSize.click();
//        chooseMSize.click();
    }
    public void customSize (char size) {
        String xpath = "//select//option[contains(@title, '" + size + "')]";
        WebElement sizeOption = driver.findElement(By.xpath(xpath));
        sizeOption.click();
    }

    public void chooseQuantity(Integer q) {
        quantityButton.click();
        quantityButton.clear();
        quantityButton.sendKeys("\b" + q);
    }
    public void addToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        addToCartButton.click();
    }

    public void goToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        cartButton.click();
    }

}
