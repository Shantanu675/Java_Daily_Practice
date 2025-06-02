package com.Static;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Message {
    public static void main(String[] args) {
        //ForEach method on List
        List<Integer> list = Arrays.asList(1,2,3,3,5,4,6,4);
        list.forEach(n -> System.out.println(n));

//        Stream<Integer> s = list.stream();
//        Stream<Integer> s1 = s.filter(n -> n%2 == 0);
//        Stream<Integer> s2 = s1.map(n -> n *2);
//        int res = s2.reduce(0, (c,e)->c+e);

        int res = list.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n *2)
                .reduce(0, (c,e)->c+e);
    System.out.println(res);

        //s2.forEach(n -> System.out.println(n));
        //s.forEach(n -> System.out.println(n));  //stream can only use once
    }

    public static void message() {
        System.out.println("Radhe Radhe");
    }
}
