import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GamePanel extends JPanel{
	
	final static int maxX = 20;
	final static int maxY = 20;
	final static Border blackline = BorderFactory.createLineBorder(Color.black);
	private 
	
	public GamePanel() {
		super(new GridLayout(maxX,maxY));
		
		for (int i=0; i<maxX; i++) {
			for (int j=0; j<maxY; j++) {
				JPanel Case = new JPanel();
				Case.setBackground(Color.DARK_GRAY);
				Case.setBorder(blackline);
				super.add(Case);
			}
		}
		
		
	}
	
	
	

}
