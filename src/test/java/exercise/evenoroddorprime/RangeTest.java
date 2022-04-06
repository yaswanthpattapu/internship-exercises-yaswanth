package exercise.evenoroddorprime;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RangeTest {

    @Test
    public void itShouldGiveRequiredOutput() {
        Stream<String> stream = Range.of(1, 15);
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = Arrays.asList("Odd", "2", "3", "Even", "5", "Even", "7", "Even", "Odd", "Even", "11", "Even", "13", "Even", "Odd");
        Assert.assertEquals(list1, list2);

        stream = Range.of(123, 145);
        List<String> list3 = stream.collect(Collectors.toList());
        List<String> list4 = Arrays.asList("Odd", "Even", "Odd", "Even", "127", "Even", "Odd", "Even", "131", "Even", "Odd", "Even", "Odd", "Even", "137", "Even", "139", "Even", "Odd", "Even", "Odd", "Even", "Odd");
        Assert.assertEquals(list3, list4);
    }
}
