package hotelroommanager.client;

import java.net.*;
import java.io.*;
import java.util.*;
import hotelroommanager.hotel.*;

/**
  * Class: InboundMsg
  *
  * A class meant to be called as a thread in order to handle acceptance
  * of messages from the server without interrupting the user's typing
  *
  * Called from ReservationClient
  *
  */

public class InboundMsg extends Thread
{
	//handle back to the client who created this thread
	private Socket client;
	private ReservationParamsCntl rpc;


/**
  * Class: Constructor
  *
  * @param  passedClient:  the client who called this thread
  * @see    InboundMsg
  */
	public InboundMsg(Socket passedClient, ReservationParamsCntl passedRpc){
		this.client = passedClient;
		this.rpc = passedRpc;
	}


/**
  * Thread Execution
  *
  * 	attempt to accept a message through the input 
  *		stream given by the client
  *
  * @see    run
  */
	public void run(){
		try{
			//client input stream
			InputStream serverInputStream = this.client.getInputStream();
			while (true){
				try{
					//input stream for the hotel object to be accepted
					ObjectInputStream  objectInputStream  = new ObjectInputStream(serverInputStream);
					try{
						//get the passed hotel object
						Hotel hotel = (Hotel)objectInputStream.readObject();

						//print out the current state of each hotel room
						for (int i = 0; i < hotel.getRooms().size(); i++){
							HotelRoom currentRoom = hotel.getRooms().get(i);

							String currentState;
							if (currentRoom.roomIsAvailable()){
								currentState = "Available";
							}else{
								currentState = "Occupied";
							}

							//System.out.println("First room: "+currentRoom.getRoomNumber()+" State: "+currentState);

						}
						this.rpc.setHotel(hotel);
					}catch (EOFException e){
						objectInputStream.close();
					}
				}catch (EOFException e){
					continue;
				}
			}
		}catch (SocketTimeoutException s){
			System.out.println("Socket timed out!");
		}catch (ClassNotFoundException e){
			System.out.println("Class Not Found!");
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}