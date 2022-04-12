package exercise2.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CommandsListTest extends CommandList {

    static class PerfectSquareCommand implements Command {

        @Override
        public boolean test(Integer integer) {
            return IntStream.rangeClosed(1, integer / 2 + 1).anyMatch(i -> i * i == integer);
        }
    }

    @Test
    public void itShouldRetrieveNumbersBasedOnCommands() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Command> commands = Arrays.asList(new EvenCommand(), new LessThan(15));
        List<Integer> list1 = filterAllMatches(list, commands);
        Assert.assertEquals(Arrays.asList(2, 4, 6, 8, 10, 12, 14), list1);

        commands = Arrays.asList(new PrimeCommand(), new OddCommand());
        list1 = filterAnyMatches(list, commands);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 7, 9, 11, 13, 15, 17, 19), list1);

        commands = Arrays.asList(new GreaterThan(5), new MultipleOf(3));
        list1 = filterAllMatches(list, commands);
        Assert.assertEquals(Arrays.asList(6, 9, 12, 15, 18), list1);

        commands = List.of(new PerfectSquareCommand());
        list1 = filterAllMatches(list, commands);
        Assert.assertEquals(Arrays.asList(1, 4, 9, 16), list1);
    }

}
