package hotelroommanager.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoadingUI extends JFrame
{
	LoadingCntl theLoadingCntl;
	JPanel mainPanel;

	public LoadingUI(LoadingCntl passedCntl){
		this.theLoadingCntl = passedCntl;
		this.initComponents();
		this.setSize(800, 600);
        this.setTitle("Loading...");
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
	}

	public void initComponents(){
	    Icon icon = new ImageIcon("/Users/unkn0wn/Downloads/loading.gif");
	    JLabel label = new JLabel(icon);
	    JLabel descripLabel = new JLabel("Connecting to server...", SwingConstants.CENTER);
	    descripLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	    descripLabel.setForeground(Color.white);
		this.mainPanel = new JPanel(new BorderLayout());
        this.mainPanel.setBackground(Color.black);

		this.mainPanel.add(label, BorderLayout.CENTER);
		this.mainPanel.add(descripLabel, BorderLayout.SOUTH);
		this.add(this.mainPanel);
	}
}