package seleniumTesting.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args){

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        webDriver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if (webDriver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return webDriver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else{
                    return null;
                }
            }
        });

        String text = element.getText();
        System.out.println(text);
    }
}
