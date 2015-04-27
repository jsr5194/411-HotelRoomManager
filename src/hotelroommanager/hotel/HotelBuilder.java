package hotelroommanager.hotel;

import java.io.*;
import java.util.*;

/**
  * @class: HotelBuilder
  *
  * A class meant to build and serialize 
  * a test hotel. Hotel being used for
  * the example is a hilton
  *
  * Contains Main
  *
  */
public class HotelBuilder
{

	public static void main(String[] args){
		//container for all rooms in the hotel
		ArrayList<HotelRoom> hiltonRooms = new ArrayList<HotelRoom>();
		ArrayList<Guest> hiltonGuests = new ArrayList<Guest>();

		for (int i = 0; i< 20; i++){
			hiltonRooms.add(new HotelRoom(100+i, 100*(i%3), 2+i%3, i%3, i%3));//Syntax: [0] = room number, [1] = numQueen, [2] = numDouble
		}

		//Build the hotel object
		Hotel hilton = new Hotel(0, "Hilton", hiltonRooms, hiltonGuests);

		//Serialize the hotel object
		try{
			FileOutputStream fileOut = new FileOutputStream("hotelroommanager/hotel/hilton.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(hilton);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in hotelroommanager/hotel/hilton.ser\n");
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}