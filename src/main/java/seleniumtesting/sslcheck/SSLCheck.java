package seleniumTesting.sslCheck;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) {

//        FOR MORE OPTIONS LOOK UP CHROMEOPTIONS CLASS DOC
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); //for pages without https or security cert

//        Map<String, Object> prefs = new HashMap<String, Object>(); //for setting download directory
//        prefs.put("download.default_directory", "/directory/path");
//        options.setExperimentalOption("prefs", prefs);


//        options.addExtensions("");
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("ipaddress:4444");
//        options.setCapability("proxy", proxy);


        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://expired.badssl.com/");

    }
}
