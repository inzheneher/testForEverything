package nullcheck;

import java.util.Objects;

public class User {
    private String name;
    private String lastName;
    private final String NAME_IS_EMPTY = "Name is empty.";
    private final String LASTNAME_IS_EMPTY = "Last name is empty.";

    public String getName() {
        return Objects.isNull(name) ? NAME_IS_EMPTY : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return Objects.isNull(lastName) ? LASTNAME_IS_EMPTY : lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
