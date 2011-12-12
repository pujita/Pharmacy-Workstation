import javax.swing.*;

@SuppressWarnings("serial")
public class MedInfoPanel extends JPanel {

	public MedInfoPanel(){
	}
	
	
	public void setPanel(MedicineTaken med){
		this.removeAll();
		super.setLayout(new SpringLayout());
		super.add(new JLabel("Medicine Name:"));
		super.add(new JLabel(med.getName()));
		super.add(new JLabel("Medicine ID:"));
		super.add(new JLabel(med.getID()));
		super.add(new JLabel("Dose:"));
		super.add(new JLabel(med.getDose()));
		super.add(new JLabel("Time:"));
		super.add(new JLabel(med.getTime()));
		super.add(new JLabel("Module No:"));
		super.add(new JLabel(Medicine.medMap.get(med.getID()).getModuleNo()));
		super.add(new JLabel("Amount:"));
		super.add(new JLabel(Medicine.medMap.get(med.getID()).getAmount()));
		SpringUtilities.makeCompactGrid(this,
                6, 2, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, yPad
	}
}
