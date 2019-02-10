package serialize;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Al");
        user.setLastName("Me");

        try (FileOutputStream fos =
                     new FileOutputStream("src/main/resources/user" +
                             ".ser");
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos);
             FileInputStream fis =
                     new FileInputStream("src/main/resources/user" +
                             ".ser");
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {

            oos.writeObject(user);

            System.out.println("Serialized data is saved in " +
                    "/resources/user.ser");

            user = null;

            user = (User) ois.readObject();

            System.out.println("Deserialized data from /resources/user.ser");

            System.out.println(user);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
