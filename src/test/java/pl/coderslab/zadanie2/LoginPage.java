package pl.coderslab.zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement loginEmailInputButton;
    @FindBy(id = "field-password")
    private WebElement loginPasswordInputButton;
    @FindBy(id = "submit-login")
    private WebElement loginSubmitButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String login, String password) {
        loginEmailInputButton.clear();
        loginEmailInputButton.sendKeys(login);

        loginPasswordInputButton.clear();
        loginPasswordInputButton.sendKeys(password);

        loginSubmitButton.click();
    }
}
