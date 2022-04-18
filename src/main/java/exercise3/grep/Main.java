package exercise3.grep;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static exercise3.grep.Grep.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path file = Paths.get("src", "test", "resources", "exercise", "input.txt");
        System.out.println("Enter string to search in input.txt : ");
        String word = scanner.nextLine();
        String fileName = file.getFileName().toString();
        if (searchString(word, file)) System.out.println("search string \"" + word + "\" found in " + fileName);
        else System.out.println("search string \"" + word + "\" not found in  " + fileName);
        System.out.println();

        Path folder = Paths.get("src", "test", "resources", "exercise");
        searchRecursively(word, folder).forEach(System.out::println);

        System.out.println("\nEnter the output file name:");
        String outputFile = scanner.nextLine();
        Path destination = Paths.get("src", "test", "resources", outputFile);
        addResultToFile(matchedLines(word, file), destination);
    }
}
