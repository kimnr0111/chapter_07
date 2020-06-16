package com.javaex.ex03;

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {

		/*
		Runnable di = new DigitImpl();
		Thread thread = new Thread(di);
		*/
		
		Thread thread01 = new Thread(new DigitImpl());
		Thread thread02 = new Thread(new UpperImpl());
		Thread thread03 = new Thread(new LowerImpl());
		
		thread01.start();
		thread02.start();
		thread03.start();
		
		/*
		for(char ch='A';ch<='Z';ch++) {
			System.out.println(ch);
			Thread.sleep(1000);
		}
		*/
		
	}

}
