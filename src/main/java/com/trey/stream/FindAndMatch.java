package com.trey.stream;

import com.trey.stream.model.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找和匹配
 */
public class FindAndMatch {

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    /**
     * 检查谓词是否至少匹配一个元素
     */
    @Test
    public void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!!");
        }
    }

    /**
     * 检查谓词是否匹配所有元素
     * 是：返回true；否：返回false
     */
    @Test
    public void allMatch() {
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);
    }

    /**
     * 流中没有任何元素与给定的谓词匹配
     */
    @Test
    public void noneMatch() {
        boolean isHealthy = menu.stream().noneMatch(d -> d.getCalories() < 500);
        System.out.println(isHealthy);
    }

    /**
     * 返回当前流中的任意元素
     */
    @Test
    public void findAny() {
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    /**
     * 查找第一个元素
     */
    @Test
    public void findFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x)
                .filter(x -> x % 3 == 0).findFirst();
        System.out.println(firstSquareDivisibleByThree.get());
    }
}