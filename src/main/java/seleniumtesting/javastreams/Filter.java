package seleniumTesting.javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Filter {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        SoftAssert softAssert = new SoftAssert();

        String product = "to";

        webDriver.findElement(By.id("search-field")).sendKeys(product);

        List<WebElement> products = webDriver.findElements(By.xpath("//tr/td[1]"));

        List<String> productText = products.stream().map(WebElement::getText).toList();

        softAssert.assertTrue(productText.stream().allMatch(producto -> producto.contains(product)));

        softAssert.assertAll();



    }
}
