package pl.coderslab.my_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    public void testLoginWithEmailAndPasswoword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("adam.nowak22@wp.pl", "123456");
        Assertions.assertEquals("Adam Nowak", loginPage.getLoggedUsername());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
