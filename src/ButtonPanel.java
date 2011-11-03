import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import PatientInfoFrame.ButtonListener;


@SuppressWarnings("serial")
public class ButtonPanel extends JPanel{
	
	private JButton backButton = new JButton("Back");
	private JButton doneButton = new JButton("Done");
	private JButton nextButton = new JButton("Next");
	private JTextField textBox = new JTextField();
	FrameInterface currentFrame;

	public ButtonPanel(String back, String next, String done, FrameInterface currentFrame){
		
		this.currentFrame = currentFrame;
		backButton = new JButton(back);
		doneButton = new JButton(done);
		nextButton = new JButton(next);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		backButton.addActionListener(new ButtonListener());
		nextButton.addActionListener(new ButtonListener());
		doneButton.addActionListener(new ButtonListener());
		add(backButton);
		add(textBox);
		add(nextButton);
		add(doneButton);
	}

	public ButtonPanel(String next, FrameInterface currentFrame){
		
		this.currentFrame = currentFrame;
		nextButton = new JButton(next);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		nextButton.addActionListener(new ButtonListener());
		add(textBox);
		add(nextButton);
	}
	

/*
	public ButtonPanel(FrameInterface currentFrame) {
		this();
		this.currentFrame = currentFrame;
	}
	*/
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == backButton) {
				currentFrame.goBack();
			}
			else if(e.getSource() == nextButton){
				currentFrame.goNext(textBox.getText());
			}
			else if(e.getSource() == doneButton){
				currentFrame.done();
			}
		}
	}
	
}
