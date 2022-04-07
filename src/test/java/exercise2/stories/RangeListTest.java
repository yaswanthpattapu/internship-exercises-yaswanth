package exercise2.stories;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static exercise2.stories.RangeList.commandsOutputList;

public class RangeListTest {

    @Test
    public void itShouldExtractEvenNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = commandsOutputList(list, new String[]{"even"}, "all");
        Assert.assertEquals(Arrays.asList(2, 4, 6, 8, 10), list1);

        list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 1538);
        list1 = commandsOutputList(list, new String[]{"even"}, "all");
        Assert.assertEquals(Arrays.asList(104, 58, 1026, 1538), list1);
    }

    @Test
    public void itShouldExtractOddNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = commandsOutputList(list, new String[]{"odd"}, "all");
        Assert.assertEquals(Arrays.asList(1, 3, 5, 7, 9), list1);

        list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 1538);
        list1 = commandsOutputList(list, new String[]{"odd"}, "all");
        Assert.assertEquals(Arrays.asList(91, 99, 625, 995), list1);
    }

    @Test
    public void itShouldExtractPrimeNumbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = commandsOutputList(list, new String[]{"prime"}, "all");
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7), list1);

        list = Arrays.asList(91, 104, 58, 99, 625, 1026, 995, 2591, 1538);
        list1 = commandsOutputList(list, new String[]{"prime"}, "all");
        Assert.assertEquals(List.of(2591), list1);
    }

    @Test
    public void itShouldFilterForMultipleCommands() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = commandsOutputList(list, new String[]{"prime","odd"}, "all");
        Assert.assertEquals(Arrays.asList(3, 5, 7), list1);

        list1 = commandsOutputList(list, new String[]{"prime","odd"}, "any");
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 7, 9), list1);

        list = Arrays.asList(91, 104, 58, 99, 625, 1026, 448, 995, 2591, 1538);
        list1 = commandsOutputList(list, new String[]{"prime", "even"}, "any");
        Assert.assertEquals(Arrays.asList(104, 58, 1026, 448, 2591, 1538), list1);

        list1 = commandsOutputList(list, new String[]{"even", "multiple of 4"}, "all");
        Assert.assertEquals(Arrays.asList(104, 448), list1);

        list1 = commandsOutputList(list, new String[]{"multiple of 4","greater than 100", "less than 1000" }, "all");
        Assert.assertEquals(Arrays.asList(104, 448), list1);

        list1 = commandsOutputList(list, new String[]{"multiple of 4","greater than 100", "less than 1000" }, "any");
        Assert.assertEquals(Arrays.asList(91, 104, 58, 99, 625, 1026, 448, 995, 2591, 1538), list1);
    }

}

