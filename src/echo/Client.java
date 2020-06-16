package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("====================================================");
		
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.118", 10001));
		System.out.println("[서버에 연결되었습니다.]");
		
		//클라이언트가 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//클라이언트가 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String msg = sc.nextLine();
			if(msg.equals("q")) {
				System.out.println("접속 종료되었습니다.");
				break;
			}
			
			//클라이언트 메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			//클라이언트 메세지 받기
			String reMsg = br.readLine();
			System.out.println("server:" + reMsg);
		}
		
		System.out.println("<클라이언트 종료>");

		sc.close();
		bw.close();
		br.close();
		socket.close();
		
	}

}
