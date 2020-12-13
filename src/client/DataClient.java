package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.json.JSONObject;


public class DataClient {

	private List<Integer> data;
	private Socket socket;

	public DataClient(List<Integer> data) {
		this.data = data;
	}
	
	public List<Integer> getData(String option) throws UnknownHostException, IOException {
		
		socket = new Socket("localhost",8888);
		
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
        System.out.println("Client >> Send list: " +  dataToJSON(option));
        dout.writeUTF( dataToJSON(option).toString());
	    dout.flush();
	    
        System.out.println("Client >> server sent back : "+ din.readUTF());
	      		 
		return data;
	}
	
	private String dataToString() {

		StringBuilder sb = new StringBuilder();

		this.data.forEach(i -> sb.append(i).append(","));

		return sb.substring(0, sb.length() - 1);
	}
	
	private JSONObject dataToJSON(String option) {
		JSONObject jSonObj = new JSONObject("{\"data\":\""+dataToString()+"\",\"option\":\""+option+"\"}");
		return jSonObj;
	}

}
