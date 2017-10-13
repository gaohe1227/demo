package com.ming.dubboconsumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ming.dubbleserver.HelloWorld;

public class ConsumerThd  implements Runnable {
    public void run() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationConsumer.xml" });
        context.start();
       // context.getBean("demoService");
         System.out.println("----------------------");
         HelloWorld helloWorld = (HelloWorld) context.getBean("demoService");
         
         String hello = helloWorld.hello("С��");
         System.out.println(hello);
         System.out.println("ִ�����");
    }

    public static void main(String[] args) {
    	
        new Thread(new ConsumerThd()).start();
    }
}
