import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PujitaPanel extends JPanel{

	JButton button;
	JLabel label;
	JTextField textBox;
	
	public PujitaPanel(){
		super();
		button = new JButton("newButton");
		super.add(button);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
