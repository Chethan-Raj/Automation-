import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsTest1 {
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Chethan");
        names.add("ARaj");
        names.add("test");
        names.add("Selenium");
        names.add("ACore Java");
        names.add("My SQL");
        int count = 0;

        for (int i = 0; i < names.size() ; i++) {
            String actual = names.get(i);
            if (actual.startsWith("A"))
            {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void special(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Chethan");
        names.add("ARaj");
        names.add("test");
        names.add("Selenium");
        names.add("ACore Java");
        names.add("My SQL");
/* Streams have intermediate and terminal operations, Filter is an intermediate operation
for first stream "names", "filter" operation is applied,is called intermediate operation, the result from the intermediate operation is called second srtream
for second stream we apply the terminal operation
if intermidiate operation fails, terminal operation will not work
with streams the data source does not do gets modify, it creats a new stream of data and perform the operations*/

        long total = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(total);


/*"s ->" is called lamda funtion which is always paired with the condition can have more than one condition
can have more than one statement in the lamda condition
stram with more than one condition*/


        long d = Stream.of("Chethan","Raj","Async","Acar","Automation","Selenium").filter(s ->
        {
            return s.startsWith("S");

        }
        ).count();
        System.out.println(d);
        names.stream().filter(s -> s.length() >= 6).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() <= 4).limit(1).forEach(s ->System.out.println(s));
    }

    @Test
    public void manuplation(){
        Stream.of("Chethan","TestNg","Async","Gitbash","Automation","Git")
                .filter(s -> s.length()>= 5).filter(s -> s.endsWith("n"))
                .map(String::toUpperCase).forEach(System.out::println);
        //print with sorted operation
        String[] sorted = {"Chetnat","test","Git","random","names"};
        List<String> testnames = Arrays.asList(sorted);
        testnames.stream().filter(s -> s.endsWith("t")).sorted().map(String::toUpperCase).forEach(System.out::println);
        Stream<String> test  = Stream.of("Test", "this", "concate","Strems");
        //"any match" gives out with the boolean values
        boolean concated = Stream.concat(Arrays.stream(sorted),test).anyMatch(s -> s.equalsIgnoreCase("git"));
        System.out.println(concated);
        //Assert.assertTrue(concated);
    }

    @Test
    public void streamcollect(){
       /* String[] sorted = {"Chetnat","test","Git","random","names"};
        List<String> testnames = Arrays.asList(sorted);
        testnames.stream().filter(s -> s.endsWith("t")).sorted().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(testnames.get(0));*/


        //Print unique numbers
        // sort the array
        List<Integer> numbers  = Arrays.asList(3,2,4,2,6,2,8,8,4,8,9,68,79,567345,6856,456);
        numbers.stream().distinct().forEach(System.out::println);
        //sort and get third index
        List<Integer>values =  numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(values.get(3));
    }
}


