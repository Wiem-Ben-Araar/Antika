package Models;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CalendarRequest {
    private final String uid = UUID.randomUUID().toString();
    private String toEmail;
    private String subject;
    private String body;
    private String startDate;
    private String endDate;
    private String location;

    public CalendarRequest(Evenement evenement, User user) {
        setEvenement(evenement);
        setUser(user);
    }

    public void setEvenement(Evenement evenement) {
        subject = evenement.getNom();
        body = evenement.getDescription();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
        startDate = formatter
                .format(evenement.getEvenement_date().toLocalDate().atTime(12, 0, 0))
                .replace(" ", "T");
        endDate = formatter
                .format(evenement.getEvenement_date().toLocalDate().atTime(14, 0, 0))
                .replace(" ", "T");

        location = evenement.getLieu();
    }

    public void setUser(User user) {
        toEmail = user.getEmail();
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getInvitationData() {
        return "BEGIN:VCALENDAR\n" +
                "METHOD:REQUEST\n" +
                "PRODID:Antika\n" +
                "VERSION:2.0\n" +
                "BEGIN:VTIMEZONE\n" +
                "TZID:Africa/Tunis\n" +
                "END:VTIMEZONE\n" +
                "BEGIN:VEVENT\n" +
                "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:" + toEmail + "\n" +
                "ORGANIZER;CN=Foo:MAILTO:" + toEmail + "\n" +
                "DESCRIPTION;LANGUAGE=en-US:" + body + "\n" +
                "UID:" + uid + "\n" +
                "SUMMARY;LANGUAGE=en-US:" + subject + "\n" +
                "DTSTART:" + startDate + "\n" +
                "DTEND:" + endDate + "\n" +
                "CLASS:PUBLIC\n" + "PRIORITY:5\n" + "DTSTAMP:20200922T105302Z\n" +
                "TRANSP:OPAQUE\n" + "STATUS:CONFIRMED\n" + "SEQUENCE:$sequenceNumber\n" +
                "LOCATION;LANGUAGE=en-US:" + location + "\n" + "BEGIN:VALARM\n" +
                "DESCRIPTION:REMINDER\n" + "TRIGGER;RELATED=START:-PT1D\n" + "ACTION:DISPLAY\n" +
                "END:VALARM\n" + "END:VEVENT\n" + "END:VCALENDAR";
    }
}
