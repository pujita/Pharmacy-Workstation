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
		mainFrame.setVisible(true);
		setVisible(false);
	}

	@Override
	public void goNext(String id) {
		Medicine patientMed = Patient.patientMap.get(patientID).getMeds().get(id);
		String error = "No such medicine exists for this patient. Place in discard bin and try again.";
		if(patientMed == null){
			JOptionPane.showMessageDialog(null,error);
		}
		else{
			medPanel.setPanel(patientMed);
		}
		
	}

}
