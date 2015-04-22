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
	private ArrayList<HotelRoom> rooms;


/**
  * Class Constructor
  *
  * @param  passedId:  			hotel ID to allow for differentiation between chain hotels (i.e. two Hiltons)
  * @param  passedName:  		user friendly hotel name
  * @param  passedTotalRooms: 	total rooms in the hotel
  * @param  passedRooms:  		array list of all HotelRooms
  * @see    Hotel
  */
	public Hotel(int passedId, String passedName, ArrayList<HotelRoom> passedRooms){
		this.id = passedId;
		this.name = passedName;
		this.rooms = passedRooms;
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
	public int getTotalRooms(){
		return this.rooms.size();
	}

/**
  * Accessor
  *
  *		Gets an array list of all rooms of the current hotel
  *
  * @return this.rooms
  * @see    getRooms
  */
	public ArrayList<HotelRoom> getRooms(){
		return this.rooms;
	}
}