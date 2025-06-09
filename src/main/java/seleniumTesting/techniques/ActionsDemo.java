package seleniumTesting.techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args){

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");
        Actions action = new Actions(webDriver);

        //moves to specific element
        WebElement elementToHover = webDriver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(elementToHover).build().perform();

        //
        action.moveToElement(webDriver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
    }
}
