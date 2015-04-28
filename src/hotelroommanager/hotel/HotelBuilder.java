package hotelroommanager.hotel;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;


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

		ArrayList<Guest> hiltonGuests = new ArrayList<Guest>();
		try{
			ArrayList<Day> hiltonDays = new ArrayList<Day>();

			for (int i = 0; i< 30; i++){

				ArrayList<HotelRoom> hiltonRooms = new ArrayList<HotelRoom>();

				for (int j = 0; j< 20; j++){
					hiltonRooms.add(new HotelRoom(100+j, 100*(j%3), 2+j%3, j%3, j%3));//Syntax: [0] = room number, [1] = numQueen, [2] = numDouble
				}
				String datestring;
				if(i < 10){
					datestring = "04/"+String.valueOf(i)+"/2015";
				}else{
					datestring = "04/"+String.valueOf(i)+"/2015";
				}
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date hotelDate = df.parse(datestring);
				hiltonDays.add(new Day(i+1, hotelDate, hiltonRooms));
			}


			Month hiltonMonth = new Month(4, hiltonDays);

			//Build the hotel object
			Hotel hilton = new Hotel(0, "Hilton", hiltonMonth, hiltonGuests);

			//Serialize the hotel object

			FileOutputStream fileOut = new FileOutputStream("hotelroommanager/hotel/hilton.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(hilton);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in hotelroommanager/hotel/hilton.ser\n");
		}catch(ParseException i){
			i.printStackTrace();
		}catch(IOException i){
			i.printStackTrace();
		}
	}
}