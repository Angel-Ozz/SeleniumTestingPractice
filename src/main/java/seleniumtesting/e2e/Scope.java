package seleniumTesting.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.qaclickacademy.com/practice.php");
        Actions action = new Actions(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        //counts of links in the page
        int numberOfLinks = webDriver.findElements(By.tagName("a")).size();
        System.out.println(numberOfLinks);

        //count of links in the footer section
        int footerLinks = webDriver.findElements(By.xpath("//div[@id = 'gf-BIG']//a")).size();
        System.out.println(footerLinks);
        //upper can also be solved as
        WebElement footer = webDriver.findElement(By.id("gf-BIG"));
        int footerLinks2 = footer.findElements(By.tagName("a")).size();
        System.out.println(footerLinks2);

        //get all links of first column of the footer

        WebElement column1 = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> links = column1.findElements(By.tagName("a"));
        System.out.println(links.size());

        //click on each link in the column and check if the pages are opening
        for(int i = 1; i<links.size(); i ++){
            action.keyDown(Keys.COMMAND).click(links.get(i)).build().perform();
        }

        //get the title of each open tab
        Set<String> windows = webDriver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();

        while(iterator.hasNext()){
            webDriver.switchTo().window(iterator.next());
            wait.until(driver -> !driver.getTitle().isEmpty());
            System.out.println(webDriver.getTitle());
        }
    }
}
