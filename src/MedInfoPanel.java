import javax.swing.*;

@SuppressWarnings("serial")
public class MedInfoPanel extends JPanel {
	
	Medicine med;
	JLabel medName;
	JLabel dose;
	JLabel time;
	
	public MedInfoPanel(Medicine med){
		this.med = med;
		this.medName = new JLabel(med.getName());
		this.dose = new JLabel(med.getDose() + "mg");
		this.time = new JLabel(med.getTimeString());
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		add(medName);
		add(time);
		add(dose);
	}
}
