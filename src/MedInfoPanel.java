import javax.swing.*;

@SuppressWarnings("serial")
public class MedInfoPanel extends JPanel {
	
	Medicine med;
	JLabel medName;
	JLabel id;
	JLabel dose;
	JLabel time;
	
	public MedInfoPanel(){
		
		this.id = new JLabel("");
		this.medName = new JLabel("");
		this.dose = new JLabel("");
		this.time = new JLabel("");
		
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		add(id);
		add(medName);
		add(time);
		add(dose);
	}
	
	public void panelReset(){
		this.id.setText("");
		this.medName.setText("");
		this.dose.setText("");
		this.time.setText("");

	}
	
	
	public void setPanelAllTime(Medicine med){
		this.med = med;
		this.medName.setText(med.getName());
		this.id.setText(med.getMedID());
		this.dose.setText(med.getDose() + "mg");
		this.time.setText(med.getTimeString());
	}
	
	public void setPanel(MedicineTaken med){
		Medicine medicine = Medicine.medMap.get(med.getID());
		this.med = medicine;
		this.medName.setText(medicine.getName());
		this.id.setText(med.getID());
		this.dose.setText(medicine.getDose() + "mg");
		this.time.setText(med.getTime() + " ");	
	}
}
