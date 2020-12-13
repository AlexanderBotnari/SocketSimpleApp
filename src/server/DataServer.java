package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


public class DataServer {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public void start() throws JSONException, Exception {

			serverSocket = new ServerSocket(8888);

			System.out.println("Server >> Client Waiting");
			clientSocket = serverSocket.accept();
			
			DataInputStream din = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());

			String data = din.readUTF();
			
			System.out.println("Server >> list received: " + data);
			
			JSONObject jSonObj = new JSONObject(data);
			
			JSONObject averageToJSON = new JSONObject("{\"avg\":\""+getAverage(jSonObj.get("data").toString(),
					jSonObj.get("option").toString())+"\"}");
			
			System.out.println("Server >> Send message: " + averageToJSON);
			dout.writeUTF(averageToJSON.toString());
		
			
	}
	
	private  String getAverage(String data, String option) throws Exception {

		int sum = 0;
		int count = 0;
		for (Integer number : getSortedDataWithOption(data,option) ) {
			sum += number;
			count ++;
		}

		return " "+sum / count;
	}
	
	private List<Integer> getSortedDataWithOption(String data, String option) throws Exception{
		
		List<Integer> sd = new ArrayList<>();

		for (String d : data.split(",")) {
			int i = Integer.parseInt(d);

			if (option.equals("negative") && i < 0) {
				sd.add(i);
			}else if (option.equals("positive") && i >= 0) {
				sd.add(i);
			}else {
				throw new Exception("Error! Numbers cannot be sorted, select the correct option !") ;
			}
		}
		return sd;
		
	}
}