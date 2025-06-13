package seleniumTesting.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Locators {
    public static void main (String[] args) throws InterruptedException {

        //WebDriver webDriver = new ChromeDriver();
        //WebDriver webDriver = new FirefoxDriver();
        //WebDriver webDriver = new EdgeDriver();
        WebDriver webDriver = new SafariDriver();

        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait for objects to show on the page

        //Selenium scans from top left

        //Find Element by Id, Xpath, CSS Selector, name, className, Tag name, link text, partial link text
        //find if element unique in console for css selector ex: $('p.error')
        //find if element unique in console for xpath ex: $x('//input[@placeholder="Name"]')
        //browse through attributes from parent obj in xpath ex: //form/input[3]


        //first login try
        webDriver.findElement(By.id("inputUsername")).sendKeys("Ocariz");
        webDriver.findElement(By.name("inputPassword")).sendKeys("miau123");
        webDriver.findElement(By.className("submit")).click();
        String errorText = webDriver.findElement(By.cssSelector("p.error")).getText(); //p for the tag p and error is the class name

        System.out.println(errorText); //this takes time in browser, so it will throw an error without wait

        //error and click on forgot password
        webDriver.findElement(By.linkText("Forgot your password?")).click();

        //code will be repeated in the function due to practice with findElement syntax
        //register supposedly
        webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ocariz");
        webDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ocariz@miau.com");
        webDriver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //when multiple elements with same path you can treat them as list xpath
        webDriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear(); //multiple elements with same selector can vary from xpath
        webDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ocariz@miau.com");
        webDriver.findElement(By.xpath("//form/input[3]")).sendKeys("miau123");
        //webDriver.findElement(By.className("reset-pwd-btn")).click();
        Thread.sleep(1000); //in single page apps like render, selenium too fast, need time to rerender when change and catch the changed stable state
        webDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String adviseCheck = webDriver.findElement(By.cssSelector("form p")).getText();
        String password = getPassword(webDriver);

        System.out.println(adviseCheck);

        //go back and login with proper credentials
        webDriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        webDriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        webDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password); // star for starts with
        Thread.sleep(1000);
        webDriver.findElement(By.id("chkboxOne")).click();
        //webDriver.findElement(By.xpath("//button[@class='submit signInBtn']")).click(); //when using xpath all classes are written
        webDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        webDriver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String adviseCheck = driver.findElement(By.cssSelector("form p")).getText();
        String[] adviseArray = adviseCheck.split("'");
        return adviseArray[1].split("'")[0];


    }
}
