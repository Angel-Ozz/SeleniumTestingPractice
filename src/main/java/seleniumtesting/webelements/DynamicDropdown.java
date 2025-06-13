package seleniumTesting.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {


        //Dynamic dropdown with indexes
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        webDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        webDriver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //webDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        webDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click(); //without indexes, parent to child

        webDriver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
    }
}
