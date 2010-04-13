package com.will.service;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.will.mail.MailTemplate;
public class MailerService {
    private static final Logger log = Logger.getLogger(MailerService.class.getName());
    public void sendMail(MailTemplate template){
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "...";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("ladder.stephen.leacock@gmail.com", "Tennis Ladder Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("will.han@gmail.com", "Mr. User"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (Exception e) {
	    e.printStackTrace();
	    log.log(Level.SEVERE, e.getMessage());

        }
    }

}
