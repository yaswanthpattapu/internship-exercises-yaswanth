package exercise2.stories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import static exercise2.stories.NumberList.commandsOutputList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter all numbers in a single line separated by commas: ");
        List<Integer> list = new ArrayList<>();
        String[] numbers = sc.nextLine().split(",");
        for (String s : numbers) list.add(Integer.parseInt(s.trim()));

        System.out.println("list of commands : [\"even\", \"odd\", \"prime\", \"greater than <number>\", \"less than <number>\", \"multiple of <number>\"]");
        System.out.println("Enter commands from above list separated by commas : ");
        String[] conditions = sc.nextLine().split(",");
        List<String> commands = new ArrayList<>();
        Collections.addAll(commands, conditions);

        System.out.println("Specify if it satisfy \"all\" conditions or \"any\" conditions: ");
        String type = sc.nextLine().trim().toLowerCase();

        NumberList obj = new NumberList();
        Predicate<Integer> predicate = obj.resultantPredicate(commands, type);
        System.out.println(commandsOutputList(list, predicate));
    }
}
