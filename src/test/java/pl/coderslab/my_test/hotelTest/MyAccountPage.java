package pl.coderslab.my_test.hotelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private static  WebDriver driver;

    @FindBy(className = "alert-success")
    private WebElement successAlert;

    @FindBy(css = ".account_user_name")
    private WebElement userName;

    @FindBy(linkText = "Home")
    private WebElement goToHomePageBtn;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

    public String getSuccessAlert() {
        return successAlert.getText();
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToHomePage() {
        goToHomePageBtn.click();
    }
}
