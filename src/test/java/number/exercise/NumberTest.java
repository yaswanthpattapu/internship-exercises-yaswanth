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
        System.out.println(list1);
        System.out.println(list2);

//        for(int i=0; i<list1.size();i++)
//        {
//            assertThat(list1.get(i),is(list1.get(i)));
//        }
        Assert.assertEquals(list1,list2);
    }
}
