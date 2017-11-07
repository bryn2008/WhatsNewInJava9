package uk.co.wnij9.section5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

public class StreamsDemo {

    public static void main(String[] args)  {

        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Frank", "Franky");
        nickNames.put("James", "JC");
        nickNames.put("Oscar", null);
        nickNames.put("Michael", "Mike");
        nickNames.put("Herb", "Herbie");
        nickNames.put("Elizabeth", "Liz");
        nickNames.put("Suzy", null);

        List<String> names = nickNames.entrySet()
                .stream()
                .map(e -> e.getKey())
                .collect(toList());
        System.out.println(names);

        List<String> nick1 = nickNames.entrySet()
                .stream()
                .flatMap(e -> {
                    if (e.getValue() != null) {
                        return Stream.of(e.getValue());
                    } else {
                        return Stream.empty();
                    }
                })
                .collect(toList());

        System.out.println(nick1);

        List<String> nick2 = nickNames.entrySet()
                .stream()
                .flatMap(e -> Stream.ofNullable(e.getValue()))
                .collect(toList());
        System.out.println(nick2);


    }


}