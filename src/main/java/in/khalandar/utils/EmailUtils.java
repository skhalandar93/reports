package in.khalandar.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;
	
	public void SendEmailWithHyperLink(String toEmail, String subject, String linkUrl,String linkText) throws MessagingException{
		MimeMessage message= mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setTo(toEmail);
		helper.setSubject(subject);
		
		String content = "<p>Please click the link below:</p>"
                + "<a href=\"E-Mail" + "/E-Mail" + "\">" +"E-Mail"+ "</a>";
		
 helper.setText(content, true);  // true = HTML content
 mailSender.send(message);
	}

}
