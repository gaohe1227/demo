package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		demo01();
		demo02();
		demo03();
		

	}

	private static void demo03() {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile fromFile=new RandomAccessFile("fromFile.txt", "rw");
		
			FileChannel fromChannel=fromFile.getChannel();
			ByteBuffer byteBuffer=ByteBuffer.allocate(200);
			byteBuffer.put("²âÊÔ".getBytes());
			  System.out.println(fromChannel.isOpen());
			  byteBuffer.flip();
			  fromChannel.write(byteBuffer);
			  fromChannel.close();
			  fromChannel=null;
				RandomAccessFile fromFile1=new RandomAccessFile("fromFile.txt", "rw");
			  FileChannel  fromChannel1=fromFile1.getChannel();
			  
			  System.out.println(fromChannel1.isOpen());
			RandomAccessFile toFile=new RandomAccessFile("toFile.txt", "rw");
			FileChannel toChannel=toFile.getChannel();
			long position = 0;
			long count    = fromChannel1.size();
			toChannel.transferFrom(fromChannel1, position, count);
		     
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void demo02() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile  file=new RandomAccessFile("data.txt", "rw");
		FileChannel fileChannel=file.getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(48);
		System.out.println(buffer.array());
		int byteRead=fileChannel.read(buffer);
		while(byteRead !=-1){
			System.out.println("Read====>"+byteRead);
			buffer.flip();
			while(buffer.hasRemaining()){
				 System.out.print((char) buffer.get());
			}
			buffer.clear();
			byteRead=fileChannel.read(buffer);
		}
		System.out.println();
	}

	/**
	 * @Title: demo01
	 * @Description: TODO
	 * @param @throws IOException
	 * @param @throws FileNotFoundException
	 * @return void
	 * @throws
	 */ 
	private static void demo01() throws IOException, FileNotFoundException {
		File file=new File("data.txt");
		if(!file.exists()){
		 
				file.createNewFile(); 
		}
		
		FileOutputStream out=new FileOutputStream(file);
		FileChannel channel=out.getChannel();
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		String str="java nio";
		byteBuffer.put(str.getBytes());
		byteBuffer.flip();
		channel.write(byteBuffer);
		channel.close();
		out.close();
	}

}
