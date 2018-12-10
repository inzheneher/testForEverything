package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private IEventLogger logger;

    public App(Client client, IEventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    private void logEvent(Event event) {
//        String message = str.replaceAll(client.getId(), client.getFullName());
//        logger.logEvent(message);
        logger.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        event.setStr("New message for user 1");
        app.logEvent(event);

//        app.logEvent("New message for user 1");
//        app.logEvent("New message for user 2");
    }
}
