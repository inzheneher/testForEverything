package polygone;

import spring.Event;

import java.text.DateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Event(new Date(), DateFormat.getDateTimeInstance()));
    }
}
