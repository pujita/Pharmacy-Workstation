import javax.swing.*;


@SuppressWarnings("serial")
public class MainFrame extends JFrame implements FrameInterface{

	ButtonPanel buttonPanel;
	PatientInfoFrame otherView;
	
	public MainFrame(){
		
		super("Pharmacy Workstation");
		otherView = new PatientInfoFrame(this);
		setSize(500, 700);
		buttonPanel = new ButtonPanel("Next", this);
		add(buttonPanel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	/*
	public int getID (){
		return Integer.parseInt(textBox.getText());
	}
	*/

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goNext(String id){
		Patient p = Patient.patientMap.get(id);
		String error = "Invalid Patient ID. Try again.";
		if(p == null){
			JOptionPane.showMessageDialog(null,error);
		}
		else{
			otherView.open(p);
			setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		Medicine.createMedList();
		Patient.createPatientList();
		//System.out.println(Medicine.medMap.get("1022").getName());
		MainFrame p = new MainFrame();
	}
}
