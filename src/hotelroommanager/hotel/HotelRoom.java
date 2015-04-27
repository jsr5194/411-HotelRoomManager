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
  private int price;
  private int maxOccupants;
	private int numQueenBeds;
	private int numDoubleBeds;
	private boolean isAvailable;
  private Guest guest;

/**
  * Class Constructor
  *
  * @param  passedRoomNumber:  	 room number for this hotel room
  * @param  passedPrice:         nightly cost for the room
  * @param  passedMaxOccupants:  maximum number of occupants for the room
  * @param  passedNumQ:  		     number of queen beds contained
  * @param  passedNumD: 		     number of double beds contained
  * @see    HotelRoom
  */
	public HotelRoom(int passedRoomNumber, int passedPrice, int passedMaxOccupants, int passedNumQ, int passedNumD){
		this.roomNumber = passedRoomNumber;
    this.price = passedPrice;
    this.maxOccupants = passedMaxOccupants;
		this.numQueenBeds = passedNumQ;
		this.numDoubleBeds = passedNumD;
		this.isAvailable = true; //initially occupied
    this.guest = null;
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
  *   Gets a the price per night that
  *   this room costs
  *
  * @return this.price
  * @see    getPrice
  */
  public int getPrice(){
    return this.price;
  }

/**
  * Accessor
  *
  *   Gets a the total number of occupants that
  *   this room can support
  *
  * @return this.maxOccupants
  * @see    getMaxOccupants
  */
  public int getMaxOccupants(){
    return this.maxOccupants;
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
  *   Gets the guest object for the current room
  *
  * @return this.guest
  * @see    getGuest
  */
  public Guest getGuest(){
    return this.guest;
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
  *   updates the guest of a given room
  *
  * @param  curGuest    a Guest object containing information on the person in the room
  * @see    updateGuest
  */
  public void updateGuest(Guest curGuest){
    this.guest = curGuest;
  }
}