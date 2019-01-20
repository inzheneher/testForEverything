package email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    private static final Logger log = LogManager.getLogger(SendEmail.class);
    public static void main(String[] args) {
        String to = "inzheneher@ya.ru";
        String from = "melnikov.alexander.v@gmail.com";
        String ps = "8s72977pJ5R496N86qcC";
        String host = "smtp.gmail.com";
        String port = "587";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is my first test e-mail from program");
            message.setText("Ok, this is exactly what I want to say!");

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, ps);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.debug("Sent message successfully...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
