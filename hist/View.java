import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;


public class View {
	
	private JFrame window;
	private MainPanel game;
	final static int ScreenX = 700;
	final static int ScreenY = 700;
	
	public View() {
		window = new JFrame();
		this.window.setBackground(Color.DARK_GRAY);
		window.setTitle("Snake Game");
		
		//JLabel title = new JLabel("Snake game !");
		//window.add(title);
		
		
		game = new MainPanel();
		window.add(game);
		
	
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(new Dimension(ScreenX, ScreenY));
		window.setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		View app = new View();
	}
}
