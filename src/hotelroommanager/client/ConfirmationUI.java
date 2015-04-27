package hotelroommanager.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import hotelroommanager.hotel.*;

public class ConfirmationUI extends JFrame
{
	BookingCntl theBookingCntl;
	HotelRoom roomToBook;

	JPanel mainPanel;
	JLabel confirmationLabel;



	public ConfirmationUI(BookingCntl passedCntl){
		this.theBookingCntl = passedCntl;
		this.roomToBook = this.theBookingCntl.getRoomToBook();
		this.initComponents();
		this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setTitle("Booking Confirmation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	public void initComponents(){
		this.mainPanel = new JPanel(new BorderLayout());

		String roomNumber = String.valueOf(this.roomToBook.getRoomNumber());
		String labeltext = "Your Reservation for "+roomNumber+" for [CHECK IN DATE] to [CHECK OUT DATE] was Successful";

		this.confirmationLabel = new JLabel(labeltext);

		this.mainPanel.add(this.confirmationLabel);
		this.add(this.mainPanel);
	}

	//listener for the booking button button
    public class BookingListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
        	
        }
    }
}