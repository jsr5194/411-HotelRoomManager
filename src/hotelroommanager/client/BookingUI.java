package hotelroommanager.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import hotelroommanager.hotel.*;

public class BookingUI extends JFrame
{
	BookingCntl theBookingCntl;
	HotelRoom roomToBook;

	JPanel mainPanel;
	JPanel buttonsPanel;
	JPanel informationPanel;

	JLabel titleLabel;
	JButton confirmButton;
	JButton backButton;

	JLabel roomTitle;
	JLabel roomNumber;
	JLabel roomPrice;
	JLabel roomOccupants;
	JLabel roomQueens;
	JLabel roomDoubles;

	JLabel guestTitle;
	JPanel fnamePanel;
	JLabel guestFnameLabel;
	JTextField guestFnameField;
	JPanel lnamePanel;
	JLabel guestLnameLabel;
	JTextField guestLnameField;
	JPanel phonePanel;
	JLabel guestPhoneLabel;
	JTextField guestPhoneField;
	JPanel emailPanel;
	JLabel guestEmailLabel;
	JTextField guestEmailField;



	public BookingUI(BookingCntl passedCntl){
		this.theBookingCntl = passedCntl;
		this.roomToBook = this.theBookingCntl.getRoomToBook();
		this.initComponents();
		this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setTitle("Booking Booking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	public void initComponents(){
		this.mainPanel = new JPanel(new BorderLayout());
		this.buttonsPanel = new JPanel();
		this.informationPanel = new JPanel(new GridLayout(6, 2));
		this.fnamePanel = new JPanel();
		this.lnamePanel = new JPanel();
		this.phonePanel = new JPanel();
		this.emailPanel = new JPanel();

		this.roomTitle = new JLabel("Room Information", SwingConstants.CENTER);
		this.roomTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		this.roomNumber = new JLabel("Room Number: "+String.valueOf(this.roomToBook.getRoomNumber()), SwingConstants.CENTER);
		this.roomPrice = new JLabel("Price per night: $"+String.valueOf(this.roomToBook.getPrice()), SwingConstants.CENTER);
		this.roomOccupants = new JLabel("Max Occupants: "+String.valueOf(this.roomToBook.getMaxOccupants()), SwingConstants.CENTER);
		this.roomQueens = new JLabel("Queen Beds: "+String.valueOf(this.roomToBook.getNumQueenBeds()), SwingConstants.CENTER);
		this.roomDoubles = new JLabel("Double Beds: "+String.valueOf(this.roomToBook.getNumDoubleBeds()), SwingConstants.CENTER);

		this.guestTitle = new JLabel("Customer Information", SwingConstants.CENTER);
		this.guestTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		this.guestFnameLabel = new JLabel("First Name: ");
		this.guestFnameField = new JTextField(10);
		this.guestLnameLabel = new JLabel("Last Name: ");
		this.guestLnameField = new JTextField(10);
		this.guestPhoneLabel = new JLabel("Phone Number: ");
		this.guestPhoneField = new JTextField(10);
		this.guestEmailLabel = new JLabel("E-mail address: ");
		this.guestEmailField = new JTextField(10);

		this.titleLabel = new JLabel("Reservation Booking", SwingConstants.CENTER);
		this.titleLabel.setFont(new Font("Arial", Font.PLAIN, 50));

		this.confirmButton = new JButton("Confirm Booking");
		this.confirmButton.addActionListener(new BookingListener());

		this.backButton = new JButton("Back");
		this.backButton.addActionListener(new BackButtonListener());

		this.fnamePanel.add(this.guestFnameLabel);
		this.fnamePanel.add(this.guestFnameField);
		this.lnamePanel.add(this.guestLnameLabel);
		this.lnamePanel.add(this.guestLnameField);
		this.phonePanel.add(this.guestPhoneLabel);
		this.phonePanel.add(this.guestPhoneField);
		this.emailPanel.add(this.guestEmailLabel);
		this.emailPanel.add(this.guestEmailField);

		this.informationPanel.add(this.roomTitle);
		this.informationPanel.add(this.guestTitle);
		this.informationPanel.add(this.roomNumber);
		this.informationPanel.add(this.fnamePanel);
		this.informationPanel.add(this.roomPrice);
		this.informationPanel.add(this.lnamePanel);
		this.informationPanel.add(this.roomOccupants);
		this.informationPanel.add(this.phonePanel);
		this.informationPanel.add(this.roomQueens);
		this.informationPanel.add(this.emailPanel);
		this.informationPanel.add(this.roomDoubles);
		this.buttonsPanel.add(this.backButton);
		this.buttonsPanel.add(this.confirmButton);
		this.mainPanel.add(this.titleLabel, BorderLayout.NORTH);
		this.mainPanel.add(this.informationPanel, BorderLayout.CENTER);
		this.mainPanel.add(this.buttonsPanel, BorderLayout.SOUTH);
		this.add(this.mainPanel);
	}

	//listener for the booking button button
    public class BookingListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
        	String fname = BookingUI.this.guestFnameField.getText();
        	String lname = BookingUI.this.guestLnameField.getText();
        	String phone = BookingUI.this.guestPhoneField.getText();
        	String email = BookingUI.this.guestEmailField.getText();

        	BookingUI.this.theBookingCntl.startBooking(fname, lname, phone, email);
        	BookingUI.this.setVisible(false);
        	BookingUI.this.theBookingCntl.showConfirmationUI();
        }
    }

    //listener for the back button
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
        	BookingUI.this.setVisible(false);
        	BookingUI.this.theBookingCntl.getRoomResultsCntl().showRoomResultsUI();
        }
    }
}