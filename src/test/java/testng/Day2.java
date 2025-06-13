package testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

    @BeforeSuite
    public void Demo2() {
        System.out.println("Hello world 2");
    }

    @BeforeTest
    public void hello(){
        System.out.println("Before");
    }

    @Test(groups = {"Smoke"})
    public void smokeOne(){
        System.out.println("smoke one");
    }

}
