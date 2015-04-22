package hotelroommanager.client;

import java.net.*;
import java.io.*;
import java.util.*;


/**
  * @class: ReservationClient
  *
  * A class meant to initialize a reservation client
  * for the user
  *
  * Contains Main
  *
  */

public class ReservationClient
{
	public static void main(String[] args){
		//TODO: handle bad params

		//expects IP address (or localhost)
		String serverName = args[0];

		//expects a non-reserved port
		int port = Integer.parseInt(args[1]);

		//Socket to connect with the server
		Socket client = null;

		try{
			//create connection to server
			System.out.println("Connecting to " + serverName + " on port " + port);
			client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());

			//create scanner for user input via cli
			Scanner scan = new Scanner(System.in);

			//set up output stream
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			//start thread to accept any incoming messages from the server
			Thread msgAcceptance = new InboundMsg(client);
			msgAcceptance.start();

			//accept user cli input
			while(scan.hasNext()){
				out.writeUTF(scan.nextLine());
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}