package pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class ItextPdf {

	public static final String HTML = "E:/MyHtml.html";

	public static final String DEST = "E:/hero.pdf";

	public void createPdf(String file) throws Exception {

	 

		Document document = new Document();

	 

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));

	 

		document.open();

		 String value = TestVelocity.get();
System.out.println(value);
		@SuppressWarnings("deprecation")

		Reader reader = new StringReader(value);

	 

		  XMLWorkerHelper.getInstance().parseXHtml(writer, document, reader);

/*		XMLWorkerHelper.getInstance().parseXHtml(writer, document,

				new FileInputStream(HTML), Charset.forName("UTF-8"));*/

		// step 5

		document.close();

	}
 

	public static void main(String[] args) throws Exception {
		try {
			File file = new File(DEST);

			file.getParentFile().mkdirs();

			new ItextPdf().createPdf(DEST);
			Pattern p=Pattern.compile("^[a-z][1-9]{1,}[a-z]$");
			  Matcher m =p.matcher("a122a");
			System.out.println(m.find()+m.group());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
