package number.exercise;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class NumberTest {

    @Test
    public void validateInput()
    {
        Number inp = new Number();
        List<String> list1 = inp.range(1,15);
        List<String> list2 = Arrays.asList("Odd", "2", "3", "Even", "5", "Even", "7", "Even", "Odd", "Even", "11",
                "Even", "13", "Even", "Odd");

        for(int i=0;i<list1.size();i++)
        {
            Assert.assertThat(list1.get(i),is(list2.get(i)));
        }

        List<String> list3 = inp.range(123,145);
        List<String> list4 = Arrays.asList("Odd", "Even", "Odd", "Even", "127", "Even", "Odd", "Even", "131", "Even",
                "Odd", "Even", "Odd", "Even", "137", "Even", "139", "Even", "Odd", "Even", "Odd", "Even", "Odd");

        for(int i=0;i<list3.size();i++)
        {
            Assert.assertThat(list3.get(i),is(list4.get(i)));
        }
    }
}
