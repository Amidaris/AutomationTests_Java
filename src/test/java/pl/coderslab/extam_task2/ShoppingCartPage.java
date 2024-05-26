package pl.coderslab.extam_task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private static WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//a[contains(@class, 'btn-primary') and contains (@href, 'controller=order')]")
    private WebElement checkoutButton;

    public void checkout() {
        checkoutButton.click();
    }

}
