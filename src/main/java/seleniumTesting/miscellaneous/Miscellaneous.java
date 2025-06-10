package seleniumTesting.miscellaneous;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
//import org.apache.commons.io.FileUtils; deprecated


public class Miscellaneous {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        //webDriver.manage().deleteCookieNamed("sowih"); if you delete session id cookie you should get logout


        webDriver.get("https://google.com");

        //take screenshot

        TakesScreenshot screenshot = (TakesScreenshot) webDriver;

        File src = screenshot.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("path")); deprecated must find another way to



    }
}
