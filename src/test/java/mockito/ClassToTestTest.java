package mockito;

import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ClassToTestTest {

    @Mock
    MyDatabase myDatabase;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


//    @Test
//    public void query() {
//        ClassToTest t = new ClassToTest(myDatabase);
//        boolean check = t.query("* from t");
//        assertTrue(check);
//        verify(t).query("* from t");
//    }
}