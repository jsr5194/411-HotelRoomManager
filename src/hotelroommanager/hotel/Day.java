package hotelroommanager.hotel;

import java.util.*;
import java.io.*;

public class Day implements Serializable
{
	private int dayNum;
	private Date date;
	private ArrayList<HotelRoom> rooms;
	
	public Day(int passedDayNum, Date passedDate, ArrayList<HotelRoom> passedRooms){
		this.dayNum = passedDayNum;
		this.date = passedDate;
		this.rooms = passedRooms;
	}
	
	public int getDayNum(){
		return this.dayNum;
	}

	public Date getDate(){
		return this.date;
	}
	
	public ArrayList<HotelRoom> getRooms(){
		return this.rooms;
	}
}