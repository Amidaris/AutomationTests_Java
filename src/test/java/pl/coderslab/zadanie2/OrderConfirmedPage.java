package pl.coderslab.zadanie2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderConfirmedPage {

    private static WebDriver driver;

    public OrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenshot() {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            File dest = new File("C:\\Users\\adamg\\Documents\\My_GIT_Project\\AutomationTests_Java\\src" +
                    "\\Screenshot\\Screenshot_" + timestamp + ".png");
            FileUtils.copyFile(screenshotFile, dest);
            System.out.println("Zrzut ekranu został zapisany jako Screenshot_" + timestamp + ".png");
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas zapisywania zrzutu ekranu.");
        }
    }
}


//            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\adamg\\Documents\\Screenshot\\Screenshot.png"));
//            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\adamg\\Documents\\CL Automation Tester\\ZadanieZaliczenioweNr2\\untitled\\src\\Screenshot\\Screenshot.png"));
//            System.out.println("Zrzut ekranu został zapisany jako screenshot.png");
//        } catch (Exception e) {
//            System.out.println("Wystąpił błąd podczas zapisywania zrzutu ekranu.");
//        }


