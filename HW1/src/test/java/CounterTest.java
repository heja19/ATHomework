import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CounterTest {
    private Counter counter = new Counter();

    @Test
    public void counts () {
        int result = counter.count("Helena");
        assertEquals(6, result);
    }

    @Test
    public void countSpaceAndString () {
        int result = counter.count("Helena Jäe");
        assertEquals(10, result);
    }

    @Test
    public void countSpace () {
        int result = counter.count(" ");
        assertEquals(1, result);
    }

    @Test
    public void countEmty () {
        int result = counter.count("");
        assertEquals(0, result);
    }
}