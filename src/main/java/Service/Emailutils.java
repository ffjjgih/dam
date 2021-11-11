package Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Model.Gmail;

public class Emailutils {
	public static void send(Gmail email) {
	Properties properties = new Properties();
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");

	  Session session = Session.getInstance(properties, new
	  javax.mail.Authenticator() { protected PasswordAuthentication
	  getPasswordAuthentication() { return new
	  PasswordAuthentication(email.getFrom(), email.getFrompassword()); } });
	 
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getFrom()));
		message.setContent(email.getContent(), "text/html;charset=utf-8");
		message.setSubject(email.getSubject());
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
		Transport.send(message);
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}
