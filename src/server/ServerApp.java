package server;

import java.io.IOException;

import org.json.JSONException;

public class ServerApp {

	public static void main(String[] args) throws IOException {
		System.out.println("Server >> Starting!!! ");
		
		
		DataServer dataServer = new DataServer();
		try {
			dataServer.start();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
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
