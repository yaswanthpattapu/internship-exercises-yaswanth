package exercise3.grep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Grep {
    public static boolean searchString(String word, Path file) {
        try (Stream<String> linesStream = Files.lines(file)) {
            return (linesStream.anyMatch(w -> w.toLowerCase().contains(word.toLowerCase())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> matchedStrings(String word, Path file) {
        List<String> match = new ArrayList<>();
        try (Stream<String> linesStream = Files.lines(file)) {
            linesStream.forEach(line -> {
                if (line.toLowerCase().contains(word.toLowerCase())) match.add(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return match;
    }

    public static void addResultToFile(List<String> result, Path file) {
        try {
            File temp = new File(file.toString());
            if (!temp.exists()) temp.createNewFile();
            try (var fw = new FileWriter(file.toString(), StandardCharsets.UTF_8, false)) {
                for (String s : result) {
                    String str = s + "\n";
                    fw.append(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchRecursively(String word, Path folder) {
        try (Stream<Path> paths = Files.walk(folder)) {
            paths.forEach(w ->
            {
                if (Files.isRegularFile(w)) {
                    System.out.print(w + " : ");
                    if (searchString(word, w)) {
                        System.out.println("Found");
                        matchedStrings(word, w).forEach(System.out::println);
                    } else System.out.println("Not found");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
