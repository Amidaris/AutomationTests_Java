package pl.coderslab.extam_task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProceedToCheckoutPage {

    private static WebDriver driver;
    public ProceedToCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[contains(text(), 'Continue shopping')]")
    private WebElement proceedToCheckButton;

    public void proceedToCheckout() {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        proceedToCheckButton.click();
    }
}
