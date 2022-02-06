import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class Main {
	final static int screen_sizeX = 800;
	final static int screen_sizeY = View.game_size;

	private JFrame fenetre;
	private View gamepanel;
	private JPanel leftMenu;
	private JButton start;
	private JLabel score;
	private JFrame gameover;
	
	public Main() {
		this.fenetre = new JFrame();
		//this.fenetre.setLayout(new FlowLayout());
		this.gamepanel = new View();
		
		this.leftMenu = new JPanel();
		this.start = new JButton("Start");
		this.leftMenu.add(start);
		
		fenetre.setSize(new Dimension(screen_sizeX, screen_sizeY));
		fenetre.add(gamepanel);
		//fenetre.add(leftMenu);
		fenetre.addKeyListener(new MyKeyAdapter(this.gamepanel.getSnake()));

		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setTitle("Snake Game by Chaimae");
		fenetre.setLocation(300, 100);
	}
	
	
	public static void main(String[] args) {
		Main game = new Main();
	}

}
