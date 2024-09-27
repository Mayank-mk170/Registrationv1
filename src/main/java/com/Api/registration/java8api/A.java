package com.Api.registration.java8api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {
//        List<Employee> data = Arrays.asList(
//                new Employee(1, "mike", 5000),
//                new Employee(2, "alok", 4000),
//                new Employee(3, "adam", 7000)
//        );
       // List<Employee> newData = data.stream().filter(e->e.getSal()>4000).collect(Collectors.toList());
       // List<Employee> newData = data.stream().filter(e->e.getName().startsWith("a")).collect(Collectors.toList());
//        Map<Integer, List<Employee>> newData = data.stream().collect(Collectors.groupingBy(e -> e.getSal()));
//        System.out.println(newData);
//        for (Employee emp:newData){
//            System.out.println(emp.getId());
//            System.out.println(emp.getName());
//            System.out.println(emp.getSal());
//        }

        List<Integer> data = Arrays.asList(10,20,11,13,15);
        int result = data.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }
}
