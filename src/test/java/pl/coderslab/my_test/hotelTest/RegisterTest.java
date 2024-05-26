package pl.coderslab.my_test.hotelTest;

import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterTest {

    private WebDriver driver;

    private final Faker faker = new Faker();

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void shouldRegisterNewUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
        AuthPage authPage = new AuthPage(driver);
        String generatedEmail = generateUniqueEmail();
        System.out.println("Generated email: " + generatedEmail);
        authPage.enterNewUserEmailAndSubmit(generatedEmail);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private String generateUniqueEmail() {
        return "adam" + System.currentTimeMillis() + "@test.com";
    }
}
