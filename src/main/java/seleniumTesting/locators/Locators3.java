package seleniumTesting.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main (String[] args){

        WebDriver webDriver = new ChromeDriver();

        //sibling to sibling and child to parent traverse

        // /html/body/header... absolute xpath
        // //header... relative xpath

        //sibling to sibling -> //header/div/button[1]/following-sibling::button[1]

        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(webDriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

        //child to parent
        System.out.println(webDriver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

        webDriver.close();


    }
}
