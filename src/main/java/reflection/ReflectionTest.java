package reflection;

import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) {
        try {
            Guest guest = Guest.class.getConstructor(String.class, Integer.class).newInstance("Ivan", 35);
            System.out.println(guest.toString());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
