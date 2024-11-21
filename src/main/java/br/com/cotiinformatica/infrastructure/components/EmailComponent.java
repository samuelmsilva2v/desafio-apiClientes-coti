package br.com.cotiinformatica.infrastructure.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailComponent {

	@Value("${spring.mail.username}")
	private String userName;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String to, String subject, String body) throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		helper.setFrom(userName);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);

		javaMailSender.send(mimeMessage);
	}
}
