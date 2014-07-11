/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailtls {
  
 public static void sendmail(String msg, String dest, String subject, String sender) {
 
  final String username = "";
  final String password = "";
 
  Properties props = new Properties();
  props.put("mail.smtp.user", "marwa-boulakbech@hotmail.fr");
  props.put("mail.smtp.password","mathematique");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.host", "smtp.live.com");
  props.put("mail.smtp.port", "587");
 
  Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
    });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(sender));
   message.setRecipients(Message.RecipientType.TO,
     InternetAddress.parse(dest));
   message.setSubject(subject);
   message.setText(msg);
 
   Transport.send(message);
 
   System.out.println("Done");
 
  } catch (MessagingException e) {
   System.out.println("Mail exception : " + e);
  }
 }
}