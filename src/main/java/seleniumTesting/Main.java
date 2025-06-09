package seleniumTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        //Invoking Browser
        //Chrome - Chrome Driver -> methods
        //Create Obj of the class

        //chromedriver.exe -> Chrome browser
        //No longer used after Selenium 4.6//System.setProperty("webdriver.chrome.driver", "/Users/angelocariz/Desktop/chromedriver-mac-x64");
        //ChromeDriver driver = new ChromeDriver(); //Chrome methods + WebDriver Methods


        //WebDriver webDriver = new ChromeDriver(); //to only have access to WebDriver methods not ChromeDriver methods
        //WebDriver webDriver = new FirefoxDriver();
        WebDriver webDriver = new EdgeDriver();

        //General methods
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        String title = webDriver.getTitle();
        String url = webDriver.getCurrentUrl();

        System.out.println(title + " from " + url);

        webDriver.close(); //only current window
        //webDriver.quit(); //close every associated window


    }
}