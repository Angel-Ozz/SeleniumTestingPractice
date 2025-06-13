package seleniumTesting.miscellaneous;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
//import org.apache.commons.io.FileUtils; deprecated


public class Miscellaneous {
    public static void main(String[] args) throws IOException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        //webDriver.manage().deleteCookieNamed("sowih"); if you delete session id cookie you should get logout


        webDriver.get("https://google.com");

        //take screenshot

        TakesScreenshot screenshot = (TakesScreenshot) webDriver;

        File src = screenshot.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("path")); deprecated must find another way to
        String desktopPath = System.getProperty("user.home") + "/Desktop/screenshot.png";
        Files.copy(src.toPath(), Path.of(desktopPath), StandardCopyOption.REPLACE_EXISTING);



    }
}
