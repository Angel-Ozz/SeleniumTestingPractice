package seleniumTesting.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main (String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/"); //selenium waits until all components are loaded
        webDriver.navigate().to("https://google.com"); //wont wait
        webDriver.navigate().back();
        Thread.sleep(2000);
        webDriver.navigate().forward();
        webDriver.navigate().refresh();
    }
}
