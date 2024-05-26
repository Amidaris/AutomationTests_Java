package pl.coderslab.my_test.hotelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private static WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(name = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(css = "[type='password']")
    private WebElement passwdordInput;

    @FindBy(id = "submitAccount")
    private WebElement submitBtn;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterRequiredUserData(String firstname, String lastname, String password) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        passwdordInput.sendKeys(password);
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }

    public void register() {

        submitBtn.click();
    }
}
