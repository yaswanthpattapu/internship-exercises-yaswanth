package exercise3.grep;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static exercise3.grep.Grep.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GrepTest {

    @Test
    public void itShouldIdentifyFileContainString() {
        Path file = Paths.get("src", "test", "resources", "exercise", "input.txt");
        assertTrue(searchString("world", file));
        assertFalse(searchString("random", file));

        List<String> lines = Arrays.asList("Hi world", "World tour?", "Hello world");
        Assert.assertEquals(matchedLines("world", file), lines);

        lines = List.of("Yaswanth");
        Assert.assertEquals(matchedLines("yaswanth", file), lines);

        lines = Arrays.asList("man where are", "Tony stark is Iron Man.");
        Assert.assertEquals(matchedLines("man", file), lines);

        Path folder = Paths.get("src", "test", "resources", "exercise");

        lines = List.of("src/test/resources/exercise/input.txt:Tony stark is Iron Man.");
        List<String> result = searchRecursively("tony", folder);
        Assert.assertEquals(result, lines);

        lines = List.of("src/test/resources/exercise/folder1/input.txt:World war is going on.", "src/test/resources/exercise/folder1/input.txt:I'm going to World tour.", "src/test/resources/exercise/input.txt:Hi world", "src/test/resources/exercise/input.txt:World tour?", "src/test/resources/exercise/input.txt:Hello world");
        result = searchRecursively("world", folder);
        Assert.assertEquals(result, lines);
    }
}
