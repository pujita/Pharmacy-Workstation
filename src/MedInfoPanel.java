import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class MedInfoPanel extends JPanel {

	public MedInfoPanel(){
	}
	
	/*
	public void setPanel(MedicineTaken med){
		this.removeAll();
		JPanel info = newJPanel();
		super.setLayout(new SpringLayout());
		super.add(new JLabel("Medicine Name:"));
		super.add(new JLabel(med.getName()));
		super.add(new JLabel("Medicine ID:"));
		super.add(new JLabel(med.getID()));
		super.add(new JLabel("Dose:"));
		super.add(new JLabel(med.getDose()));
		super.add(new JLabel("Time:"));
		super.add(new JLabel(med.getTime()));
	
		SpringUtilities.makeCompactGrid(this,
                4, 2, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, yPad
	}
	*/
	public void setPanel(MedicineTaken med){
		this.removeAll();
		JPanel info = new JPanel();
		info.setLayout(new SpringLayout());
		info.add(new JLabel("Medicine Name:"));
		info.add(new JLabel(med.getName()));
		info.add(new JLabel("Medicine ID:"));
		info.add(new JLabel(med.getID()));
		info.add(new JLabel("Dose:"));
		info.add(new JLabel(med.getDose()));
		info.add(new JLabel("Time:"));
		info.add(new JLabel(med.getTime()));
	
		SpringUtilities.makeCompactGrid(info,
                4, 2, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, yPad
		
		String time = med.getTime().trim()+ ".gif";
		ImageIcon icon = new ImageIcon(time);
		JButton image = new JButton(icon);
		add(info, BorderLayout.PAGE_START);
		add(image, BorderLayout.PAGE_END);
	}
}
