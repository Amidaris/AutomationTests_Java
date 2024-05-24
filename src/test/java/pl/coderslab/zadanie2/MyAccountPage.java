package pl.coderslab.zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class MyAccountPage {
    private static WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href$='index.php']")
    private WebElement myStoreButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMainPage() {
        myStoreButton.click();
    }
}
