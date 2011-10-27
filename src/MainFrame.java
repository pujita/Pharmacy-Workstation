import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainFrame {

	JFrame frame;
	JButton button1;
	JButton button2;
	JPanel panel;
	JLabel label;
	JTextField textBox;
	//PujitaPanel myPanel;
	PatientInfoFrame otherView;
	String patientID;
	
	public MainFrame(){
		frame = new JFrame("Pharmacy Workstation");
		panel = new JPanel();
		button1 = new JButton("get info");
		button2 = new JButton("button2");
		label = new JLabel("Test");
		textBox = new JTextField("Type patient ID");
		ButtonListener listen = new ButtonListener();
		button1.addActionListener(listen);	
		button2.addActionListener(listen);	
		
		otherView = new PatientInfoFrame(this);
		patientID = "0";
		
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(label);
		panel.add(textBox);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public int getID (){
		return Integer.parseInt(textBox.getText());
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == button1) {
				otherView.open();
				otherView.displayInfo(Integer.parseInt(textBox.getText()));
				frame.setVisible(false);
			}
			else if (e.getSource() == button2) {
				System.out.println("you clicked");
			}
			
		}
	}
	
	public static void main(String args[]) {
		MainFrame p = new MainFrame();
	}
}
