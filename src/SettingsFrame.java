import java.awt.BorderLayout;
import java.util.ArrayList;


import javax.swing.*;


@SuppressWarnings("serial")
public class SettingsFrame extends JFrame implements FrameInterface{
	
	private JPanel info = new JPanel();
	private ButtonPanel buttonPanel;
	ArrayList<MedSocket> checkList = new ArrayList<MedSocket>();
	private MainFrame prevFrame;
	
	/**
	 * Creates an initial frame
	 * @param prev {@link MainFrame}
	 */
	public SettingsFrame(MainFrame prev){
		prevFrame = prev;
		setSize(500, 600);
		JScrollPane scroller = new JScrollPane(info);
		int i = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		int j = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		scroller.setHorizontalScrollBarPolicy( i);
		scroller.setVerticalScrollBarPolicy( j);
		super.add(scroller,BorderLayout.CENTER);
		buttonPanel = new ButtonPanel("select all", "delete", "edit", "add", "back", this);
		super.add(buttonPanel, BorderLayout.PAGE_END);
		
	}
	
	/**
	 * Set the actual information in the panel
	 */
	public void setSettingsFrame(){
		info.removeAll();
		
		info.setLayout(new SpringLayout());
		info.add(new JLabel("Medicine Name"));
		info.add(new JLabel("Medicine ID"));
		info.add(new JLabel("Module ID"));
		int row = 1;
		for(String key : Medicine.medMap.keySet()){
			JCheckBox id = new JCheckBox(Medicine.medMap.get(key).getMedID());
			JTextField modNo = new JTextField(Medicine.medMap.get(key).getModuleNo());
			checkList.add(new MedSocket(id,modNo));
			info.add(id);
			info.add(new JLabel(Medicine.medMap.get(key).getName()));
			info.add(modNo);
			row++;
		}
		SpringUtilities.makeCompactGrid(info,
                row, 3, //rows, cols
                5, 5, //initialX, initialY
                10, 10);//xPad, y
	}

	@Override
	public void goBack() {
		prevFrame.setVisible(true);
		setVisible(false);
	}

	/**
	 * Select All button to select all check boxes
	 */
	@Override
	public void selectAll() {
		for(int i = 0; i < checkList.size(); i++){
			if(!checkList.get(i).getID().isSelected()){
				checkList.get(i).getID().setSelected(true);
			}
			else{
				checkList.get(i).getID().setSelected(false);
			}
		}
		
	}

	@Override
	public void delete() {
		/*
		for(int i = 0; i < checkList.size(); i++){
			if(checkList.get(i).getID().isSelected()){
				//String medID = checkList.get(i).getIDstr();
				//Medicine.medMap.get(medID).setModuleNo("");
				checkList.get(i).setModNo("");
			}
		}
		setSettingsFrame();
		//Needed to refresh the UI
		SwingUtilities.updateComponentTreeUI(this);
		*/
	}

	@Override
	public void save() {
		for(int i = 0; i < checkList.size(); i++){
			String medID = checkList.get(i).getIDstr();
			String modNo = checkList.get(i).getModNoStr();
			Medicine.medMap.get(medID).setModuleNo(modNo);
		}
		setSettingsFrame();
		//Needed to refresh the UI
		SwingUtilities.updateComponentTreeUI(this);	
	}

	@Override
	public void add() {
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
