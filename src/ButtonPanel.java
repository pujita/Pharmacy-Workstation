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
	private JButton settings = new JButton("Settings");
	private JButton nextButton = new JButton("Next");
	private JTextField textBox = new JTextField();
	private JButton selectAllButton = new JButton("Select All");
	private JButton deleteButton = new JButton("Delete");
	private JButton saveButton = new JButton("Save");
	private JButton addButton = new JButton("Add");
	 
	 
	FrameInterface currentFrame;

	public ButtonPanel(String back, String next, String done, FrameInterface currentFrame){
		
		this.currentFrame = currentFrame;
		//backButton = new JButton(back);
		//doneButton = new JButton(done);
		//nextButton = new JButton(next);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		backButton.addActionListener(new ButtonListener());
		nextButton.addActionListener(new ButtonListener());
		doneButton.addActionListener(new ButtonListener());
		add(backButton);
		add(textBox);
		add(nextButton);
		add(doneButton);
	}

	public ButtonPanel(String next, String setting, FrameInterface currentFrame){
		
		this.currentFrame = currentFrame;
		//nextButton = new JButton(next);
		//settings = new JButton(setting);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		nextButton.addActionListener(new ButtonListener());
		settings.addActionListener(new ButtonListener());
		add(textBox);
		add(nextButton);
		add(settings);
	}
	
	public ButtonPanel(String selectAll, String delete, String edit, String add, String back, FrameInterface currentFrame){
		
		this.currentFrame = currentFrame;
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		backButton.addActionListener(new ButtonListener());
		selectAllButton.addActionListener(new ButtonListener());
		deleteButton.addActionListener(new ButtonListener());
		saveButton.addActionListener(new ButtonListener());
		addButton.addActionListener(new ButtonListener());
		add(backButton);
		add(selectAllButton);
		add(deleteButton);
		add(saveButton);
		add(addButton);
		add(backButton);
	}
	
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
			else if(e.getSource() == settings){
				currentFrame.setting();
			}
			else if(e.getSource() == selectAllButton){
				currentFrame.selectAll();
			}
			else if(e.getSource() == deleteButton){
				currentFrame.delete();
			}
			else if(e.getSource() == saveButton){
				currentFrame.save();
			}
			else if(e.getSource() == addButton){
				currentFrame.add();
			}
		}
	}
	
}
