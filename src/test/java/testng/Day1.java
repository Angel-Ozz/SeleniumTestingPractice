package testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {
    public static final Logger logger = LoggerFactory.getLogger(Day1.class);

    @Parameters({"name"})
    @Test(dependsOnMethods = {"smokeTwo"}, enabled = false)
    public void Demo(String name){
        System.out.println("Hello" + name );
        logger.info("Hello world from Demo()"); //just testing logger
    }

    @Test
    public void one(){
        System.out.println("1");
    }

    @Test(dependsOnMethods = {"one"})
    public void two(){
        System.out.println("2");
    }

    @Test(dependsOnMethods = {"two"}, timeOut = 4000)
    public void three(){
        System.out.println("three");
    }

    @Parameters({"name", "lastName"})
    @Test(groups = {"Smoke"}, dependsOnMethods = {"three", "two"})
    public void smokeTwo(String name, @Optional("optional") String lastName){
        System.out.println("smoke two with parameter " + name + " " + lastName); //to get the parameter you must run the tests from the xml where the parameter is

    }
}
