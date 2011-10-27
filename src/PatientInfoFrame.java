import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PatientInfoFrame extends JFrame{

	
	JButton button;
	JPanel panel;
	JLabel label;
	JTextField textBox;
	MainFrame prevFrame;
	
	public PatientInfoFrame(MainFrame prevFrame){
		super("Pharmacy Workstation");
		panel = new JPanel();
		button = new JButton("Back");
		label = new JLabel("Name");
		button.addActionListener(new ButtonListener());	
		this.prevFrame = prevFrame;
		
		panel.add(button);
		panel.add(label);
		super.add(panel);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
