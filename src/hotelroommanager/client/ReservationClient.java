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
		String setServerName = args[0];

		//expects a non-reserved port
		int setPort = Integer.parseInt(args[1]);

		LoadingCntl loadingCntl = new LoadingCntl();

		attemptConnection(setServerName, setPort, loadingCntl);
	}

	public static void attemptConnection(String serverName, int port, LoadingCntl passedLoadingCntl){
		//Socket to connect with the server
		Socket potentialClient = null;

		try{
			passedLoadingCntl.showLoadingUI();
			//create connection to server
			System.out.println("Connecting to " + serverName + " on port " + port);
			potentialClient = new Socket(serverName, port);
			System.out.println("Just connected to " + potentialClient.getRemoteSocketAddress());
			passedLoadingCntl.closeLoadingUI();
			beginReservation(potentialClient);
		} catch(IOException e){
			System.out.println("Error creating socket. Trying again...");
			attemptConnection(serverName, port, passedLoadingCntl);
		}
	}

	public static void beginReservation(Socket client){
		ReservationParamsCntl rpc = new ReservationParamsCntl(client);
	}
}