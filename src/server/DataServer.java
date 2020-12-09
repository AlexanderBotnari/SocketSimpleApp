package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public void start() throws IOException {

			serverSocket = new ServerSocket(8888);

			System.out.println("Server >> Client Waiting");
			clientSocket = serverSocket.accept();
			
			DataInputStream din = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());

			String data = din.readUTF();
			
			System.out.println("Server >> list received: " + data);

			System.out.println("Server >> Send message: " + getAverage(data));
			dout.writeUTF(getAverage(data));
   
	}
	
	private String getAverage(String data) {

		int sum = 0;
		int count = 0;
		for (String number : data.split(",") ) {
			sum += Integer.parseInt(number);
			count ++;
		}

		return "Average is " + sum / count;
	}
}