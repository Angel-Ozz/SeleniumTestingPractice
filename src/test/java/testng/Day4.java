package testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day4 {

    @AfterSuite
    public void webPage(){
        System.out.println("webPage");
    }

    @Test(dataProvider = "getData")
    public void mobilePage(String username, String password){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("mobilePage");
        System.out.println(username);
        System.out.println(password);
        //softAssert.assertTrue(false);
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After");
    }

    @Test(groups = {"Smoke"})
    public void smokeThree(){
        System.out.println("smoke three");
    }

    @DataProvider //two ways of sending parameters to the test cases, through xml or through dataProvider
    public Object[][] getData(){

        //1st combination -username password --good credit history
        //2nd  username password no credit
        //3rd fraudulent credit

        Object[][] data = new Object[3][2];
        data[0][0] = "firstUsername";
        data[0][1] = "password";

        data[1][0] = "secondUsername";
        data[1][1] = "secondPassword";

        data[2][0] = "thirdUsername";
        data[2][1] = "thirdPassword";

        return data;

    }
}

