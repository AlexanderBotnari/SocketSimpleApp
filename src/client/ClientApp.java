package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientApp {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Client >> Starting!!! ");
		
		List<Integer> list = new ArrayList<>();
		list.add(-12);list.add(-23);list.add(-34);
		DataClient dataClient = new DataClient(list);
	
		dataClient.getData("negative");
//		Socket clientSocket = new Socket("localhost",7777);
//		
//		System.out.println("Client >> sending ");
//		
//		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
//		DataInputStream din  = new DataInputStream(clientSocket.getInputStream());
//		
//		dout.writeUTF("Hello Server !!! ");
//		dout.flush();
//		
//		System.out.println("Client >> server sent back : "+din.readUTF());
//		
		System.out.println("Client >> Ending ");
		
		
	}
}
