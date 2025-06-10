package seleniumTesting.javaStreams;


import org.testng.annotations.Test;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {

    }

    @Test
    public void streamFilter(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Juan");
        names.add("pedro");
        names.add("luis");
        names.add("Angel");
        names.add("Alex");

        Long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);
    }
}
