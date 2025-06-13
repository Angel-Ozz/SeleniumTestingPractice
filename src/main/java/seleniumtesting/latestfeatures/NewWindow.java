package seleniumTesting.latestFeatures;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/angularpractice/");

        webDriver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = webDriver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        webDriver.switchTo().window(childWindowId);
        webDriver.get("https://rahulshettyacademy.com/");
        String courseName = webDriver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        webDriver.switchTo().window(parentWindowId);

        WebElement name = webDriver.findElement(By.name("name"));
        name.sendKeys(courseName);
        File file = name.getScreenshotAs(OutputType.FILE);
        String desktopPath = System.getProperty("user.home") + "/Desktop/screenshot.png";
        Files.copy(file.toPath(), Path.of(desktopPath), StandardCopyOption.REPLACE_EXISTING);

        //get Height & width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


        webDriver.quit();




    }
}
