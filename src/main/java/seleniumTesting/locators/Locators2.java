package seleniumTesting.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;


import java.time.Duration;

public class Locators2 {
    public static void main (String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String userName = "Ocariz";
        webDriver.findElement(By.id("inputUsername")).sendKeys(userName);
        webDriver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.className("submit")).click();

        Thread.sleep(2000);
        String successfulLogin = webDriver.findElement(By.tagName("p")).getText();

        System.out.println(successfulLogin);

        String greetings = webDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        webDriver.findElement(By.xpath("//*[text()='Log Out']")).click();
        webDriver.close();
        System.out.println("You are successfully logged out.");

        assertEquals(successfulLogin, "You are successfully logged in.");
        assertEquals(greetings, String.format("Hello %s,", userName));

    }
}
