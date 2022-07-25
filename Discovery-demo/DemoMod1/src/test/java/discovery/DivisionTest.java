package discovery;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DivisionTest {

    private DivisionMath divisionMath;

    @Before
    public void init() {
        divisionMath = new DivisionMath();
    }

    @Test
    @DisplayName("Input 1 = 6 and Input 2 =  2 then result will be 3")
    public void input1() {
        int result = divisionMath.div(6, 2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Input 1 = 7 and Input 2 =  3 then result will be 2")
    public void input2() {
        int result = divisionMath.div(7, 3);
        assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    @DisplayName("Input 1 = 8 and Input 2 =  0 then result will be exception")
    public void input3() {
        int result = divisionMath.div(8, 0);
    }
}
