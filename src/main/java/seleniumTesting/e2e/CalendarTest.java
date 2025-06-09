package seleniumTesting.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class CalendarTest {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        SoftAssert softAssert = new SoftAssert();

        String monthNumber = "06";
        String date = "15";
        String year = "2027";

        webDriver.findElement(By.className("react-date-picker__inputGroup__month")).sendKeys(monthNumber);
        webDriver.findElement(By.className("react-date-picker__inputGroup__day")).sendKeys(date);
        webDriver.findElement(By.className("react-date-picker__inputGroup__year")).sendKeys(year);

        softAssert.assertEquals(webDriver.findElement(By.name("date")).getAttribute("value"), String.format("%s-%s-%s", year,monthNumber,date) );

        webDriver.close();

        softAssert.assertAll();
    }

}
