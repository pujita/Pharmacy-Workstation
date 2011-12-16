import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	public ImagePanel(String time){
		time = "images/"+time.trim()+ ".gif";
		ImageIcon icon = new ImageIcon(time);
		JButton image = new JButton(icon);
		super.add(image);
	}
		
	public void setImagePanel(String time){
		super.removeAll();
		time ="images/"+ time.trim()+ ".gif";
		ImageIcon icon = new ImageIcon(time);
		JButton image = new JButton(icon);
		super.add(image);
	}
}
