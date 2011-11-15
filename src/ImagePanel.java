import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	
	private JButton image;
	private ImageIcon icon;
	
	public void setImage(){
		image = new JButton(icon);
	}
	
	public void setIcon(String time){
		icon = new ImageIcon(time);
	}
	
	public JButton getImage(){
		return image;
	}
	
	public ImageIcon getIcon(){
		return icon;
	}

	public ImagePanel(){
		
	}
	
	public void setImagePanel(MedicineTaken med){
		setLayout(new BorderLayout());
		time = time.trim()+ ".gif";
		setIcon(time);
		setImage();
		add(image, BorderLayout.PAGE_END);
		
	}
}
