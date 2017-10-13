package pdf;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocity {

	public static void main(String[] args) throws Exception {

		// 初始化并取得Velocity引擎

		VelocityEngine ve = new VelocityEngine();

		ve.init();

		// 取得velocity的模版

		Template t = ve.getTemplate("src/hello.vm");

		// 取得velocity的上下文context

		VelocityContext context = new VelocityContext();

		// 往vm中写入信息

		context.put("name", "Liang");

		context.put("date", (new Date()).toString());

		StringWriter writer = new StringWriter();

		// 把数据填入上下文

		t.merge(context, writer);

		String out = writer.toString();

		System.out.println(writer.toString());

	}

	public static String get() throws Exception {

		// 初始化并取得Velocity引擎

		VelocityEngine ve = new VelocityEngine();

		ve.init();

		// 取得velocity的模版

		Template t = ve.getTemplate("src/hello.vm", "UTF-8");

		// velocity 在给路劲时会比较麻烦，

		// 取得velocity的上下文context
		

		VelocityContext context = new VelocityContext();
		context.put("name", "Liang");

		context.put("date", (new Date()).toString());
        
		StringWriter writer = new StringWriter();
      
		// 把数据填入上下文

		t.merge(context, writer);

		// 输出流

		String out = writer.toString();

		return out;

	}

}
