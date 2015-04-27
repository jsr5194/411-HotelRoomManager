package hotelroommanager.client;

import java.lang.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;
import hotelroommanager.hotel.*;

public class ReservationParamsCntl
{
	ReservationParamsUI reservationsParamsUI;
	RoomResultsCntl roomResultsCntl;
	Hotel hotel = null;
	Date inDate = null;
	Date outDate = null;
	int numOccupants;
	int numQueen;
	int numDouble;
	Socket client;
	Thread msgAcceptance;

	public ReservationParamsCntl(Socket passedClient){
		this.client = passedClient;
		//start thread to accept any incoming messages from the server
		this.msgAcceptance = new InboundMsg(this.client, this);
		this.msgAcceptance.start();

		showReservationParamsUI();
	}

	public void setHotel(Hotel passedHotel){
		this.hotel = passedHotel;
	}

	public void runRoomResultsCntl(){
		if(this.roomResultsCntl == null){
			this.roomResultsCntl = new RoomResultsCntl(this, this.hotel, this.inDate, this.outDate, this.numOccupants, this.numQueen, this.numDouble);
		}else{
			this.roomResultsCntl.showRoomResultsUI();
		}
	}

	public void showReservationParamsUI(){
		if (this.reservationsParamsUI == null){
			this.reservationsParamsUI = new ReservationParamsUI(this);
		}else{
			this.reservationsParamsUI.setVisible(true);
		}
	}

	public void runRoomSearch(String passedInDate, String passedOutDate, String passedNumOccupants, String passedNumQueen, String passedNumDouble){

		this.reservationsParamsUI.setVisible(false);

		try{
			//set up output stream
			OutputStream outToServer = this.client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("/displayrooms");

			while(this.hotel == null){
				System.out.print(this.hotel);
			}

			DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			this.inDate = format.parse(passedInDate);
			this.outDate = format.parse(passedOutDate);
			this.numOccupants = Integer.parseInt(passedNumOccupants);
			this.numQueen = Integer.parseInt(passedNumQueen);
			this.numDouble = Integer.parseInt(passedNumDouble);
			runRoomResultsCntl();
		}catch(ParseException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void bookRoom(int roomNumber, String fname, String lname, String phone, String email){
		try{
			//set up output stream
			OutputStream outToServer = this.client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("/buildguest "+fname+" "+lname+" "+phone+" "+email);//TODO: YOU STILL NEED TO DO THIS
			out.writeUTF("/toggleroomstate "+String.valueOf(roomNumber)+" false "+ email);
			out.writeUTF("/displayrooms");
			//DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			//runRoomSearch(format.format(this.inDate), format.format(this.outDate), String.valueOf(this.numOccupants), String.valueOf(this.numQueen), String.valueOf(this.numDouble));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}