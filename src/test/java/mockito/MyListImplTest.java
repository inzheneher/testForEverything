package mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyListImplTest {

    @Test
    public void someMethod() {
        List list = mock(ArrayList.class);
        when(list.get(0)).thenReturn("Muhhahha!!!");
        assertEquals("Muhhahha!!!", list.get(0));
        verify(list).get(0);
    }
}