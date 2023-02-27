package Services;

import Models.CalendarRequest;
import Models.Evenement;
import Models.User;
import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class EmailService {

    Properties prop = new Properties();
    Session session;

    public EmailService() {
        // SMTP Properties
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        String email = "00787089c367e9";
        String password = "02ac6d14bd1328";
        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
    }

    public void sendEmail(User to, Evenement evenement) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", false);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.freesmtpservers.com");
        prop.put("mail.smtp.port", "25");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Antika@esprit.tn"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(to.getEmail()));
        message.setSubject("Event Invitation : " + evenement.getNom());

        String msg = "Dear " + to.getPrenom() + " " + to.getNom() + ".";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

    }

    public void sendCalendarInvite(CalendarRequest calendarRequest) throws Exception {

        Message message = new MimeMessage(session);

        message.addHeader("method", "REQUEST");
        message.addHeader("charset", "UTF-8");
        message.addHeader("component", "VEVENT");
        message.setFrom(new InternetAddress("Antika@Esprit.tn"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(calendarRequest.getToEmail()));
        message.setSubject(calendarRequest.getSubject());

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setHeader("Content-Class", "urn:content-classes:calendarmessage");
        messageBodyPart.setHeader("Content-ID", "calendar_message");
        messageBodyPart.setDataHandler(
                new DataHandler(
                    new ByteArrayDataSource(
                            calendarRequest.getInvitationData(),
                            "text/calendar;method=REQUEST;name=\"invite.ics\""
                    )
                )
        );

        MimeMultipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println(calendarRequest.getSubject() + " invite sent to " + calendarRequest.getToEmail());
    }

}
