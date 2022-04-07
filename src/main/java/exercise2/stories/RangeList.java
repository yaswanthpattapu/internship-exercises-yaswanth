package exercise2.stories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class RangeList {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) return false;
        return true;
    }

    public static Predicate<Integer> prime() {
        return RangeList::isPrime;
    }

    public static Predicate<Integer> odd() {
        return (num -> num % 2 != 0);
    }

    public static Predicate<Integer> even() {
        return (num -> num % 2 == 0);
    }

    public static Predicate<Integer> greaterThan(int x) {
        return num -> (num > x);
    }

    public static Predicate<Integer> lessThan(int x) {
        return num -> (num < x);
    }

    public static Predicate<Integer> multipleOf(int x) {
        return num -> (num % x == 0);
    }

    public static List<Integer> commandsOutputList(List<Integer> list, String[] commands, String type) {
        Predicate<Integer> predicate = commandsPredicate(commands, type);
        List<Integer> result = new ArrayList<>();
        for (Integer t : list) {
            if (predicate.test(t)) result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter all numbers in a single line separated by commas: ");
        List<Integer> list = new ArrayList<>();
        String[] numbers = sc.nextLine().split(",");
        for (String s : numbers) list.add(Integer.parseInt(s.trim()));
        System.out.println("list of commands : [\"even\", \"odd\", \"prime\", \"greater than <number>\", \"less than <number>\", \"multiple of <number>\"]");
        System.out.println("Enter commands from above list separated by commas : ");
        String[] commands = sc.nextLine().split(",");
        System.out.println("Specify if it satisfy \"all\" conditions or \"any\" conditions: ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.println(commandsOutputList(list, commands, type));
    }

    private static Predicate<Integer> commandsPredicate(String[] commands, String type) {
        Predicate<Integer> predicate;
        if (type.equals("all"))
            predicate = t -> true;
        else
            predicate = t -> false;
        for (String command : commands) {
            command = command.trim().toLowerCase();
            String[] condition = command.split(" ");
            int number = 0;
            if (condition.length != 1) {
                command = condition[0] + " " + condition[1];
                number = Integer.parseInt(condition[2]);
            }
            if (command.equals("even") && type.equals("all"))
                predicate = predicate.and(even());
            else if (command.equals("even"))
                predicate = predicate.or(even());

            if (command.equals("odd") && type.equals("all"))
                predicate = predicate.and(odd());
            else if (command.equals("odd"))
                predicate = predicate.or(odd());

            if (command.equals("prime") && type.equals("all"))
                predicate = predicate.and(prime());
            else if (command.equals("prime"))
                predicate = predicate.or(prime());

            if (command.equals("greater than") && type.equals("all"))
                predicate = predicate.and(greaterThan(number));
            else if (command.equals("greater than"))
                predicate = predicate.or(greaterThan(number));

            if (command.equals("less than") && type.equals("all"))
                predicate = predicate.and(lessThan(number));
            else if (command.equals("less than"))
                predicate = predicate.or(lessThan(number));

            if (command.equals("multiple of") && type.equals("all"))
                predicate = predicate.and(multipleOf(number));
            else if (command.equals("multiple of"))
                predicate = predicate.or(multipleOf(number));
        }
        return predicate;
    }
}
