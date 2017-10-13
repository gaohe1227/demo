package email;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEasyEmailToManyPeople {
	 public static void SendEmail(String[] toAddress, String fromAddress, String hostAddress, String subject, String messageText) throws Exception {  
		
	        // 收件人电子邮箱【可以有多个收件人】  
	        InternetAddress[] sendTo = new InternetAddress[toAddress.length];  
	        for (int i = 0; i < toAddress.length; i++) {  
	            System.out.println("发送到:" + toAddress[i]);  
	            sendTo[i] = new InternetAddress(toAddress[i]);  
	        }  
	  
	        // 发件人电子邮箱  
	        String from = fromAddress;  
	  
	        // 指定发送邮件的主机  
	        String host = hostAddress;  
	  
	        // 获取系统属性  
	        Properties properties = System.getProperties();  
	        properties.setProperty("mail.transport.protocol", "smtp");  
	        // 设置邮件服务器  
	        properties.setProperty("mail.smtp.host", host);   
	        properties.put("mail.smtp.auth", "true"); // 这样才能通过验证  
	        MyAuthenticator myauth = new MyAuthenticator("904724283@qq.com", "kjcgvmghhqmsbcdd");// 进行邮件服务器用户认证  //cfbkpinxpwwbbbfa//kjcgvmghhqmsbcdd
	        //加密
	        MailSSLSocketFactory  sf=new MailSSLSocketFactory();
	         properties.put("mail.smtp.ssl.enable", "true");
	         properties.put("mail.smtp.ssl.socketFactory", sf);
	        // 获取默认session对象  
	        Session session = Session.getInstance(properties, myauth);  
	     
	        try {  
	            // 创建默认的 MimeMessage 对象  
	            MimeMessage message = new MimeMessage(session);  
	  
	            // Set From: 头部头字段  
	            message.setFrom(new InternetAddress(from));  // 设置邮件发送者的地址
	            message.setSentDate(new Date()); // 设置邮件发送日期
	            // Set To: 头部头字段（type:要被设置为TO, CC 或者BCC. 这里CC 代表抄送、BCC 代表秘密抄送y.  
	            message.addRecipients(RecipientType.TO, sendTo);  //收件人
	            // Set Subject: 头部头字段  
	            message.setSubject(subject);   // 设置邮件主题
	            message.setContent("<div style='color:red;'>测试html</div>", "text/html;charset=utf-8");//邮件正文
	            // 设置消息体  
	           // message.setText(messageText);  
	            // 创建消息部分
	            BodyPart messageBodyPart = new MimeBodyPart();
	    
	            // 消息
	            messageBodyPart.setText("This is message body");
	            // 创建多重消息
	            Multipart multipart = new MimeMultipart();
	    
	            // 设置文本消息部分
	            multipart.addBodyPart(messageBodyPart);
	    
	            // 附件部分
	            messageBodyPart = new MimeBodyPart();
	            String filename = "file.txt";
	            DataSource source = new FileDataSource(filename);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(filename);
	            multipart.addBodyPart(messageBodyPart);
	    
	            // 发送完整消息
	            message.setContent(multipart );
	            
	            // 发送消息  
	            Transport.send(message);   // 发送邮件
	            System.out.println("Sent message successfully....");  
	        } catch (MessagingException mex) {  
	            mex.printStackTrace();  
	        }  
	  
	    }  
	 public static void main(String[] args) throws Exception {  
	        // 收件人邮箱【多个收件人】  
	        String[] toAddress = new String[] { "904724283@qq.com","gaohe2017@chaoxing.com"  };  
	        // 发件人邮箱  
	        String fromAddress = "904724283@qq.com";  
	        // 邮件服务器类型（这里为qq，如果要用163则为“smtp.163.com”）  
	        String hostAddress = "smtp.qq.com";  
	        // 邮件的主题  
	        String subject = "测试邮件——JAVA";  
	        // 邮件的正文  
	        String messageText = "Hello World阿斯蒂芬";  
	  
	        // 发送邮件  
	        SendEasyEmailToManyPeople.SendEmail(toAddress, fromAddress, hostAddress, subject, messageText);  
	    }  
}
