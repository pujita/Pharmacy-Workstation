import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PatientinfoPanel extends JPanel{

	JPanel panel;
	JLabel patientName;
	JLabel address;
	JLabel patientRoom;
	JLabel patientID;
	JLabel nurse;
	
	
	public PatientinfoPanel(Patient p){
		patientName = new JLabel("Name: "+ p.getName());
		address = new JLabel("Address: "+ p.getAddress());
		patientRoom = new JLabel("room No.:"+ p.getRoom());
		patientID = new JLabel("Patient ID: "+ p.getID());
		nurse = new JLabel("Assigned Nurse: "+ p.getNurse());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(patientName);
		panel.add(patientID);
		panel.add(address);
		panel.add(patientRoom);
		panel.add(nurse);
	}
	
	
}
