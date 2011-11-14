import javax.swing.*;

@SuppressWarnings("serial")
public class PatientInfoPanel extends JPanel{

	public PatientInfoPanel(){

	}
	
	public void setPatient(Patient p) {
		this.removeAll();
		super.setLayout(new SpringLayout());
		super.add(new JLabel("Patient Name:"));
		super.add(new JLabel(p.getName()));
		super.add(new JLabel("Patient ID:"));
		super.add(new JLabel(p.getID()));
		super.add(new JLabel("Address:"));
		super.add(new JLabel(p.getAddress()));
		super.add(new JLabel("Room No:"));
		super.add(new JLabel(p.getRoom()));
		super.add(new JLabel("Nurse:"));
		super.add(new JLabel(p.getNurse()));
		SpringUtilities.makeCompactGrid(this,
                5, 2, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, yPad
	}
}
