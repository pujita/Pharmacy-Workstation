import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class MultiMedsPanel extends JPanel{
	
	MedInfoPanel[] panel = new MedInfoPanel[5];
	//MedInfoPanel panel = new MedInfoPanel();
		
	public MultiMedsPanel(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		panel[0] = new MedInfoPanel();
		panel[1] = new MedInfoPanel();
		panel[2] = new MedInfoPanel();
		panel[3] = new MedInfoPanel();
		panel[4] = new MedInfoPanel();

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(panel[0]);
		add(panel[1]);
		add(panel[2]);
		add(panel[3]);
		add(panel[4]);
		
	}
	
	
	public void setMedsPanel(Patient p){
		panel[0].panelReset();
		panel[1].panelReset();
		panel[2].panelReset();
		panel[3].panelReset();
		panel[4].panelReset();
		
		int count = 0;
		for (String key : p.getMeds().keySet()) {
			panel[count].setPanelAllTime(p.getMeds().get(key));
			count++;
		}
		
	}


	public void setTakenMedsPanel(ArrayList<MedicineTaken> meds){
		panel[0].panelReset();
		panel[1].panelReset();
		panel[2].panelReset();
		panel[3].panelReset();
		panel[4].panelReset();
		int count = 0;
		for(int i = 0; i < meds.size(); i++){
			if(!meds.get(i).getTaken()){
				panel[count].setPanel(meds.get(i));
				count++;
			}
		}
	}
}
