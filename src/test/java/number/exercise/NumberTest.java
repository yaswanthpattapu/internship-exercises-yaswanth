package number.exercise;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class NumberTest {

    @Test
    public void validateInput()
    {
        Number inp = new Number();
        List<String> list1 = inp.range(1,15);
        List<String> list2 = Arrays.asList("Odd", "2", "3", "Even", "5", "Even", "7", "Even", "Odd", "Even", "11", "Even", "13", "Even", "Odd");
   
        Assert.assertEquals(list1,list2);
    }
}
