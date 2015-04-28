package hotelroommanager.hotel;

import java.util.*;
import java.io.*;

public class Month implements Serializable
{
	private int monthNum;
	private ArrayList<Day> days;
	
	public Month(int passedMonthNum, ArrayList<Day> passedDays){
		this.monthNum = passedMonthNum;
		this.days = passedDays;
	}
	
	public int getMonthNum(){
		return this.monthNum;
	}
	
	public ArrayList<Day> getDays(){
		return this.days;
	}
}