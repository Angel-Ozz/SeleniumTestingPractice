package seleniumTesting.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class E2E {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        SoftAssert softAssert = new SoftAssert();
        int i = 1;

        //click on origin selector
        webDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //select origin and destination
        webDriver.findElement(By.xpath("//a[@value='BLR']")).click();
        //webDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))).click();

        //select current date
        webDriver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        //check the return date is disabled
        webDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        softAssert.assertEquals(webDriver.findElement(By.id("Div1")).getCssValue("opacity"), "0.5");

        //select number of passengers
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-datepicker")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo"))).click();
        while (i < 2) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt"))).click(); //explicit wait
            i++;
        }
        webDriver.findElement(By.id("btnclosepaxoption")).click();
        softAssert.assertEquals(webDriver.findElement(By.id("divpaxinfo")).getText(), "2 Adult", "2 adult should appear");

        //Select currency
        WebElement staticDropdown = webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("USD");

        webDriver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        softAssert.assertAll();


    }
}
