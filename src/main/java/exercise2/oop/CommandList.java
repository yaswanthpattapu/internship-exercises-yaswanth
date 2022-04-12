package exercise2.oop;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Command {
    boolean test(Integer integer);
}

class EvenCommand implements Command {

    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}

class OddCommand implements Command {

    @Override
    public boolean test(Integer integer) {
        return integer % 2 != 0;
    }
}

class PrimeCommand implements Command {

    @Override
    public boolean test(Integer integer) {
        return integer > 1 && IntStream.rangeClosed(2, integer / 2).noneMatch(i -> integer % i == 0);
    }
}

class LessThan implements Command {
    private final int x;

    public LessThan(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Integer integer) {
        return integer < x;
    }
}

class GreaterThan implements Command {
    private final int x;

    public GreaterThan(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Integer integer) {
        return integer > x;
    }
}

class MultipleOf implements Command {
    private final int x;

    public MultipleOf(int x) {
        this.x = x;
    }

    @Override
    public boolean test(Integer integer) {
        return integer % x == 0;
    }
}

public class CommandList {

    public List<Integer> filterAllMatches(List<Integer> numbers, List<Command> commands) {
        return numbers.stream().filter(number -> commands.stream().allMatch(p -> p.test(number))).collect(Collectors.toList());
    }

    public List<Integer> filterAnyMatches(List<Integer> numbers, List<Command> commands) {
        return numbers.stream().filter(number -> commands.stream().anyMatch(p -> p.test(number))).collect(Collectors.toList());
    }
}
