package hotelroommanager.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import hotelroommanager.hotel.*;

public class RoomResultsUI extends JFrame
{
	RoomResultsCntl theRoomResultsCntl;
	ArrayList<HotelRoom> rooms;
	JPanel containerPanel;
	JScrollPane scrollPane;
	JPanel mainPanel;
	JButton backButton;


	public RoomResultsUI(RoomResultsCntl passedCntl){
		this.theRoomResultsCntl = passedCntl;
		this.rooms = this.theRoomResultsCntl.getRoomResults();
		this.initComponents();
		this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setTitle("Room Results");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	public void initComponents(){
		this.containerPanel = new JPanel(new BorderLayout());
		this.mainPanel = new JPanel(new GridLayout(this.rooms.size()/3+1, 3, 10, 10));

		if (this.rooms.size() > 0){
			for(HotelRoom room : rooms){
				JPanel hotelPanel = new JPanel(new GridLayout(6, 1));
				hotelPanel.setPreferredSize(new Dimension(80, 150));
				hotelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

				JLabel roomNumber = new JLabel("Room "+String.valueOf(room.getRoomNumber()), SwingConstants.CENTER);
				JLabel price = new JLabel("Price per night: $"+String.valueOf(room.getPrice()));
				JLabel maxOccupants = new JLabel("Maximum Occupants: "+String.valueOf(room.getMaxOccupants()));
				JLabel numQ = new JLabel("Queen Beds: "+String.valueOf(room.getNumQueenBeds()));
				JLabel numD = new JLabel("Double Beds:  "+String.valueOf(room.getNumDoubleBeds()));
				JButton bookButton = new JButton("Book Now");
				bookButton.addActionListener(new BookingListener(room.getRoomNumber()));
				hotelPanel.add(roomNumber);
				hotelPanel.add(price);
				hotelPanel.add(maxOccupants);
				hotelPanel.add(numQ);
				hotelPanel.add(numD);
				hotelPanel.add(bookButton);
				this.mainPanel.add(hotelPanel);
			}
		}else{
			this.mainPanel.add(new JLabel("No Results Found"));
		}
		this.backButton = new JButton("Back");
		this.backButton.addActionListener(new BackButtonListener());
		this.scrollPane = new JScrollPane(this.mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.containerPanel.add(this.backButton, BorderLayout.NORTH);
		this.containerPanel.add(this.scrollPane, BorderLayout.CENTER);
		this.add(this.containerPanel);
	}


	//listener for the doubleUp button
    public class BookingListener implements ActionListener{
    	int roomToBook;
    	public BookingListener(int passedRoomToBook){
    		this.roomToBook = passedRoomToBook;
    	}
        public void actionPerformed(ActionEvent evt){
        	RoomResultsUI.this.theRoomResultsCntl.runBookingCntl(this.roomToBook);
        	RoomResultsUI.this.setVisible(false);
        }
    }

    //listener for the back button
    public class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
        	RoomResultsUI.this.setVisible(false);
        	RoomResultsUI.this.theRoomResultsCntl.getReservationParamsCntl().showReservationParamsUI();
        }
    }

}