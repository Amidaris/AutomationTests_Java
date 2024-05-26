package pl.coderslab.my_test.hotelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MainPage {

    private static WebDriver driver;

    @FindBy (className = "user_login")
    private WebElement signInBtn;

    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn() {
        signInBtn.click();
    }

}
