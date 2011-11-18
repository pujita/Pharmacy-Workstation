import java.awt.BorderLayout;

import javax.swing.*;


@SuppressWarnings("serial")
public class SettingsFrame extends JFrame implements FrameInterface{
	JPanel info = new JPanel();
	ButtonPanel buttonPanel;
	
	public SettingsFrame(){
		info.setLayout(new SpringLayout());
		int row = 0;
		for(String key : Medicine.medMap.keySet()){
			
			info.add(new JCheckBox(Medicine.medMap.get(key).getMedID()));
			info.add(new JCheckBox(Medicine.medMap.get(key).getName()));
			info.add(new JCheckBox(Medicine.medMap.get(key).getModuleNo()));
			row++;
		}
		SpringUtilities.makeCompactGrid(info,
                row, 3, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, y
		super.add(info,BorderLayout.CENTER);
		buttonPanel = new ButtonPanel("Back", "Next", "Done", this);
		super.add(buttonPanel, BorderLayout.PAGE_END);
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goNext(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setting() {
		// TODO Auto-generated method stub
		
	}

}
