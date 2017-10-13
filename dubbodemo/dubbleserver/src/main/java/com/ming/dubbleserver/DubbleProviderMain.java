package com.ming.dubbleserver;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubbleProviderMain {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationProvider.xml" });
		context.start();
		System.out.println("Press any key to exit.");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
