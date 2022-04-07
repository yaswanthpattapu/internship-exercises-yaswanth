package exercise.evenoroddorprime;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberRange {

    public static Stream<String> range(int start, int end) {
        IntStream stream = IntStream.range(start, end + 1);
        return stream.mapToObj(NumberRange::isEvenOddPrime);
    }

    public static String isEvenOddPrime(int num) {
        if (isPrime(num)) return String.valueOf(num);
        else if (num % 2 == 0) return "Even";
        else return "Odd";
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp1, inp2;
        inp1 = sc.nextInt();
        inp2 = sc.nextInt();

        Stream<String> stream = range(inp1, inp2);
        stream.forEach(System.out::println);
    }
}
