package hotelroommanager.hotel;

import java.io.*;
import java.util.*;

/**
  * @class: Hotel
  *
  * A model class meant to represent a
  * single hotel. This will be searialized
  * to disk
  *
  */

public class Hotel implements Serializable
{
	private int id;
	private String name;
	private Month calendar;
  private ArrayList<Guest> guests;


/**
  * Class Constructor
  *
  * @param  passedId:  			hotel ID to allow for differentiation between chain hotels (i.e. two Hiltons)
  * @param  passedName:  		user friendly hotel name
  * @param  passedTotalRooms: 	total rooms in the hotel
  * @param  passedCalendar:  		a month variable holding all dates for the hotel
  * @see    Hotel
  */
	public Hotel(int passedId, String passedName, Month passedCalendar, ArrayList<Guest> passedGuests){
		this.id = passedId;
		this.name = passedName;
		this.calendar = passedCalendar;
    this.guests = passedGuests;
	}

/**
  * Accessor
  *
  *		Gets the id of the current hotel
  *
  * @return this.id
  * @see    getId
  */
	public int getId(){
		return this.id;
	}

/**
  * Accessor
  *
  *		Gets the name of the current hotel
  *
  * @return this.name
  * @see    getName
  */
	public String getName(){
		return this.name;
	}

/**
  * Accessor
  *
  *		Gets the total number of rooms of the current hotel
  *
  * @return this.rooms.size()
  * @see    getTotalRooms
  */
  /*
	public int getTotalRooms(){
		return this.rooms.size();
	}*/

/**
  * Accessor
  *
  *		Gets the calendar of the current hotel
  *
  * @return this.calendar
  * @see    getCalendar
  */
	public Month getCalendar(){
		return this.calendar;
	}

/**
  * Accessor
  *
  *   Gets an array list of all guests of the current hotel
  *
  * @return this.guests
  * @see    getGuests
  */
  public ArrayList<Guest> getGuests(){
    return this.guests;
  }
}