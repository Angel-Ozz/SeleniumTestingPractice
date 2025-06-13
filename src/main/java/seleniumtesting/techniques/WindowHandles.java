package seleniumTesting.techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        webDriver.findElement(By.className("blinkingText")).click();

        Set<String> windows = webDriver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        webDriver.switchTo().window(childId);

        String redText = webDriver.findElement(By.cssSelector(".im-para.red")).getText();
        String email = redText.split("at ")[1].split(" ")[0];

        webDriver.switchTo().window(parentId);

        webDriver.findElement(By.id("username")).sendKeys(email);
    }
}
