package seleniumTesting.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class AutoSuggestive {
    public static void main (String[] args) throws InterruptedException {

        WebDriver webDriver =  new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        webDriver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> options = webDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //general css to find all a elements of the li with class ui-menu-item

        for(WebElement option: options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
    }
}
