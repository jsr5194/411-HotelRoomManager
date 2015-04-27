package hotelroommanager.client;

import java.util.*;
import hotelroommanager.hotel.*;

public class RoomResultsCntl
{
	ReservationParamsCntl theReservationParamsCntl;
	BookingCntl theBookingCntl;
	RoomResultsUI roomResultsUI;


	private Date inDate;
	private Date outDate;
	private int numOccupants;
	private int numQueen;
	private int numDouble;
	private Hotel hotel;

	public RoomResultsCntl(ReservationParamsCntl passedCntl, Hotel passedHotel, Date passedInDate, Date passedOutDate, int passedNumOccupants, int passedNumQueen, int passedNumDouble){
		this.theReservationParamsCntl = passedCntl;
		this.hotel = passedHotel;
		this.inDate = passedInDate;
		this.outDate = passedOutDate;
		this.numOccupants = passedNumOccupants;
		this.numQueen = passedNumQueen;
		this.numDouble = passedNumDouble;
		getRoomResults();
		showRoomResultsUI();
	}

	public ArrayList<HotelRoom> getRoomResults(){
		ArrayList<HotelRoom> availableRooms = new ArrayList<HotelRoom>();
		ArrayList<HotelRoom> rooms = hotel.getRooms();
		for (HotelRoom room : rooms){
			if (room.roomIsAvailable() && room.getNumQueenBeds() >= this.numQueen && room.getNumDoubleBeds() >= this.numDouble){
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}

	public void showRoomResultsUI(){
		if (this.roomResultsUI == null){
			this.roomResultsUI = new RoomResultsUI(this);
		}else{
			this.roomResultsUI.setVisible(true);
		}
	}

	public void runBookingCntl(int roomToBook){
		if(this.theBookingCntl == null){
			this.theBookingCntl = new BookingCntl(this, roomToBook);
		}else{
			this.theBookingCntl.showBookingUI();
		}
	}

	public void bookRoom(int roomToBook, String fname, String lname, String phone, String email){
		this.theReservationParamsCntl.bookRoom(roomToBook, fname, lname, phone, email);
	}
}