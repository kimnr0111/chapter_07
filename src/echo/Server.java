package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.118", 10001));
		
		System.out.println("<서버시작>");
		System.out.println("==================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		Socket socket = serverSocket.accept();
		
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		//서버가 메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
//		String str = br.readLine();
//		System.out.println(str);
		
		//서버가 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(true) {
			
			//서버 메세지 받기
			String msg = br.readLine();
			System.out.println("받은메세지:" + msg);
			
			if(msg == null) {
				System.out.println("클라이언트 접속 종료");
				break;
			}
			
			//서버 메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		

		bw.close();
		br.close();
		serverSocket.close();
		
	}

}
