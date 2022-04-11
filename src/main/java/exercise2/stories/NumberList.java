package exercise2.stories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberList {

    public static Map<String, Predicate<Integer>> predicateMap = new HashMap<>();
    public static Map<String, BiPredicate<Integer, Integer>> biPredicateMap = new HashMap<>();

    public NumberList() {
        addCommand("even", num -> num % 2 == 0);
        addCommand("odd", num -> num % 2 != 0);
        addCommand("prime", NumberList::isPrime);
        addCommand("greater than", (num, x) -> num > x);
        addCommand("multiple of", (num, x) -> num % x == 0);
        addCommand("less than", (num, x) -> num < x);
    }

    public void addCommand(String command, Predicate<Integer> predicate) {
        predicateMap.put(command.trim(), predicate);
    }

    public void addCommand(String command, BiPredicate<Integer, Integer> biPredicate) {
        biPredicateMap.put(getCommand(command), biPredicate);
    }

    public static Predicate<Integer> getPredicate(String command) {
        String[] condition = command.trim().split(" ");
        if (condition.length == 3) {
            BiPredicate<Integer, Integer> biPredicate = biPredicateMap.get(getCommand(command));
            if (biPredicate == null) return null;
            return integer -> biPredicate.test(integer, getNumber(command));
        } else {
            return predicateMap.get(getCommand(command));
        }
    }

    public Predicate<Integer> resultantPredicate(List<String> commands, String type) {
        Predicate<Integer> predicate = null;
        for (String command : commands) {
            if(getPredicate(command) == null) continue;
            if (predicate == null) predicate = getPredicate(command);
            else if (type.equals("all")) predicate = predicate.and(Objects.requireNonNull(getPredicate(command)));
            else if (type.equals("any")) predicate = predicate.or(Objects.requireNonNull(getPredicate(command)));
        }
        return predicate;
    }

    public static boolean isPrime(int num) {
        return num > 1 && IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
    }

    public static List<Integer> commandsOutputList(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Integer getNumber(String command) {
        return Integer.parseInt(command.trim().split(" ")[2]);
    }

    private static String getCommand(String command) {
        String[] words = command.trim().split(" ");
        if (words.length == 1) return command;
        return words[0].trim() + " " + words[1].trim();
    }
}
