import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * This is the second screen the pharmasict sees after inputing the patient/pillox ID. It displays all the patient info and all the required medicines he/she needs.
 * It also has a {@link ButtonPanel} button panel (consisting of back, done and next buttons along with a text box to scan/type medicine ID).
 * @author pujita
 *
 */
@SuppressWarnings("serial")
public class PatientInfoFrame extends JFrame implements FrameInterface{
	
	private PatientInfoPanel infoPanel;
	private MultiMedsPanel medsPanel;
	private ButtonPanel buttonPanel;
	private MainFrame prevFrame;
	private MedicineInfoFrame nextFrame;
	String patientID;
	ArrayList<MedicineTaken> medsTaken;
	
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
		super.setSize(500, 600);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String addrToMbed(Patient p){
		StringBuilder output = new StringBuilder();
		for(String key : p.getMeds().keySet()){
			output.append(Medicine.medMap.get(key).getModuleNo().trim());
			output.append(",");
		}
		System.out.print(output);
		return output.toString();
	}
	
	public String quanToMbed(Patient p){
		StringBuilder quantity = new StringBuilder();
		for(String key : p.getMeds().keySet()){
			quantity.append(Medicine.medMap.get(key).getAmount().trim());
			quantity.append(",");
		}
		quantity.setLength(quantity.length()-1);
		System.out.print(quantity);
		return quantity.toString();
	}
	
	public String lenToMbed(Patient p){
		return Integer.toString( p.getMeds().size());
	}
	
	/**
	 * Getter for previous Frame.
	 * @return the {@link MainFrame}.
	 */
	public MainFrame getPrevFrame(){
		return this.prevFrame;
	}

	/**
	 * Opens the Frame with the selected Patient Information.
	 * @param p The Patient that you want to display information for.
	 */
	public void open(Patient p) {
		patientID = p.getID();
		medsTaken = MedicineTaken.takenMeds(p);
		infoPanel.setPatient(p);
		medsPanel.setMedsPanel(p);
		super.add(medsPanel, BorderLayout.CENTER);
		super.setVisible(true);
	}
	
	/**
	 * Opens the next frame, {@Link MedicineInfoFrame}
	 * @param med is the {@Link Medicine} that the information needs to be displayed for, the medicine id that was typed in. 
	 * @param patientID is the Patient/pillbox ID
	 */
	public void openMed(MedicineTaken med, String patientID){
		nextFrame = new MedicineInfoFrame(patientID, med, this);
		nextFrame.setVisible(true);
		setVisible(false);
		
	}
	
	/**
	 * Takes a user back to the {@link MainFrame} by changing visibility state.
	 */
	@Override
	public void goBack(){
		this.setVisible(false);
		//if(newPrevFrame == null)
		prevFrame.setVisible(true);
	}

	/**
	 * Checks if all the medicines needed are scanned. If they are then it takes the user to {@link MainFrame}. Otherwise it prompts an error.
	 */
	@Override
	public void done() {
		String error = "Not done, missing meds! Collect again";
		for(int i = 0; i < medsTaken.size(); i++){
			if(!medsTaken.get(i).getTaken()){
				JOptionPane.showMessageDialog(null,error);
				return;
			}
		}
		goBack();
		
	}
	
	
	/**
	 * Takes the inputed medicine ID and updates that it has been scanned in the @link {@link MedicineTaken}, then displays the next frame by calling {@link openMed}.
	 * and prompts an error if no such medicine exists for the patient.
	 */	
	@Override
	public void goNext(String id) {
		String[] tokens = id.split("=");
		id = tokens[1];
		//System.out.println(id);
		//Medicine patientMed = Patient.patientMap.get(patientID).getMeds().get(id);
		String error = "No such medicine exists for this patient or it has already been scanned. Place in discard bin and try again.";

			for (int i = 0; i < medsTaken.size(); i++){
				if (Integer.parseInt(medsTaken.get(i).getID()) == Integer.parseInt(id)){
					if(!medsTaken.get(i).getTaken()){
						medsTaken.get(i).setTaken();
						openMed (medsTaken.get(i), patientID);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(null,error);	
	}

	/**
	 * Settings page, does nothing
	 */
	@Override
	public void setting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
	
}
