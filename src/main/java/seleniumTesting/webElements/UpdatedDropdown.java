package seleniumTesting.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(webDriver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected(), "checkbox is clicked before click");
        webDriver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
        softAssert.assertTrue(webDriver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected(), "checkbox isnt clicked after click");

        List<WebElement> checkboxes = webDriver.findElements(By.cssSelector("input[type='checkbox']"));
        softAssert.assertEquals(checkboxes.size(), 6, "checkboxes should be 6");

        webDriver.findElement(By.id("divpaxinfo")).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        int i = 1;
        while (i < 5) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt"))).click(); //explicit wait
            i++;
        }
        webDriver.findElement(By.id("btnclosepaxoption")).click();

        softAssert.assertEquals(webDriver.findElement(By.id("divpaxinfo")).getText(), "5 Adult", "5 adult should appear");

        softAssert.assertEquals(webDriver.findElement(By.id("Div1")).getCssValue("opacity"), "0.5");
        webDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(webDriver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); this sometimes doesnt work
        softAssert.assertEquals(webDriver.findElement(By.id("Div1")).getCssValue("opacity"), "1");

        softAssert.assertAll();

    }
}
