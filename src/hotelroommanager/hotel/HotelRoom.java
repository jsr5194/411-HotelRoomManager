package hotelroommanager.hotel;

import java.io.*;

/**
  * @class: HotelRoom
  *
  * A model class meant to represent a
  * single hotel. 
  *
  */
public class HotelRoom implements Serializable
{
	private int roomNumber;
	private int numQueenBeds;
	private int numDoubleBeds;
	private boolean isAvailable;
	private int occupantId;

/**
  * Class Constructor
  *
  * @param  passedRoomNumber:  	room number for this hotel room
  * @param  passedNumQ:  		number of queen beds contained
  * @param  passedNumD: 		number of double beds contained
  * @see    HotelRoom
  */
	public HotelRoom(int passedRoomNumber, int passedNumQ, int passedNumD){
		this.roomNumber = passedRoomNumber;
		this.numQueenBeds = passedNumQ;
		this.numDoubleBeds = passedNumD;
		this.isAvailable = true; //initially occupied
		this.occupantId = -1; //-1 means no occupant
	}

/**
  * Accessor
  *
  *		Gets the room number of the current room
  *
  * @return this.roomNumber
  * @see    getRoomNumber
  */
	public int getRoomNumber(){
		return this.roomNumber;
	}

/**
  * Accessor
  *
  *		Gets the number of queen beds in the current room
  *
  * @return this.numQueenBeds
  * @see    getNumQueenBeds
  */
	public int getNumQueenBeds(){
		return this.numQueenBeds;
	}

/**
  * Accessor
  *
  *		Gets the number of double beds in the current room
  *
  * @return this.numDoubleBeds
  * @see    getNumDoubleBeds
  */
	public int getNumDoubleBeds(){
		return this.numDoubleBeds;
	}

/**
  * Accessor
  *
  *		Gets a boolean representing the current room's availability
  *		true	==	available
  *		false	==	occupied
  *
  * @return this.isAvailable
  * @see    roomIsAvailable
  */
	public boolean roomIsAvailable(){
		return this.isAvailable;
	}

/**
  * Accessor
  *
  *		Gets a the id of the current room's occupant.
  *		If the room is empty, this value will be -1
  *
  * @return this.occupantId
  * @see    getOccupantId
  */
	public int getOccupantId(){
		return this.occupantId;
	}

/**
  * Mutator
  *
  *		updates the availability of a given room
  *
  * @param  newAvailable	a boolean specifying the new availabilty state of the current room
  * @see    updateAvailability
  */
	public void updateAvailability(boolean newAvailable){
		this.isAvailable = newAvailable;
	}

/**
  * Mutator
  *
  *		updates the availability of a given room
  *
  * @param  newId	an int specifying the new occupant's id for the current room
  * @see    updateOccupantId
  */
	public void updateOccupantId(int newId){
		this.occupantId = newId;
	}
}