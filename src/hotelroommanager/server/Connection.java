package hotelroommanager.server;

import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import hotelroommanager.hotel.*;

/**
  * @class: Connection
  *
  * A class to handle the functionality of a connection with
  * a single client. Called as a thread from ReservationServer 
  *
  */
public class Connection extends Thread
{
	ReservationServer server;
	Socket client;

/**
  * Class: Constructor
  *
  * @param  passedClient:  the client who requested a connection to the server
  * @param  passedServer:  the server who called this thread
  * @see    Connection
  */
	public Connection(ReservationServer passedServer, Socket passedClient){
		this.server = passedServer;
		this.client = passedClient;
	}

/**
  * Thread Execution
  *
  * 	attempt to create a connection with a requesting client
  *		via a stream given by the server
  *
  * @see    run
  */
	public void run(){
		try{
			//set up an input stream from the client
			DataInputStream clientInputStream = new DataInputStream(this.client.getInputStream());

			//process a message from the client
			while (!(this.client.getRemoteSocketAddress().equals(null))){ //while the connection is valid
				//message retrieved from the client channel
				String curMsg = "";

				//try to read the client's message
				try{
					curMsg = clientInputStream.readUTF();
					System.out.println(curMsg);

					//Client Command
					//displays all rooms to the client
					if (curMsg.equals("/displayrooms")){
						Hotel hotel = null;
						try{
							//desearialize the hotel

							FileInputStream fileIn = new FileInputStream("/Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser");
							ObjectInputStream serializedIn = new ObjectInputStream(fileIn);
							hotel = (Hotel) serializedIn.readObject();

							//create an output stream to the client
							//sends a Hotel object
							ObjectOutputStream out = new ObjectOutputStream(this.client.getOutputStream());
							out.writeObject(hotel);

							//clean up
							serializedIn.close();
							fileIn.close();
						}catch(ClassNotFoundException c){
							System.out.println("Hotel class not found");
							c.printStackTrace();
							return;
						}
					}

				//Client Command
				//builds a guest based off of the passed information
				//Signifier:	/buildguest
				//param 1:		first name
				//param 2:		last name
				//param 3:		phone
				//param 4:		email
					else if(curMsg.length() > 5 && curMsg.substring(0, 11).equals("/buildguest")){
						Hotel hotel = null;

						//split up the sent string to get all pieces of data
						String[] splitMsg = curMsg.split(" ");

						//ensure there are only four elements
						if (splitMsg.length == 5){

							Guest passedGuest = new Guest(splitMsg[1],splitMsg[2],splitMsg[3],splitMsg[4]);

							//try to input the updated data and searialize the hotel object
							try{
								FileInputStream fileIn = new FileInputStream("/Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser");
								ObjectInputStream serializedIn = new ObjectInputStream(fileIn);
								hotel = (Hotel) serializedIn.readObject();

								ArrayList<HotelRoom> rooms = hotel.getRooms();
								boolean guestExists = false;
								for (Guest curGuest : hotel.getGuests()){
									if (curGuest.equals(passedGuest)){
										guestExists = true;
									}
								}
								if(!guestExists){
									hotel.getGuests().add(passedGuest);
								}else{
									System.out.println("Guest already exists");
								}

								FileOutputStream fileOut = new FileOutputStream("/Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser");
								ObjectOutputStream out = new ObjectOutputStream(fileOut);
								out.writeObject(hotel);
								out.close();
								fileOut.close();
								System.out.printf("Serialized data is saved in /Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser\n");
							}catch(ClassNotFoundException c){
								System.out.println("Hotel class not found");
								c.printStackTrace();
								return;
							}catch(IOException i){
								i.printStackTrace();
							}catch(NumberFormatException e){
								System.out.println("Number format exception. Try again");
							}
						}
					}
				
				//Client Command
				//sets the availibility property of a hotel room
				//Signifier:	/toggleroomstate
				//param 1:		Room Number
				//param 2:		true or false (for isAvailable)
					else if(curMsg.length() > 6 && curMsg.substring(0, 16).equals("/toggleroomstate")){
						Hotel hotel = null;

						//split up the sent string to get all pieces of data
						String[] splitMsg = curMsg.split(" ");

						//ensure there are only four elements
						if (splitMsg.length == 4){
							//try to input the updated data and searialize the hotel object
							try{
								FileInputStream fileIn = new FileInputStream("/Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser");
								ObjectInputStream serializedIn = new ObjectInputStream(fileIn);
								hotel = (Hotel) serializedIn.readObject();

								ArrayList<HotelRoom> rooms = hotel.getRooms();
								for (HotelRoom curRoom : rooms){
									if (curRoom.getRoomNumber() == Integer.parseInt(splitMsg[1])){
										curRoom.updateAvailability(Boolean.parseBoolean(splitMsg[2]));
										for(Guest curGuest: hotel.getGuests()){
											if (curGuest.getEmail().equals(splitMsg[3])){
												curRoom.updateGuest(curGuest);//updates guest based off of email
												System.out.println("added a guest");
											}
										}
									}
								}

								FileOutputStream fileOut = new FileOutputStream("/Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser");
								ObjectOutputStream out = new ObjectOutputStream(fileOut);
								out.writeObject(hotel);
								out.close();
								fileOut.close();
								System.out.printf("Serialized data is saved in /Users/unkn0wn/Github/411-HotelRoomManager/bin/hotelroommanager/hotel/hilton.ser\n");
							}catch(ClassNotFoundException c){
								System.out.println("Hotel class not found");
								c.printStackTrace();
								return;
							}catch(IOException i){
								i.printStackTrace();
							}catch(NumberFormatException e){
								System.out.println("Number format exception. Try again");
							}
						}else{
						System.out.println("split msg length: "+splitMsg.length);
						}
					}
				}catch(IOException i){
					i.printStackTrace();
					return;
				}
			}
			this.client.close();
		}catch (SocketTimeoutException s){
			System.out.println("Socket timed out!");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}