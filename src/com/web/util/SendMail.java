package com.web.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail extends Thread{
	  //���ڸ��û������ʼ�������
	    private String from = "249041573@qq.com";
	         //������û���
	    private String username = "249041573@qq.com";
	        //���������
	    private String password = "omfbswhwkbbccacf";
	        //�����ʼ��ķ�������ַ
	     private String host = "smtp.qq.com";
	     private String rootMail="";//�ռ��˵�����
	     private String check = "";//Ҫ�����ռ��˵���֤��
	     public SendMail(String mail,String check){
	        this.rootMail = mail;
	        this.check = check;
	     }
	     /* ��дrun������ʵ�֣���run�����з����ʼ���ָ�����û�
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
	         message.setSubject("�һ�����");
	        
	         String info = "���,�һ���������̳�������������֤����: "+check+" ,��ص���ҳ��д";
	         message.setContent(info, "text/html;charset=UTF-8");
	         message.saveChanges();
	         return message;
	     }
	 }
