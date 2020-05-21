import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GreeterTest {

    @Mock
    private Counter counter;

    @InjectMocks
    private Greeter greeter = new Greeter();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void greetingShortString() {
        //given
        when(counter.count(anyString())).thenReturn(1);
        //when
        String result = greeter.sayHello("Ami");
        //then
        assertEquals("Wow that's a short name, Ami, welcome!", result);
    }

    @Test
    public void greetingMediumString() {
        //given
        when(counter.count(anyString())).thenReturn(6);
        //when
        String result = greeter.sayHello("Helena");
        //then
        assertEquals("Hello, Helena, welcome! Your name is 6 characters long", result);
    }

    @Test
    public void greetingLongString() {
        //given
        when(counter.count(anyString())).thenReturn(20);
        //when
        String result = greeter.sayHello("Ami");
        //then
        assertEquals("Who are you?", result);
    }

    @Test
    public void greetingNoName() {
        //given
        when(counter.count(anyString())).thenReturn(0);
        //when
        String result = greeter.sayHello("Helena");
        //then
        assertEquals("Who are you?", result);
    }
}
