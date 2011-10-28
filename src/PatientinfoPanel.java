import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PatientInfoPanel extends JPanel{

	JLabel patientName;
	JLabel address;
	JLabel patientRoom;
	JLabel patientID;
	JLabel nurse;
	static final String nameHeader = "Name: ";
	static final String addressHeader = "Address: ";
	static final String roomHeader = "Room No: ";
	static final String idHeader = "Patient ID: ";
	static final String nurseHeader = "Assigned Nurse: ";

	
	public PatientInfoPanel(){
		patientName = new JLabel(nameHeader);
		address = new JLabel(addressHeader);
		patientRoom = new JLabel(roomHeader);
		patientID = new JLabel(idHeader);
		nurse = new JLabel(nurseHeader);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(patientName);
		add(patientID);
		add(address);
		add(patientRoom);
		add(nurse);
	}
	
	public void setPatient(Patient p) {
		patientName.setText(nameHeader + p.getName());
		address.setText(addressHeader + p.getAddress());
		patientRoom.setText(roomHeader + p.getRoom());
		patientID.setText(idHeader + p.getID());
		nurse.setText(nurseHeader + p.getNurse());
	}
}
