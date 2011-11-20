import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
/**
 * Main Frame or the Start Frame that the pharmacist will see. This allows the patient to scan/type in the pillbox ID (patient ID) and move on to the {@link PatientInfoFrame}
 * @author pujita
 *
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements FrameInterface{

	ButtonPanel buttonPanel;
	PatientInfoFrame otherView;
	SettingsFrame setting = new SettingsFrame(this);
	
	/**
	 * Constructor that adds a {@link ButtonPanel} button panel (text box to input ID) and a Next button.
	 */
	public MainFrame(){
		
		super("Pharmacy Workstation");
		otherView = new PatientInfoFrame(this);
		setSize(500, 600);
		JLabel prompt = new JLabel("                                  Scan Pillbox to start");
		prompt.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel title = new JLabel("           PHARMACY WORKSTATION");
		title.setFont(new Font("Serif", Font.BOLD, 26));
		buttonPanel = new ButtonPanel("Next","Settings", this);
		
		add(title, BorderLayout.PAGE_START);
		add(prompt, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * gets activated when the next button in the button panel is clicked. It reads in the inputed patient id and checks if a 
	 * patient with that id exists to open the second frame {@link PatientInfoFrame} otherwise it throws an
	 * error saying no such patient exists.
	 */
	@Override
	public void goNext(String id){
		Patient p = Patient.patientMap.get(id);
		String error = "Invalid Patient ID. Try again.";
		if(p == null){
			JOptionPane.showMessageDialog(null,error);
		}
		else{
			otherView.open(p);
			setVisible(false);
		}
	}
	
	/**
	 * goBack method, does nothing for the main/start frame.
	 */
	@Override
	public void goBack() {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * done method, does nothing for the main/start frame.
	 */
	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Settings page
	 */
	public void setting(){
		setVisible(false);
		setting.setSettingsFrame();
		setting.setVisible(true);
	}

	/**
	 * Creates a Patient List {@link Patient} and a Medicine List {@link Medicine}
	 * @param args
	 */
	public static void main(String args[]) {
		Medicine.createMedList();
		Patient.createPatientList();
		MainFrame p = new MainFrame();
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
}
