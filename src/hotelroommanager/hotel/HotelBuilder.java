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

		//Build four test rooms
		HotelRoom room100 = new HotelRoom(100, 2, 0); //Syntax: [0] = room number, [1] = numQueen, [2] = numDouble
		hiltonRooms.add(room100);

		HotelRoom room101 = new HotelRoom(101, 1, 1);
		hiltonRooms.add(room101);

		HotelRoom room102 = new HotelRoom(102, 0, 2);
		hiltonRooms.add(room102);

		HotelRoom room103 = new HotelRoom(103, 1, 0);
		hiltonRooms.add(room103);

		//Build the hotel object
		Hotel hilton = new Hotel(0, "Hilton", hiltonRooms);

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