package exercise3.grep;

import java.nio.file.Path;

import static exercise3.grep.Grep.*;

public class Main {
    public static void main(String[] args) {
        Path file = Path.of("/home/yaswanth/Desktop/exercise/input.txt");
        String word = "world";
        System.out.println(searchString(word, file));

        Path folder = Path.of("/home/yaswanth/Desktop/exercise");
        searchRecursively(word, folder);

        Path destination = Path.of("/home/yaswanth/Desktop/output.txt");
        addResultToFile(matchedStrings(word, file), destination);
    }
}
