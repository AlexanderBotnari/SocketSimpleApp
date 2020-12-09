package server;

import java.io.IOException;

public class ServerApp {

	public static void main(String[] args) throws IOException {
		System.out.println("Server >> Starting!!! ");
		
		
		DataServer dataServer = new DataServer();
		dataServer.start();
		
		
		
		
//		ServerSocket serverSocket = new ServerSocket(7777);
//		
//		System.out.println("Server >> waiting ");
//		
//		Socket clientSocket = serverSocket.accept();
//		
//		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
//		DataInputStream din = new DataInputStream(clientSocket.getInputStream());
//		
//		System.out.println("Server >> client sent : "+din.readUTF());
//		dout.writeUTF("Hello back from the server !!! ");
//		
//		dout.flush();
		
		System.out.println("Server >> Ending ");
		
	}

}
