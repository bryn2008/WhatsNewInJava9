package uk.co.wnij9.section5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StramsAPIOverview {

    public static void main(String[] args) {
        StramsAPIOverview stramsAPI = new StramsAPIOverview();
        stramsAPI.streamOverNumsLessThanFive();
        stramsAPI.streamOverNumsMoreThanFive();
        stramsAPI.streamItterate();
        stramsAPI.streamFilter();
        stramsAPI.streamStaticOfNullable();
    }

    void streamOverNumsLessThanFive() {
        //default Stream<T> takeWhile(Predicate<? super T> predicate)
        // Take while n is less than 5
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeWhile(n -> n <= 5)
                .forEach(System.out::println);
    }

    void streamOverNumsMoreThanFive() {
        //default Stream<T> dropWhile(Predicate<? super T> predicate)
        // Take while n is less than 5
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(n -> n <= 5)
                .forEach(System.out::println);
    }

    void streamItterate() {
        // creates an infant stream and then limits the stream
        Stream.iterate(1, x -> x + 1)
                .limit(3)
                .forEach(System.out::println);
    }

    void streamFilter() {
        // itteration will never terminate
        //Stream.iterate(1, x -> x + 1)
        //        .filter(x -> x<=3)
        //        .forEach(System.out::println);

        Stream.iterate(1, x -> x <= 3, x -> x + 1)
                .forEach(System.out::println);
    }

    void streamStaticOfNullable() {
        // iterate over a list and remove any null entries
        List<String> list = new ArrayList<>();
        list.add("Frank");
        list.add("James");
        list.add(null);
        list.add("Oscar");
        list.add("Mike");
        list.add("Herbie");
        list.add("Liz");

        list.stream().flatMap(str -> Stream.ofNullable(str))
                .collect(toList())
                .forEach(System.out::println);
    }
}
