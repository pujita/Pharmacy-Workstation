import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;


@SuppressWarnings("serial")
public class SettingsFrame extends JFrame implements FrameInterface{
	JPanel info = new JPanel();
	ButtonPanel buttonPanel;
	
	public SettingsFrame(){
		setSize(500, 600);
		info.setLayout(new SpringLayout());
		info.add(new JLabel("Medicine Name"));
		info.add(new JLabel("Medicine ID"));
		info.add(new JLabel("Module ID"));
		int row = 1;
		//JScrollPane scroll = new JScrollPane();
		for(String key : Medicine.medMap.keySet()){
			
			info.add(new JCheckBox(Medicine.medMap.get(key).getMedID()));
			info.add(new JLabel(Medicine.medMap.get(key).getName()));
			info.add(new JLabel(Medicine.medMap.get(key).getModuleNo()));
			row++;
		}
		SpringUtilities.makeCompactGrid(info,
                row, 3, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, y
		//info.setPreferredSize(new Dimension(100,100));
		JScrollPane scroller = new JScrollPane(info);
		//scroller.setPreferredSize(new Dimension(100,100));
		int i = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		int j = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		scroller.setHorizontalScrollBarPolicy( i);
		scroller.setVerticalScrollBarPolicy( j);
		//JScrollPane scroll = new JScrollPane(info, 10, 10);
		super.add(scroller,BorderLayout.CENTER);
		//super.add(scroll, BorderLayout.CENTER);
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
