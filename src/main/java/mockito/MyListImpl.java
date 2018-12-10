package mockito;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyListImpl {
    public static void main(String[] args) {
        MyList myList = mock(MyList.class);
        when(myList.add(anyString())).thenReturn(false);

        boolean added = myList.add(randomAlphabetic(6));
    }
}
