package com.learn.java.basic.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class BasicFuctions {
    public static void main(String []args){
        Predicate<String> matchStr = x -> x.equalsIgnoreCase("two");
        Predicate<String> excludeStr = x -> (!x.equalsIgnoreCase("four"));

        Stream<String> dummyStream = Stream.empty();

        if(dummyStream.count() == 0){
            dummyStream = Stream.of("One", "Two", "Third", "four", "five");
        }

        dummyStream.forEach((t) -> System.out.println(String.format("append the String with %s", t)));

//        dummyStream.forEach((t) -> System.out.println(t));
    }

}
