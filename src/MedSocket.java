import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class MedSocket {
	
	private JCheckBox medID;
	private JTextField moduleNo;
	
	public MedSocket(JCheckBox id, JTextField number){
		medID= id;
		moduleNo = number;
	}
	
	public MedSocket(String id, String number){
		medID= new JCheckBox(id);
		moduleNo = new JTextField(number);
	}
	
	public void setID(String id){
		medID.setText(id);
	}
	
	public void setModNo(String number){
		moduleNo.setText(number);
	}
	
	public JCheckBox getID(){
		return medID;
	}
	
	public String getIDstr(){
		return medID.getText();
	}
	
	public JTextField getModNo(){
		return moduleNo;
	}
	
	public String getModNoStr(){
		return moduleNo.getText();
	}

}
