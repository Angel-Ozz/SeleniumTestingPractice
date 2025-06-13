package seleniumTesting.miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert softAssert = new SoftAssert();

        //broken URL
        //java methods to call urls and gets you the status code

        //Step 1 get all urls tied up to the links using selenium
        //if status code >400 then that url is not working
//        String url = webDriver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//
//        HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection(); //deprecated better use HTTPClient
//        conn.setRequestMethod("HEAD");
//        conn.connect();
//        int responseCode = conn.getResponseCode();
//        System.out.println(responseCode);

        List<WebElement> links = webDriver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link : links){
            String url1 = link.getAttribute("href");
            HttpURLConnection conn1 = (HttpURLConnection)new URL(url1).openConnection(); //deprecated better use HTTPClient
            conn1.setRequestMethod("HEAD");
            conn1.connect();
            int responseCode1 = conn1.getResponseCode();

            softAssert.assertTrue(responseCode1<400, "Faulty link " + link.getText() + " with code " + responseCode1);
        }

        softAssert.assertAll();

    }
}
