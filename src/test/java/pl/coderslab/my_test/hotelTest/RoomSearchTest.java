package pl.coderslab.my_test.hotelTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class RoomSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/login?back=my-account");
    }

    @Test
    public void shouldLoginAndSearchAvailableRooms() {
        AuthPage authPage = new AuthPage(driver);
        authPage.loginAs("adam1716719052703@test.com", "secretPass");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToHomePage();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
