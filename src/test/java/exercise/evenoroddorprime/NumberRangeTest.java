package exercise.evenoroddorprime;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRangeTest {

    @Test
    public void itShouldGiveRequiredOutput() {
        List<String> list1 = NumberRange.range(1, 15).collect(Collectors.toList());
        List<String> list2 = Arrays.asList("Odd", "2", "3", "Even", "5", "Even", "7", "Even", "Odd", "Even", "11", "Even", "13", "Even", "Odd");
        Assert.assertEquals(list1, list2);

        List<String> list3 = NumberRange.range(123, 145).collect(Collectors.toList());
        List<String> list4 = Arrays.asList("Odd", "Even", "Odd", "Even", "127", "Even", "Odd", "Even", "131", "Even", "Odd", "Even", "Odd", "Even", "137", "Even", "139", "Even", "Odd", "Even", "Odd", "Even", "Odd");
        Assert.assertEquals(list3, list4);
    }
}
