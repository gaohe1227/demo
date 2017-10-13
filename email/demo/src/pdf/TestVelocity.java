package pdf;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocity {

	public static void main(String[] args) throws Exception {

		// ��ʼ����ȡ��Velocity����

		VelocityEngine ve = new VelocityEngine();

		ve.init();

		// ȡ��velocity��ģ��

		Template t = ve.getTemplate("src/hello.vm");

		// ȡ��velocity��������context

		VelocityContext context = new VelocityContext();

		// ��vm��д����Ϣ

		context.put("name", "Liang");

		context.put("date", (new Date()).toString());

		StringWriter writer = new StringWriter();

		// ����������������

		t.merge(context, writer);

		String out = writer.toString();

		System.out.println(writer.toString());

	}

	public static String get() throws Exception {

		// ��ʼ����ȡ��Velocity����

		VelocityEngine ve = new VelocityEngine();

		ve.init();

		// ȡ��velocity��ģ��

		Template t = ve.getTemplate("src/hello.vm", "UTF-8");

		// velocity �ڸ�·��ʱ��Ƚ��鷳��

		// ȡ��velocity��������context
		

		VelocityContext context = new VelocityContext();
		context.put("name", "Liang");

		context.put("date", (new Date()).toString());
        
		StringWriter writer = new StringWriter();
      
		// ����������������

		t.merge(context, writer);

		// �����

		String out = writer.toString();

		return out;

	}

}
