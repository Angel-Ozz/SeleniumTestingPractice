package seleniumTesting.webElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Assignment {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String text = "Ocariz";
        SoftAssert softAssert = new SoftAssert();

        webDriver.findElement(By.id("name")).sendKeys(text);
        webDriver.findElement(By.cssSelector("#alertbtn")).click();

        Alert alert = webDriver.switchTo().alert();
        softAssert.assertEquals(alert.getText(), String.format("Hello %s, share this practice page and share your knowledge", text));
        alert.accept();

        webDriver.findElement(By.id("name")).sendKeys(text);
        webDriver.findElement(By.id("confirmbtn")).click();
        Alert alertConfirm = webDriver.switchTo().alert();
        softAssert.assertEquals(alertConfirm.getText(), String.format("Hello %s, Are you sure you want to confirm?", text));
        alertConfirm.dismiss();

        softAssert.assertAll();
    }
}
