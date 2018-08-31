package com.trey.stream;

import com.trey.stream.model.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapAndReduce {

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

    List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

    /**
     * 求和
     */
    @Test
    public void sum() {
        // 方法一：
//        int sum = numbers.stream().reduce(0, (x, y) -> x + y);
        // 方法二：
//        int sum = numbers.stream().reduce(0, Integer::sum);
        // 方法三：无初始值
        Optional<Integer> sumOptional = numbers.stream().reduce(Integer::sum);
        int sum = sumOptional.get();
        System.out.println("sum=" + sum);
    }

    /**
     * 求最大值
     */
    @Test
    public void max() {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max=" + max.get());
    }

    /**
     * 求最小值
     */
    @Test
    public void min() {
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min=" + min.get());
    }

    @Test
    public void count() {
        int count = menu.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("count:" + count);
    }
}
