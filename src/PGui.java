import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PGui {

	JTextField textBox; 
	JButton button;
	JPanel panel;
	JFrame frame;
	
	public PGui() {
		frame = new JFrame("hello");
		panel = new JPanel();
		button = new JButton("i love you");
		textBox = new JTextField("attempting");
		button.addActionListener(new ButtonListener());
	}
	
	public void run() {
		panel.add(button);
		panel.add(textBox);
		frame.add(panel);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		 	//button.setText(textBox.getText());
		 	PGui2 p = new PGui2();
 			frame.setVisible(false);
		 }
	}
	
	public static void main(String args[]) {
		PGui g = new PGui();
		g.run();
	}
}