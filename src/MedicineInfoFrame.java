import javax.swing.*;
import java.awt.*;

/**
 * This is the Third screen that the user sees. It consists of the same button panel {@link ButtonPanel} as the previous two. 
 * It Displays the information for the medicine ID that inputed in the previous screen.
 * @author pujita
 *
 */
@SuppressWarnings("serial")
public class MedicineInfoFrame extends JFrame implements FrameInterface{
	
	private ButtonPanel buttonPanel;
	private MedInfoPanel medPanel = new MedInfoPanel();
	private String patientID;
	private PatientInfoFrame prevFrame;
	private MainFrame mainFrame;

	/**
	 * Constructor for {@link MedicineInfoFrame}
	 * @param id is the {@link Patient} ID for which the medicines are being displayed
	 * @param med is the {@link Medicine} for which the information is being displayed
	 * @param prev is a reference to previous {@link PatientInfoFrame} 
	 */
	public MedicineInfoFrame(String id, Medicine med, PatientInfoFrame prev){
		super("Pharmacy Workstation");
		patientID = id;
		prevFrame = prev;
		mainFrame = prevFrame.getPrevFrame();
		medPanel.setPanel(med);
		buttonPanel = new ButtonPanel("Back", "Next", "Done", this);
		
		super.add(medPanel, BorderLayout.CENTER);
		super.add(buttonPanel,BorderLayout.PAGE_END);
		super.setSize(500, 700);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Takes a user back to the {@link MainFrame} by changing visibility state.
	 */
	@Override
	public void goBack() {
		prevFrame.setVisible(true);
		setVisible(false);
		
	}

	/**
	 * Checks if all the medicines needed are scanned. If they are then it takes the user to {@link MainFrame}. Otherwise it prompts an error.
	 */
	@Override
	public void done() {
		String error = "Not done, missing meds! Collect again";
		for(int i = 0; i < prevFrame.medsTaken.size(); i++){
			if(!prevFrame.medsTaken.get(i).getTaken()){
				JOptionPane.showMessageDialog(null,error);
				return;
			}
		}
		mainFrame.setVisible(true);
		setVisible(false);
	}

	/**
	 * Takes the inputed medicine ID and updates that it has been scanned in the @link {@link MedicineTaken}, then displays the next frame by calling {@link openMed}.
	 * and prompts an error if no such medicine exists for the patient.
	 */
	@Override
	public void goNext(String id) {
		Medicine patientMed = Patient.patientMap.get(patientID).getMeds().get(id);
		String error = "No such medicine exists for this patient or it has already been scanned. Place in discard bin and try again.";
		
			for (int i = 0; i < prevFrame.medsTaken.size(); i++){
				if (Integer.parseInt(prevFrame.medsTaken.get(i).getID()) == Integer.parseInt(id)){
					if(!prevFrame.medsTaken.get(i).getTaken()){
						prevFrame.medsTaken.get(i).setTaken();
						medPanel.setPanel(patientMed);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(null,error);
	}

}
