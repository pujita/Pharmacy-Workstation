import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class MultiMedsPanel extends JPanel{
		
	public MultiMedsPanel(){
	}
	
	/**
	 * Set initial medicine info panel showing medicines with all possible times
	 */
	public void setMedsPanel(Patient p){
		this.removeAll();
		super.setLayout(new SpringLayout());
		int row = 2;
		super.add(new JLabel("Medicines:"));
		super.add(new JLabel(""));
		super.add(new JLabel(""));
		super.add(new JLabel(""));
		super.add(new JLabel("ID"));
		super.add(new JLabel("Name"));
		super.add(new JLabel("Times"));
		super.add(new JLabel("Dose (mg)"));
		
		for (String key : p.getMeds().keySet()) {
			Medicine med = p.getMeds().get(key);
			super.add(new JLabel(med.getMedID()));
			super.add(new JLabel(med.getName()));
			super.add(new JLabel(med.getTimeString()));
			super.add(new JLabel(med.getDose()));
			row++;
		}
		SpringUtilities.makeCompactGrid(this,
                row, 4, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, yPad
		
	}
	
	
	/**
	 * Set Still needed medicines 
	 * @param meds
	 */
	public void setTakenMedsPanel(ArrayList<MedicineTaken> meds){
		this.removeAll();
		super.setLayout(new SpringLayout());
		int row = 2;
		super.add(new JLabel("Medicines Left:"));
		super.add(new JLabel(""));
		super.add(new JLabel(""));
		super.add(new JLabel(""));
		super.add(new JLabel("ID"));
		super.add(new JLabel("Name"));
		super.add(new JLabel("Times"));
		super.add(new JLabel("Dose (mg)"));
		
		for(int i = 0; i < meds.size(); i++){
			if(!meds.get(i).getTaken()){
				super.add(new JLabel(meds.get(i).getID()));
				super.add(new JLabel(meds.get(i).getName()));
				super.add(new JLabel(meds.get(i).getTime()));
				super.add(new JLabel(meds.get(i).getDose()));
				row++;
			}
			SpringUtilities.makeCompactGrid(this,
	                row, 4, //rows, cols
	                5, 5, //initialX, initialY
	                10, 10);//xPad, yPad
		}
	}
}
