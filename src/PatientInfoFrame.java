import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PatientInfoFrame extends JFrame{

	
	private JButton backButton;
	private JPanel buttonPanel;
	private JTextField textBox;
	private MainFrame prevFrame;
	private PatientInfoPanel infoPanel;
	private MultiMedsPanel medsPanel;
	
	/**
	 * Constructor for this class. Requires a reference to {@link MainFrame} in order for
	 * it to go back when goBack is called.
	 * @param prevFrame reference to previous {@link MainFrame}.
	 */
	public PatientInfoFrame(MainFrame prevFrame){
		super("Pharmacy Workstation");
		infoPanel = new PatientInfoPanel();
		infoPanel.setBounds(10, 10, 50, 50);
		medsPanel = new MultiMedsPanel();

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		backButton = new JButton("Back");
		backButton.addActionListener(new ButtonListener());	
		buttonPanel.add(backButton);

		this.prevFrame = prevFrame;
		
		super.add(infoPanel, BorderLayout.PAGE_START);
		super.add(medsPanel, BorderLayout.CENTER);
		super.add(buttonPanel,BorderLayout.PAGE_END);
		super.setSize(500, 700);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Opens the Frame with the selected Patient Information.
	 * @param p The Patient that you want to display information for.
	 */
	public void open(Patient p) {
		infoPanel.setPatient(p);
		medsPanel.setMedsPanel(p);
		super.add(medsPanel, BorderLayout.CENTER);
		super.setVisible(true);
	}

	/**
	 * Called by {@link ButtonListener}. Takes a user back to the MainFrame by changing visibility state.
	 */
	private void goBack(){
		super.setVisible(false);
		prevFrame.frame.setVisible(true);
	}
	
	/**
	 * Listener called when user selects "Go Back". The user will be taken back to the {@link MainFrame}
	 * @author pujita
	 *
	 */
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			goBack();
		}
	}
}
