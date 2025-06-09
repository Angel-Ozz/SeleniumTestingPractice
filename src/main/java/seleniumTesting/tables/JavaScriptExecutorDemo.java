package seleniumTesting.tables;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        js.executeScript("window.scrollBy(0,500)");

        //js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
    }
}
