package seleniumTesting.techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://jqueryui.com/droppable");
        Actions action = new Actions(webDriver);

        webDriver.switchTo().frame(webDriver.findElement(By.className("demo-frame")));
        WebElement draggable = webDriver.findElement(By.id("draggable"));
        WebElement droppable = webDriver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable, droppable).build().perform();
    }
}
