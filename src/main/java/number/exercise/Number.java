package number.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Number {

    public static List<String> range(int start,int end)
    {
        List<String> output = new ArrayList<>();
        IntStream stream = IntStream.range(start,end+1);
        stream.forEach(i -> output.add(validate(i)));
        return output;
    }

    public static String validate(int num)
    {
        if(isPrime(num))
            return String.valueOf(num);
        else if(num%2==0)
            return "Even";
        else
            return "Odd";
    }

    public static boolean isPrime(int num){
        if(num <= 1) return false;
        for (int i = 2; i <= num/2; i++)
            if(num % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp1,inp2;
        inp1 = sc.nextInt();
        inp2 = sc.nextInt();
        System.out.println(range(inp1,inp2));
    }
}
