package pl.coderslab.zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;
    @FindBy(how = How.CSS, using = "a[href$='my-account']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(@class, 'hidden-sm-down')]")
    private WebElement cartButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn() {
        signInButton.click();
    }

    public void goToCart() {
        cartButton.click();
    }

}


