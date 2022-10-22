package poly.common;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import poly.domain.Email;

public class EmailUtils {
	public static void send(Email email) throws Exception {		
		final String username = email.getFrom();
        final String password = email.getFromPassword();
        
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email.getTo())
            );
            message.setSubject(email.getSubjectString());
            message.setContent(email.getContent(), "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
	}
		
}
