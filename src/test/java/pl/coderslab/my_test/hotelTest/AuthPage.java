package pl.coderslab.my_test.hotelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    private static WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement newUserEmailInput;

    @FindBy(name = "SubmitCreate")
    private WebElement createNewAccountBtn;

    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(name = "passwd")
    private WebElement loginPasswdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    public AuthPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewUserEmailAndSubmit(String email) {
        newUserEmailInput.clear();
        newUserEmailInput.sendKeys(email);
        createNewAccountBtn.click();
    }

    public void loginAs(String login, String passwd) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(login);
        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);
        loginBtn.click();
    }

}
