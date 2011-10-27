import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PatientInfoFrame extends JFrame{

	
	JButton backButton;
	JPanel infoPanel;
	JPanel buttonPanel;
	JLabel patientName;
	JTextField textBox;
	MainFrame prevFrame;
	
	public PatientInfoFrame(MainFrame prevFrame){
		super("Pharmacy Workstation");
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
		//patientName = new JLabel("Name: ");
		//infoPanel.add(patientName);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		backButton = new JButton("Back");
		backButton.addActionListener(new ButtonListener());	
		buttonPanel.add(backButton);
		
		this.prevFrame = prevFrame;

		super.add(infoPanel, BorderLayout.CENTER);
		super.add(buttonPanel,BorderLayout.PAGE_END);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setPatientName(String name){
		patientName = new JLabel("Name: "+ name);
		infoPanel.add(patientName);
		super.pack();
	}
	
	public void open() {
		super.setVisible(true);
	}

	public void displayInfo(int patientID){
		try {
			FileReader fin = new FileReader("Test.txt");
			Scanner scan = new Scanner(fin);

			while(scan.hasNextLine()){
				String temp = scan.nextLine();
				String[] tokens = temp.split(",");
			
				if (Integer.parseInt(tokens[0]) ==patientID){
					System.out.println(temp);
					this.setPatientName(tokens[1]);
					break;
				}
			}
			fin.close();
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void goBack(){
		super.setVisible(false);
		prevFrame.frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			goBack();
		}
	}
}
