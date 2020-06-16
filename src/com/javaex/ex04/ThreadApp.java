package com.javaex.ex04;

public class ThreadApp {

	public static void main(String[] args) {
		/*
		Runnable di = new DigitImpl();
		Thread thread01 = new Thread(di);
		*/
		
		Thread thread01 = new Thread(new DigitImpl());
		Thread thread02 = new Thread(new UpperImpl());
		Thread thread03 = new Thread(new LowerImpl());
		
		thread01.start();
		thread02.start();
		thread03.start();

	}

}
