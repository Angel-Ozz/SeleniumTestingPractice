package seleniumTesting.javaStreams;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

    SoftAssert softAssert = new SoftAssert();
    @Test
    public void streamFilter(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Juan");
        names.add("pedro");
        names.add("luis");
        names.add("Angel");
        names.add("Alex");

        //there is no life for intermediate op if the is no terminal op
        //terminal op will execute only if inter op (filter) returns true
        //we can create stream
        Long count = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);

        //ex of forcing false
//        Long d = names.stream().filter(name -> {
//            name.startsWith("A");
//                    return false;
//        }).count();
//
//        System.out.println(d);

        //print all the names of the ArrayList
        names.stream().filter(name -> name.length()>4).limit(2).forEach(System.out::println);

    }

    @Test
    public void streamMap(){

        List<String> names = new ArrayList<>();
        names.add("Juan");
        names.add("pedro");
        names.add("luis");
        names.add("Angel");
        names.add("Alex");

        names.stream().filter(name -> name.contains("A")).sorted().map(String::toUpperCase).forEach(System.out::println);

        List<String> names2 = Arrays.asList("Maria", "Fernanda", "Jimena", "Silvie");

        Stream<String> mergedStream = Stream.concat(names.stream(), names2.stream());
        boolean flag = mergedStream.anyMatch(name -> name.equalsIgnoreCase("Silvie"));
        softAssert.assertTrue(flag);
        softAssert.assertAll();

    }

    @Test
    public void streamCollect(){
        List<String> names2 = Arrays.asList("Maria", "Fernanda", "Jimena", "Silvie");
        List<String> namesUpdated = names2.stream().filter(name -> name.contains("a")).sorted().map(String::toUpperCase).toList();
        namesUpdated.forEach(System.out::println);

        //print unique numbers
        List<Integer> values = Arrays.asList(1,4,5,9,8,9,0,4,3,5,3,2,2,2,2);
        values.stream().distinct().sorted().forEach(System.out::println);
    }

}
