package exercise2.stories;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static exercise2.stories.NumberList.commandsOutputList;

public class NumberListTest {

    NumberList obj = new NumberList();

    public static boolean isPerfectSquare(int num) {
        return IntStream.rangeClosed(1, num / 2 + 1).anyMatch(i -> i * i == num);
    }

    @Test
    public void itShouldExtractEvenNumbers() {
        List<Integer> list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 1538);
        Predicate<Integer> predicate = obj.resultantPredicate(List.of("even"), "all");
        List<Integer> list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(104, 58, 1026, 1538), list1);
    }

    @Test
    public void itShouldExtractOddNumbers() {
        List<Integer> list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 1538);
        Predicate<Integer> predicate = obj.resultantPredicate(List.of("odd"), "all");
        List<Integer> list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(91, 99, 625, 995), list1);
    }

    @Test
    public void itShouldExtractPrimeNumbers() {
        List<Integer> list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 2591, 1538);
        Predicate<Integer> predicate = obj.resultantPredicate(List.of("prime"), "all");
        List<Integer> list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(List.of(2591), list1);
    }

    @Test
    public void itShouldFilterForMultipleCommands() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> predicate = obj.resultantPredicate(Arrays.asList("prime", "odd"), "all");
        List<Integer> list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(3, 5, 7), list1);

        predicate = obj.resultantPredicate(Arrays.asList("prime", "odd"), "any");
        list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 7, 9), list1);

        list = Arrays.asList(91, 104, 58, 99, 625, 1026, 448, 995, 2591, 1538);
        predicate = obj.resultantPredicate(Arrays.asList("prime", "even"), "any");
        list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(104, 58, 1026, 448, 2591, 1538), list1);

        predicate = obj.resultantPredicate(Arrays.asList("multiple of 4", "greater than 100", "less than 1000"), "all");
        list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(104, 448), list1);

        predicate = obj.resultantPredicate(Arrays.asList("multiple of 4", "greater than 100", "less than 1000"), "any");
        list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(91, 104, 58, 99, 625, 1026, 448, 995, 2591, 1538), list1);

        obj.addCommand("perfect square", NumberListTest::isPerfectSquare);
        list = Arrays.asList(1, 2, 3, 4, 9, 15, 21, 36);
        predicate = obj.resultantPredicate(Arrays.asList("greater than 2", "perfect square"), "all");
        list1 = commandsOutputList(list, predicate);
        Assert.assertEquals(Arrays.asList(4, 9, 36), list1);
    }

}