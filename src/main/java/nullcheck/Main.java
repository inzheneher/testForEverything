package nullcheck;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        User user = null;
//        User user = new User();
        Objects.requireNonNull(user, "User was not initialise properly.");
        user.setName("Bogdan");
        user.setLastName("Konukovsky");
        System.out.println(
                user.getName() +
                        " " +
                        user.getLastName()
        );
    }
}
