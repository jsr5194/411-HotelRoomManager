package hotelroommanager.client;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class ReservationParamsUI extends JFrame
{
	ReservationParamsCntl theReservationsParamsCntl;
	JLabel titleLabel;
	JLabel checkInLabel;
	JDatePickerImpl checkInPicker;
	JLabel checkOutLabel;
	JDatePickerImpl checkOutPicker;
	JLabel occupantsLabel;
	JButton occupantsDown;
	JLabel occupantsNum;
	JButton occupantsUp;
	JLabel queensLabel;
	JButton queensDown;
	JLabel queensNum;
	JButton queensUp;
	JLabel doubleLabel;
	JButton doubleDown;
	JLabel doubleNum;
	JButton doubleUp;

	JPanel checkInPanel;
	JPanel checkOutPanel;
	JPanel occupantsPanel;
	JPanel queensPanel;
	JPanel doublePanel;
	JPanel centerLeftPanel;
	JPanel centerRightPanel;
	JPanel centerPanel;
	JPanel mainPanel;

	JButton availabilityButton;

	public ReservationParamsUI(ReservationParamsCntl passedCntl){
		this.theReservationsParamsCntl = passedCntl;
		this.initComponents();
		this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setTitle("Reservation Params");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	public void initComponents(){
		UtilDateModel modelIn = new UtilDateModel();
        Properties pIn = new Properties();
        pIn.put("text.today", "Today");
        pIn.put("text.month", "Month");
        pIn.put("text.year", "Year");
        JDatePanelImpl dateInPanel = new JDatePanelImpl(modelIn, pIn);

        UtilDateModel modelOut = new UtilDateModel();
        Properties pOut = new Properties();
        pOut.put("text.today", "Today");
        pOut.put("text.month", "Month");
        pOut.put("text.year", "Year");
        JDatePanelImpl dateOutPanel = new JDatePanelImpl(modelOut, pOut);

		this.titleLabel = new JLabel("Reservation Information", SwingConstants.CENTER);
		this.titleLabel.setFont(new Font("Arial", Font.PLAIN, 50));

		this.checkInLabel = new JLabel("Check In Date: ", SwingConstants.CENTER);
        this.checkInPicker = new JDatePickerImpl(dateInPanel, new DateLabelFormatter());

		this.checkOutLabel = new JLabel("Check Out Date: ", SwingConstants.CENTER);
        this.checkOutPicker = new JDatePickerImpl(dateOutPanel, new DateLabelFormatter());

		this.occupantsLabel = new JLabel("Number of Occupants: ", SwingConstants.CENTER);
		this.occupantsDown = new BasicArrowButton(BasicArrowButton.SOUTH);
		this.occupantsDown.addActionListener(new OccupantsDownListener());
		this.occupantsNum = new JLabel("1");
		this.occupantsUp = new BasicArrowButton(BasicArrowButton.NORTH);
		this.occupantsUp.addActionListener(new OccupantsUpListener());

		this.queensLabel = new JLabel("Number of Queen Beds: ", SwingConstants.CENTER);
		this.queensDown = new BasicArrowButton(BasicArrowButton.SOUTH);
		this.queensDown.addActionListener(new QueensDownListener());
		this.queensNum = new JLabel("1");
		this.queensUp = new BasicArrowButton(BasicArrowButton.NORTH);
		this.queensUp.addActionListener(new QueensUpListener());

		this.doubleLabel = new JLabel("Number of Double Beds: ", SwingConstants.CENTER);
		this.doubleDown = new BasicArrowButton(BasicArrowButton.SOUTH);
		this.doubleDown.addActionListener(new DoubleDownListener());
		this.doubleNum = new JLabel("1");
		this.doubleUp = new BasicArrowButton(BasicArrowButton.NORTH);
		this.doubleUp.addActionListener(new DoubleUpListener());

		this.checkInPanel = new JPanel();
		this.checkOutPanel = new JPanel();
		this.occupantsPanel = new JPanel();
		this.queensPanel = new JPanel();
		this.doublePanel = new JPanel();
		this.centerLeftPanel = new JPanel(new GridLayout(2, 1));
		this.centerRightPanel = new JPanel(new GridLayout(3, 1));
		this.centerPanel = new JPanel(new GridLayout(1, 2));
		this.mainPanel = new JPanel(new BorderLayout());

		this.availabilityButton = new JButton("Check Availability");
        this.availabilityButton.addActionListener(new AvailabilityListener());

		this.checkInPanel.add(this.checkInLabel);
		this.checkInPanel.add(this.checkInPicker);

		this.checkOutPanel.add(this.checkOutLabel);
		this.checkOutPanel.add(this.checkOutPicker);

		this.occupantsPanel.add(this.occupantsLabel);
		this.occupantsPanel.add(this.occupantsDown);
		this.occupantsPanel.add(this.occupantsNum);
		this.occupantsPanel.add(this.occupantsUp);

		this.queensPanel.add(this.queensLabel);
		this.queensPanel.add(this.queensDown);
		this.queensPanel.add(this.queensNum);
		this.queensPanel.add(this.queensUp);

		this.doublePanel.add(this.doubleLabel);
		this.doublePanel.add(this.doubleDown);
		this.doublePanel.add(this.doubleNum);
		this.doublePanel.add(this.doubleUp);

		this.centerLeftPanel.add(this.checkInPanel);
		this.centerLeftPanel.add(this.checkOutPanel);

		this.centerRightPanel.add(this.occupantsPanel);
		this.centerRightPanel.add(this.queensPanel);
		this.centerRightPanel.add(this.doublePanel);

		this.centerPanel.add(this.centerLeftPanel);
		this.centerPanel.add(this.centerRightPanel);

		this.mainPanel.add(this.titleLabel, BorderLayout.NORTH);
		this.mainPanel.add(this.centerPanel, BorderLayout.CENTER);
		this.mainPanel.add(this.availabilityButton, BorderLayout.SOUTH);

		this.add(mainPanel);
	}

	private boolean checkParams(){
		String checkIn = "";
		String checkOut = "";
		try{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	    	Date selectedInDate = (Date) ReservationParamsUI.this.checkInPicker.getModel().getValue();
		    checkIn = df.format(selectedInDate);

		    Date selectedOutDate = (Date) ReservationParamsUI.this.checkOutPicker.getModel().getValue();
		    checkOut = df.format(selectedOutDate);
		}catch (NullPointerException e){
			System.out.println("Null pointer exception in checkParams");
		}

		String occupants = this.occupantsNum.getText();
		String numQ = this.queensNum.getText();
		String numD = this.doubleNum.getText();

		if(!checkIn.equals("") && !checkOut.equals("") && !occupants.equals("") && !numQ.equals("") && !numD.equals("")){
			return true;
		}
		return false;
	}

	public class DateLabelFormatter extends AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

	//listener for the occupantsDown button
    public class OccupantsDownListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.occupantsNum.getText());
            if (cur > 0){
            	ReservationParamsUI.this.occupantsNum.setText(String.valueOf(cur-1));
            }
        }
    }
	//listener for the occupantsUp button
    public class OccupantsUpListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.occupantsNum.getText());
            if (cur < 10){
            	ReservationParamsUI.this.occupantsNum.setText(String.valueOf(cur+1));
            }
        }
    }

    //listener for the queensDown button
    public class QueensDownListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.queensNum.getText());
            if (cur > 0){
            	ReservationParamsUI.this.queensNum.setText(String.valueOf(cur-1));
            }
        }
    }
	//listener for the queensUp button
    public class QueensUpListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.queensNum.getText());
            if (cur < 10){
            	ReservationParamsUI.this.queensNum.setText(String.valueOf(cur+1));
            }
        }
    }

    //listener for the doubleDown button
    public class DoubleDownListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.doubleNum.getText());
            if (cur > 0){
            	ReservationParamsUI.this.doubleNum.setText(String.valueOf(cur-1));
            }
        }
    }
	//listener for the doubleUp button
    public class DoubleUpListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int cur = Integer.parseInt(ReservationParamsUI.this.doubleNum.getText());
            if (cur < 10){
            	ReservationParamsUI.this.doubleNum.setText(String.valueOf(cur+1));
            }
        }
    }

	//action listener for availability button
    public class AvailabilityListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){

        	if (checkParams()){
        		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	        	Date selectedInDate = (Date) ReservationParamsUI.this.checkInPicker.getModel().getValue();
			    String checkIn = df.format(selectedInDate);

			    Date selectedOutDate = (Date) ReservationParamsUI.this.checkOutPicker.getModel().getValue();
			    String checkOut = df.format(selectedOutDate);

				String occupants = ReservationParamsUI.this.occupantsNum.getText();
				String numQ = ReservationParamsUI.this.queensNum.getText();
				String numD = ReservationParamsUI.this.doubleNum.getText();
	            ReservationParamsUI.this.theReservationsParamsCntl.runRoomSearch(checkIn, checkOut, occupants, numQ, numD);
	        
        	}else{
        		JOptionPane.showMessageDialog(null, "Please fill out all elements");
			}
        }
    }
}