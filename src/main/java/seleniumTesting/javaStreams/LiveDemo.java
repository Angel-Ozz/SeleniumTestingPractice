package seleniumTesting.javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class LiveDemo {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        SoftAssert softAssert = new SoftAssert();

        //get column, click
        //items supposed to be sorted
        //get elements and text of elements
        //compare with .sorted

        webDriver.findElement(By.xpath("(//th[@role='columnheader'])[1]")).click();
        List<WebElement> products = webDriver.findElements(By.xpath("//tr/td[1]"));

        List<String> productText = products.stream().map(WebElement::getText).toList();


        //scan the name column until you get Beans and get the price of the Beans

        List<String> price = products.stream().filter(product -> product.getText().contains("Guava"))
                .map(LiveDemo::getPriceProduct).toList();

        softAssert.assertAll();

        WebElement nextButton = webDriver.findElement(By.xpath("//a[@aria-label = 'Next']"));
        while(price.isEmpty() && (Objects.equals(nextButton.getAttribute("aria-disabled"), "false"))){
            nextButton.click();
            products = webDriver.findElements(By.xpath("//tr/td[1]"));
            productText = products.stream().map(WebElement::getText).toList();
            price = products.stream().filter(product -> product.getText().contains("Guava"))
                    .map(LiveDemo::getPriceProduct).toList();

        }
        softAssert.assertTrue(productText.equals(productText.stream().sorted().toList()));

    }

    public static String getPriceProduct(WebElement product){
        return product.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
