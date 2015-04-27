package hotelroommanager.hotel;

import java.io.*;

public class Guest implements Serializable
{
	private String fname;
	private String lname;
	private String phone;
	private String email;
	public Guest(String passedFname, String passedLname, String passedPhone, String passedEmail){
		this.fname = passedFname;
		this.lname = passedLname;
		this.phone = passedPhone;
		this.email = passedEmail;
	}

	public String getFname(){
		return this.fname;
	}

	public String getEmail(){
		return this.email;
	}
}