package hotelroommanager.client;

import java.util.*;
import java.text.*;
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

		boolean roomStillAvailable = true;
		for(Day curDay : hotel.getCalendar().getDays()){
			if ((curDay.getDate().after(inDate) && curDay.getDate().before(outDate)) || curDay.getDate().equals(inDate) || curDay.getDate().equals(outDate)){
				
			String curdatestr = new SimpleDateFormat("MM/dd/yyyy").format(curDay.getDate());
			System.out.println("Cur day num: "+curdatestr);
				ArrayList<HotelRoom> rooms = curDay.getRooms();
				for (HotelRoom room : rooms){
					if (room.roomIsAvailable() && room.getNumQueenBeds() >= this.numQueen && room.getNumDoubleBeds() >= this.numDouble){
						availableRooms.add(room);
					}
				}
			}
		}
		return availableRooms;
	}

	public ReservationParamsCntl getReservationParamsCntl(){
		return this.theReservationParamsCntl;
	}

	public void showRoomResultsUI(){
		this.roomResultsUI = new RoomResultsUI(this);
	}

	public void runBookingCntl(int roomToBook){
		this.theBookingCntl = new BookingCntl(this, roomToBook);
	}

	public void bookRoom(int roomToBook, String fname, String lname, String phone, String email){
		this.theReservationParamsCntl.bookRoom(roomToBook, fname, lname, phone, email);
	}
}