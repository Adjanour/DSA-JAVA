import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AtoiTest {

    @Test
    public void testAtoi() {
        assertEquals(42, Atoi.atoi("42"));
        assertEquals(-42, Atoi.atoi("   -42"));
        assertEquals(4193, Atoi.atoi("4193 with words"));
        assertEquals(0, Atoi.atoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, Atoi.atoi("-91283472332"));
        assertEquals(Integer.MAX_VALUE, Atoi.atoi("91283472332"));
        assertEquals(1234, Atoi.atoi("000001234"));
        assertEquals(0, Atoi.atoi("+-2"));
        assertEquals(0, Atoi.atoi(""));
        assertEquals(0, Atoi.atoi("   +0 123"));
    }
}