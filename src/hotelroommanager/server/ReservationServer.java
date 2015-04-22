package hotelroommanager.server;

import java.net.*;
import java.io.*;
import java.util.*;

/**
  * @class: ReservationServer
  *
  * A class meant to initialize a reservation server
  * for the user
  *
  * Contains Main
  *
  */
public class ReservationServer extends Thread
{
	ServerSocket serverSocket;

/**
  * Class: Constructor
  *
  * @param  port:  the port that the server will listen on
  * @see    ReservationServer
  */
	public ReservationServer(int port) throws IOException{
		serverSocket = new ServerSocket(port);
	}

/**
  * Thread Execution
  *
  * 	attempt to accept a reqquest to connect by a client
  *
  * @see    run
  */
	public void run()
	{
		while (true){
			try{
				//wait for a client to connect. BLOCKS
				System.out.println("Waiting for reservation client on port " + serverSocket.getLocalPort() + "...");
				Socket client = serverSocket.accept();

				//print confirmation of a connection
				System.out.println("Just Connected to " + client.getRemoteSocketAddress());
				
				//Set up a connection thread for the new client
				Thread newConnection = new Connection(this, client);
				newConnection.start();
			}catch (SocketTimeoutException s){
				System.out.println("Socket timed out!");
				break;
			}catch (IOException e){
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		//port to listen on
		int port = Integer.parseInt(args[0]);

		//try to start a thread with the server
		try{
			Thread t = new ReservationServer(port);
			t.start();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}