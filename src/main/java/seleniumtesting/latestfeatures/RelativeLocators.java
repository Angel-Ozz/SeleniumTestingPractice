package seleniumTesting.latestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = webDriver.findElement(By.name("name"));

        System.out.println(webDriver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dob = webDriver.findElement(By.cssSelector("[for='dateofBirth']"));
        webDriver.findElement(with(By.tagName("input")).below(dob)).click();
        WebElement iceCreamLabel = webDriver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        webDriver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement checkboxStudent = webDriver.findElement(By.id("inlineRadio1"));
        System.out.println(webDriver.findElement(with(By.tagName("label")).toRightOf(checkboxStudent)).getText());

    }
}
