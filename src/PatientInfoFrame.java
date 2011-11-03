import javax.swing.*;

import java.awt.*;


/**
 * 
 * @author pujita
 *
 */
@SuppressWarnings("serial")
public class PatientInfoFrame extends JFrame implements FrameInterface{
	
	private ButtonPanel buttonPanel;
	private JFrame prevFrame;
	private PatientInfoPanel infoPanel;
	private MultiMedsPanel medsPanel;
	String patientID;
	//private JFrame newPrevFrame;
	
	/**
	 * Constructor for this class. Requires a reference to {@link MainFrame} in order for
	 * it to go back when goBack is called.
	 * @param prevFrame reference to previous {@link MainFrame}.
	 */
	public PatientInfoFrame(MainFrame prevFrame){
		super("Pharmacy Workstation");
		infoPanel = new PatientInfoPanel();
		medsPanel = new MultiMedsPanel();
		buttonPanel = new ButtonPanel("Back", "Next", "Done", this);
		this.prevFrame = prevFrame;
		
		super.add(infoPanel, BorderLayout.PAGE_START);
		super.add(medsPanel, BorderLayout.CENTER);
		super.add(buttonPanel,BorderLayout.PAGE_END);
		super.setSize(500, 700);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Opens the Frame with the selected Patient Information.
	 * @param p The Patient that you want to display information for.
	 */
	public void open(Patient p) {
		patientID = p.getID();
		infoPanel.setPatient(p);
		medsPanel.setMedsPanel(p);
		super.add(medsPanel, BorderLayout.CENTER);
		super.setVisible(true);
	}
	
	public void openMed(Medicine med){
		prevFrame = this;
		
	}
	
	/**
	 * Called by {@link ButtonListener}. Takes a user back to the MainFrame by changing visibility state.
	 */
	@Override
	public void goBack(){
		this.setVisible(false);
		//if(newPrevFrame == null)
		prevFrame.setVisible(true);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goNext(String id) {
		//Medicine med = Medicine.medMap.get(id);
		Medicine patientMed = Patient.patientMap.get(patientID).getMeds().get(id);
		String error = "No such medicine exists for this patient. Place in discard bin and try again.";
		if(patientMed == null){
			JOptionPane.showMessageDialog(null,error);
		}
		//else{
			//otherView.open(p);
			//setVisible(false);
		//}
		
	}
}
