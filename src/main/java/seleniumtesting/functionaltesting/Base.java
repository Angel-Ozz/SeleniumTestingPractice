package seleniumTesting.functionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main (String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        SoftAssert softAssert = new SoftAssert();

        webDriver.findElement(By.xpath("(//h4[text()='Cucumber - 1 Kg']/parent::div[@class='product'])/div/button")).click(); //trying xpath knowledge
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



/*
        String name;
        for (WebElement product : products) {

            name = product.getText();
            if (name.contains("Cucumber")) {
                webDriver.findElement(By.xpath("//button[text()='ADD TO CART']")).click(); //video solution
                break;
            }
        }
*/
        //general with arrays
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
        addItems(webDriver, itemsNeeded);
        webDriver.findElement(By.cssSelector("img[alt='Cart']")).click();
        webDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        webDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.className("promoBtn")).click();
        String codeSccss = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo"))).getText();
        softAssert.assertEquals(codeSccss, "Code applied ..!");

        softAssert.assertAll();





    }

    public static void addItems(WebDriver webDriver, String[] itemsNeeded){
        List<String> items = Arrays.asList(itemsNeeded);
        List<WebElement> products = webDriver.findElements(By.cssSelector("h4.product-name"));
        String name;
        int j = 0;
        for(int i = 0; i<products.size(); i++){
            name = products.get(i).getText().split(" ")[0];
            if(items.contains(name)){
                j++;
                webDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j == items.size()){
                    break;
                }
            }
        }

    }
}
