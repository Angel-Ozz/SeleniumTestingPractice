package testNG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Day1 {
    public static final Logger logger = LoggerFactory.getLogger(Day1.class);

    @Test
    public void Demo(){
        System.out.println("Hello world");
        logger.info("Hello world from Demo()"); //just testing logger
    }

    @Test
    public void one(){
        System.out.println("1");
    }

    @Test
    public void two(){
        System.out.println("2");
    }

    @Test
    public void three(){
        System.out.println("three");
    }
}
