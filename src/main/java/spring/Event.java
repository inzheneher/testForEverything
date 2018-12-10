package spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String str;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
        this.id = new Random().nextInt((int) Math.pow(10, 9));
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", str='" + str + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
