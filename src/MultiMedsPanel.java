import javax.swing.*;

@SuppressWarnings("serial")
public class MultiMedsPanel extends JPanel{
		
	public MultiMedsPanel(Patient p){
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (String key : p.getMeds().keySet()) {
			add(new MedInfoPanel(p.getMeds().get(key)));
		}	
	}
}
