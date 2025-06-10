package seleniumTesting.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert softAssert = new SoftAssert();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("window.scrollBy(0,500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> values = webDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (WebElement value : values) {
            sum = Integer.parseInt(value.getText()) + sum;

        }
        System.out.println(sum);

        String totalAmountString = (webDriver.findElement(By.className("totalAmount")).getText().split(": "))[1];
        int totalAmount = Integer.parseInt(totalAmountString);

        softAssert.assertEquals(sum, totalAmount);
        softAssert.assertAll();




    }
}
