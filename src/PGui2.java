import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PGui2 {

	JTextField textBox; 
	JButton button;
	JButton exitButton;

	JPanel panel;
	JFrame frame;
/*
	JFrame p;
	
	public PGui2(JFrame p) {
		this.p = p;
	}
	*/
	
	public PGui2() {
		frame = new JFrame("hello, continued");
		panel = new JPanel();
		button = new JButton("what up nigga");
		exitButton = new JButton("go back");

		textBox = new JTextField("attempting");
		button.addActionListener(new ButtonListener());
	//	exitButton.addActionListener(new QuitButtonListener());

		panel.add(button);
		panel.add(exitButton);

		panel.add(textBox);
		frame.add(panel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 	button.setText(textBox.getText());
		 }
	}
	
	/*
	private class QuitButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 	p.setVisible(true);
		 	frame.dispose();
		 }
	}
	*/
}