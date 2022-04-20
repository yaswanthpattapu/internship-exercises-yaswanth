package exercise3.grep;

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

    public static List<String> matchedLines(String word, Path file) {
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
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            StringBuilder str = new StringBuilder();
            for (String s : result) {
                str.append(s).append("\n");
            }
            Files.write(file, str.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> searchRecursively(String word, Path folder) {
        List<String> match = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(folder)) {
            paths.forEach(w -> {
                if (Files.isRegularFile(w) && searchString(word, w)) {
                    for (String line : matchedLines(word, w)) {
                        match.add(w + ":" + line);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return match;
    }
}
