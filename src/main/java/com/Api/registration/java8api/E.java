package com.Api.registration.java8api;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(3,5,7,2,8,10);
        //Optional<Integer> min = number.stream().min(Integer::compareTo);
        //Optional<Integer> max = number.stream().max(Integer::compareTo);
        //List<Integer> ma = number.stream().collect(Collectors.groupingBy(Function.identity().Collectors.counting()));
        Optional<Integer> ma = number.stream().filter(n-> n>5).findFirst();
        System.out.println(ma);
    }
}
