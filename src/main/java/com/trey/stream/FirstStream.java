package com.trey.stream;

import com.trey.stream.model.Dish;

import java.util.Arrays;
import java.util.List;

public class FirstStream {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new FirstStream().distinct();
        System.out.println("1.----------");
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);
        System.out.println("2.----------");
        menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).forEach(System.out::println);
        System.out.println("3.----------");
        List<String> words = Arrays.asList("Java 8", "lambdas", "In", "Action");
        words.stream().map(String::length).forEach(System.out::println);
        System.out.println("4.----------");
        menu.stream().map(d -> d.getName().length()).forEach(System.out::println);
        System.out.println("5.----------");
        menu.stream().map(Dish::getName).map(String::length).forEach(System.out::println);
        System.out.println("6.----------");
        List<String> strList = Arrays.asList("Hello", "World");
        strList.stream().map(x -> x.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
//        for (String[] s : collect) {
//            System.out.println(Arrays.toString(s));
//        }
//        List<String[]> collect = strList.stream().map(word -> word.split("")).distinct().collect(toList());
        System.out.println("7.----------");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().map(x -> x * x).forEach(System.out::println);
        System.out.println("8.----------");
        List<Integer[]> integers = Arrays.asList(new Integer[] {1, 2, 3}, new Integer[] {3, 4});
        System.out.println("9.----------");
//        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
//        list.stream().map(String::toUpperCase).forEach(System.out::println);
//        list.stream().map(x -> x.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
//        List<String> names = menu.stream().filter(d -> {
//            System.out.println("filtering:" + d.getName());
//            return d.getCalories() > 300;
//        }).map(d -> {
//            System.out.println("mapping:" + d.getName());
//            return d.getName();
//        }).limit(3).collect(toList());
//        System.out.println(names);
    }
}