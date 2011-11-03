import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class MedicineInfoFrame extends JFrame implements FrameInterface{
	
	private ButtonPanel buttonPanel;
	//private PatientInfoPanel infoPanel;
	private MedInfoPanel medPanel = new MedInfoPanel();
	private String patientID;
	private PatientInfoFrame prevFrame;
	private MainFrame mainFrame;
	//static ArrayList<String> medsTaken = new ArrayList<String>();
	
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

	@Override
	public void goBack() {
		prevFrame.setVisible(true);
		setVisible(false);
		
	}

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
	public static void main (String[] args){
		//Medicine.createMedList();
		//Patient.createPatientList();
		//System.out.println(Patient.patientMap.get("1").getMeds().get("1011"));
	}

}
