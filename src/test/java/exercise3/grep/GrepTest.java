package exercise3.grep;

import org.junit.Test;

import java.nio.file.Path;

import static exercise3.grep.Grep.searchString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GrepTest {

    @Test
    public void itShouldTrackStrings()
    {
        assertThat(searchString("world", Path.of("/home/yaswanth/Desktop/exercise/input.txt")), is(equalTo(true)));
        assertThat(searchString("world", Path.of("/home/yaswanth/Desktop/exercise/folder1/input.txt")), is(equalTo(false)));
        assertThat(searchString("yaswanth", Path.of("/home/yaswanth/Desktop/exercise/folder1/input.txt")), is(equalTo(true)));
    }
}
