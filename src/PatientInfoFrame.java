import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PatientInfoFrame extends JFrame{

	
	JButton backButton;
	JPanel buttonPanel;
	JTextField textBox;
	MainFrame prevFrame;
	PatientInfoPanel infoPanel;
	MultiMedsPanel medsPanel;
	
	public PatientInfoFrame(MainFrame prevFrame){
		super("Pharmacy Workstation");
		infoPanel = new PatientInfoPanel();
		//medsPanel = new MultiMedsPanel(p);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		backButton = new JButton("Back");
		backButton.addActionListener(new ButtonListener());	
		buttonPanel.add(backButton);

		this.prevFrame = prevFrame;

		super.add(infoPanel, BorderLayout.PAGE_START);
		//super.add(medsPanel, BorderLayout.CENTER);
		super.add(buttonPanel,BorderLayout.PAGE_END);
		super.pack();
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	public void open(Patient p) {
		infoPanel.setPatient(p);
		medsPanel = new MultiMedsPanel(p);
		super.add(medsPanel, BorderLayout.CENTER);
		super.pack();
		super.setVisible(true);
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
