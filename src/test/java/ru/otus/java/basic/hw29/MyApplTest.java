package ru.otus.java.basic.hw29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ru.otus.java.basic.hw29.MyAppl.getArrayAfterOne;
import static ru.otus.java.basic.hw29.MyAppl.isPresenceOneTwo;

/**
 * Реализовать метод, принимающий в качестве аргумента одномерный целочисленный массив,
 * и возвращающий новый массив, который содержит элементы исходного массива, идущие после последней единицы.
 * Если входной массив не содержит единиц, то должно быть брошено RuntimeException.
 * Примеры:
 * Входной массив: [ 1 2 1 2 2 ] => Результат: [ 2 2 ]
 * Входной массив: [ 2 2 2 2 ] => RuntimeException
 * ****************************************************
 * Реализовать метод, проверяющий входной массив, что он состоит только из чисел 1 и 2.
 * Если в массиве присутствуют числа кроме 1 и 2, или нет хотя бы одной единицы или двойки,
 * то результат должен быть равен false
 * Примеры:
 * [ 1 2 ] => true
 * [ 1 1 ] => false
 * [ 1 3 ] => false
 * [ 1 2 2 1 ] => true
 * Реализовать набор тестов для методов.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyApplTest {
    @BeforeEach
    public void init() {
        MyAppl myAppl = new MyAppl();
    }

    public static Stream<Arguments> isPresenceOneTwoParamTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.of(new int[]{1, 1, 2, 1, 2, 4, 5}, false ));
        out.add(Arguments.of(new int[]{2, 2}, false ));
        out.add(Arguments.of(new int[]{2, 3}, false ));
        out.add(Arguments.of(new int[]{1, 2, 2, 1}, true ));
        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("isPresenceOneTwoParamTest")
    public void  isPresenceOneTwoTest(int[] arr, boolean result) {
        Assertions.assertEquals(result,isPresenceOneTwo(arr));
    }

    public static Stream<Arguments> getArrayAfterOneParamTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.of(new int[]{1, 2, 1, 2, 2}, new int[]{2,2}));
        out.add(Arguments.of(new int[]{1, 1, 2, 1, 2, 4, 5}, new int[]{2,4,5}));
        out.add(Arguments.of(new int[]{1, 2, 2, 1}, new int[]{} ));
        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("getArrayAfterOneParamTest")
    public void  getArrayAfterOneTest(int[] arr, int[] result) {
        Assertions.assertArrayEquals(result,getArrayAfterOne(arr));
    }

    @Test
    public void getArrayAfterOneByZeroTest() {
        Assertions.assertThrows(RuntimeException.class, () -> getArrayAfterOne(new int[]{2, 2}));
    }
}
