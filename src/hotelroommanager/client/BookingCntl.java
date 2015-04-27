package hotelroommanager.client;

import java.lang.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;
import hotelroommanager.hotel.*;

public class BookingCntl
{
	BookingUI bookingUI;
	ConfirmationUI confirmationUI;
	RoomResultsCntl roomResultsCntl;
	int roomToBook;

	public BookingCntl(RoomResultsCntl passedCntl, int passedRoom){
		this.roomResultsCntl = passedCntl;
		this.roomToBook = passedRoom;
		showBookingUI();
	}

	public void showBookingUI(){
		if (this.bookingUI == null){
			this.bookingUI = new BookingUI(this);
		}else{
			this.bookingUI.setVisible(true);
		}
	}

	public void showConfirmationUI(){
		if (this.confirmationUI == null){
			this.confirmationUI = new ConfirmationUI(this);
		}else{
			this.confirmationUI.setVisible(true);
		}
	}

	public HotelRoom getRoomToBook(){
		ArrayList<HotelRoom> curRooms = this.roomResultsCntl.getRoomResults();
		HotelRoom desiredRoom = null;
		for (HotelRoom room: curRooms){
			if (room.getRoomNumber() == roomToBook){
				desiredRoom = room;
			}
		}
		return desiredRoom;
	}

	public void startBooking(String fname, String lname, String phone, String email){
		this.roomResultsCntl.bookRoom(roomToBook, fname, lname, phone, email);
	}
}