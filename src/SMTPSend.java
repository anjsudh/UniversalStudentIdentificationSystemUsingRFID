/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aruna
 */

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class SMTPSend {

    public SMTPSend() {
    }

    public  static void msgsend(String to,String body) {
        String username = "ssnuniversity";
        String password = "aruna1992";
        String smtphost = "ipipi.com";
        String compression = "Compression Option goes here - find out more";
        String from = "arunassn@ipipi.com";
      // to = "+919840171038@sms.ipipi.com";
      // body = "hi from automated sms..reply if u get.RFID Mission accomplished :)";
        Transport tr = null;

        try {
         Properties props = System.getProperties();
         props.put("mail.smtp.auth", "true");

         // Get a Session object
         Session mailSession = Session.getDefaultInstance(props, null);

         // construct the message
         Message msg = new MimeMessage(mailSession);

         //Set message attributes
         msg.setFrom(new InternetAddress(from));
         InternetAddress[] address = {new InternetAddress(to)};
         msg.setRecipients(Message.RecipientType.TO, address);
         msg.setSubject(compression);
         msg.setText(body);
         msg.setSentDate(new Date());

         tr = mailSession.getTransport("smtp");
         tr.connect(smtphost, username, password);
         msg.saveChanges();
         tr.sendMessage(msg, msg.getAllRecipients());
         tr.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

      public static void main(String[] argv) {
         // SMTPSend smtpSend = new SMTPSend();
          SMTPSend.msgsend("+919840171038@sms.ipipi.com","Hi");
      }
} 

