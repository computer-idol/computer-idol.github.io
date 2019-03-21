package com.web.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail extends Thread{
	  //用于给用户发送邮件的邮箱
	    private String from = "249041573@qq.com";
	         //邮箱的用户名
	    private String username = "249041573@qq.com";
	        //邮箱的密码
	    private String password = "omfbswhwkbbccacf";
	        //发送邮件的服务器地址
	     private String host = "smtp.qq.com";
	     private String rootMail="";//收件人的邮箱
	     private String check = "";//要发给收件人的验证码
	     public SendMail(String mail,String check){
	        this.rootMail = mail;
	        this.check = check;
	     }
	     /* 重写run方法的实现，在run方法中发送邮件给指定的用户
	      * @see java.lang.Thread#run()
	      */
	     @Override
	     public void run() {
	         try{
	             Properties prop = new Properties();
	             prop.setProperty("mail.host", host);
	             prop.setProperty("mail.transport.protocol", "smtp");
	             prop.setProperty("mail.smtp.auth", "true");
	             Session session = Session.getInstance(prop);
	             session.setDebug(true);
	             Transport ts = session.getTransport();
	             ts.connect(host, username, password);
	             Message message = createEmail(session,rootMail);
	             ts.sendMessage(message, message.getAllRecipients());
	             ts.close();
	         }catch (Exception e) {
	             throw new RuntimeException(e);
	         }
	   }
	     
	    public Message createEmail(Session session,String mail) throws Exception{
	         
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
	         message.setSubject("找回密码");
	        
	         String info = "你好,找回在人人论坛的密码所需的验证码是: "+check+" ,请回到网页填写";
	         message.setContent(info, "text/html;charset=UTF-8");
	         message.saveChanges();
	         return message;
	     }
	 }
