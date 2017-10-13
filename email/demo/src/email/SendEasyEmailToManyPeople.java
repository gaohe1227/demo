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
		
	        // �ռ��˵������䡾�����ж���ռ��ˡ�  
	        InternetAddress[] sendTo = new InternetAddress[toAddress.length];  
	        for (int i = 0; i < toAddress.length; i++) {  
	            System.out.println("���͵�:" + toAddress[i]);  
	            sendTo[i] = new InternetAddress(toAddress[i]);  
	        }  
	  
	        // �����˵�������  
	        String from = fromAddress;  
	  
	        // ָ�������ʼ�������  
	        String host = hostAddress;  
	  
	        // ��ȡϵͳ����  
	        Properties properties = System.getProperties();  
	        properties.setProperty("mail.transport.protocol", "smtp");  
	        // �����ʼ�������  
	        properties.setProperty("mail.smtp.host", host);   
	        properties.put("mail.smtp.auth", "true"); // ��������ͨ����֤  
	        MyAuthenticator myauth = new MyAuthenticator("904724283@qq.com", "kjcgvmghhqmsbcdd");// �����ʼ��������û���֤  //cfbkpinxpwwbbbfa//kjcgvmghhqmsbcdd
	        //����
	        MailSSLSocketFactory  sf=new MailSSLSocketFactory();
	         properties.put("mail.smtp.ssl.enable", "true");
	         properties.put("mail.smtp.ssl.socketFactory", sf);
	        // ��ȡĬ��session����  
	        Session session = Session.getInstance(properties, myauth);  
	     
	        try {  
	            // ����Ĭ�ϵ� MimeMessage ����  
	            MimeMessage message = new MimeMessage(session);  
	  
	            // Set From: ͷ��ͷ�ֶ�  
	            message.setFrom(new InternetAddress(from));  // �����ʼ������ߵĵ�ַ
	            message.setSentDate(new Date()); // �����ʼ���������
	            // Set To: ͷ��ͷ�ֶΣ�type:Ҫ������ΪTO, CC ����BCC. ����CC �����͡�BCC �������ܳ���y.  
	            message.addRecipients(RecipientType.TO, sendTo);  //�ռ���
	            // Set Subject: ͷ��ͷ�ֶ�  
	            message.setSubject(subject);   // �����ʼ�����
	            message.setContent("<div style='color:red;'>����html</div>", "text/html;charset=utf-8");//�ʼ�����
	            // ������Ϣ��  
	           // message.setText(messageText);  
	            // ������Ϣ����
	            BodyPart messageBodyPart = new MimeBodyPart();
	    
	            // ��Ϣ
	            messageBodyPart.setText("This is message body");
	            // ����������Ϣ
	            Multipart multipart = new MimeMultipart();
	    
	            // �����ı���Ϣ����
	            multipart.addBodyPart(messageBodyPart);
	    
	            // ��������
	            messageBodyPart = new MimeBodyPart();
	            String filename = "file.txt";
	            DataSource source = new FileDataSource(filename);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(filename);
	            multipart.addBodyPart(messageBodyPart);
	    
	            // ����������Ϣ
	            message.setContent(multipart );
	            
	            // ������Ϣ  
	            Transport.send(message);   // �����ʼ�
	            System.out.println("Sent message successfully....");  
	        } catch (MessagingException mex) {  
	            mex.printStackTrace();  
	        }  
	  
	    }  
	 public static void main(String[] args) throws Exception {  
	        // �ռ������䡾����ռ��ˡ�  
	        String[] toAddress = new String[] { "904724283@qq.com","gaohe2017@chaoxing.com"  };  
	        // ����������  
	        String fromAddress = "904724283@qq.com";  
	        // �ʼ����������ͣ�����Ϊqq�����Ҫ��163��Ϊ��smtp.163.com����  
	        String hostAddress = "smtp.qq.com";  
	        // �ʼ�������  
	        String subject = "�����ʼ�����JAVA";  
	        // �ʼ�������  
	        String messageText = "Hello World��˹�ٷ�";  
	  
	        // �����ʼ�  
	        SendEasyEmailToManyPeople.SendEmail(toAddress, fromAddress, hostAddress, subject, messageText);  
	    }  
}
