package com.Api.registration.java8api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    // Even number
    // Odd number
    public void first(){
        List<Integer> data = Arrays.asList(10,20,13,14,9,21);
        List<Integer> newData1 = data.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        List<Integer> newData2 = data.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println("Even Number:"+ newData1);
        System.out.println("Odd Number:"+ newData2);
    }
    public void second(){
        List<String> data = Arrays.asList("apple", "banana","papaya");
        List<String> newData = data.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(newData);

    }
    //convert to Uppercase
    public void third(){
        List<Integer> data = Arrays.asList(10,20,43,5,12,18);
       int add =  data.stream().mapToInt(Integer::intValue).sum();
        System.out.println(add);
    }
    // count string with length greater then 3
    public void forth(){
        List<String> data = Arrays.asList("aaaa", "a","abc","aman","rahul","rohan");
       // List<String> newData = data.stream().filter(x->x.length()>3).collect(Collectors.toList());
        //System.out.println(newData);
        long count = data.stream().filter(x->x.length()>3).count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        B b1 = new B();
        //b1.first();
        //b1.second();
        //b1.third();
        b1.forth();
}
}
