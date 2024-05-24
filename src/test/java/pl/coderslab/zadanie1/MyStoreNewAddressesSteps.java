package pl.coderslab.zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MyStoreNewAddressesSteps {

    private WebDriver driver;

    @Given("I'm on a shop main page")
    public void imOnShopMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.cssSelector("a[href$='my-account']")).click();
    }

    @When("I want to log in")
    public void iWantToLogin() {

        driver.findElement(By.cssSelector("a[href$='my-account']")).click();
    }

    @And("I log in")
    public void iLoginAs() {
        driver.findElement(By.id("field-email")).sendKeys("adam.nowak22@wp.pl");
        driver.findElement(By.id("field-password")).sendKeys("123456");
        driver.findElement(By.id("submit-login")).click();
    }

    @Then("I check my addresses")
    public void iCheckMyAddresses() {
        driver.findElement(By.cssSelector("a[href$='controller=addresses']")).click();
    }

    @And("I create new addresses")
    public void iCreateNewAddresses() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@data-link-action='add-address']//span")).click();
    }

    @And("I enter alias {word} address {word} city {word} postcode {word} phone {word}")
    public void iEnterDataToNewAddresses(String alias, String address, String city, String postcode, String phone) {
        driver.findElement(By.id("field-alias")).click();
        driver.findElement(By.id("field-alias")).sendKeys(alias);
        driver.findElement(By.id("field-address1")).click();
        driver.findElement(By.id("field-address1")).sendKeys(address);
        driver.findElement(By.id("field-city")).click();
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.id("field-postcode")).click();
        driver.findElement(By.id("field-postcode")).sendKeys(postcode);
        driver.findElement(By.id("field-phone")).click();
        driver.findElement(By.id("field-phone")).sendKeys(phone);
    }

    @And("I submit new address")
    public void iCreateNewAccount() {
        driver.findElement(By.xpath("//button[contains(@class, 'form-control-submit')]")).click();
    }
    @And("I verify created alias {word} address {word} city {word} postcode {word} phone {word}")
    public void iVerifyCreatedAddress (String alias, String address, String city, String postcode, String phone) {
        WebElement element = driver.findElement(By.xpath("//div//h4[contains(text(), 'domowy')]/following-sibling::address"));
        System.out.println("Adres na stronie portalu:");
        System.out.println(element.getText());
        String addressAsText = element.getText();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Adres oczekiwany:");
        String expectedAddress = String.join("\n", "Adam Nowak", address, city, postcode, "United Kingdom", phone);
        System.out.println(expectedAddress);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }
    @And("I delete new address")
    public void iDeleteNewAddress() {
        String atrybut = driver.findElement(By.xpath("//h4[contains(text(), 'domowy')]/ancestor::article")).getAttribute("id");
        String xpath = "//article[contains(@id, '" + atrybut + "')]//a[contains(@data-link-action, " +
                "'delete-address')]";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    @Then("I check the new address was successfully deleted")
    public void iCheckTheNewAddressWasSuccessfullyDeleted() {
        WebElement alert = driver.findElement(By.xpath("//article//li[contains(text(), 'Address successfully deleted!')]"));
        Assertions.assertTrue(alert.isDisplayed(), "Address successfully deleted!");
        alert.getText();
        System.out.println("---------------------------------------------------------------");
        System.out.print(alert.getText());
    }
    @And("I close browser")
    public void iCloseBrowser() {
        driver.quit();
    }
}
