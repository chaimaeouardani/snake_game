import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;

public class Main {
	final static int screen_sizeX = View.game_size;
	final static int screen_sizeY = View.game_size;
	final static int pos = 100;
	static JFrame fenetre;
	private View gamepanel;
	private JPanel leftMenu;
	private JButton start;
	private JButton replay;
	private JLabel score;
	
	
	public Main() {
		this.fenetre = new JFrame();
		this.fenetre.setLayout(new GridLayout(1,2));
		this.gamepanel = new View();
		this.leftMenu = new JPanel(new GridLayout(5, 1));
		this.start = new JButton("Start");
		this.replay = new JButton("Replay");
		this.score = new JLabel("Score :");

		this.leftMenu.add(score);
		this.leftMenu.add(start);
		this.leftMenu.add(replay);
		
		fenetre.setSize(new Dimension(screen_sizeX, screen_sizeY));
		fenetre.add(gamepanel);
		leftMenu.setPreferredSize(new Dimension (screen_sizeX - View.game_size - 50, screen_sizeY));
		leftMenu.setLocation(View.game_size + 50, 0);
		
		fenetre.addKeyListener(new MyKeyAdapter(this.gamepanel.getSnake()));

		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setTitle("Snake Game by Chaimae");
		fenetre.setLocation(2*pos, pos);
		fenetre.setResizable(false);
	}
	
	public static void main(String[] args) {
		Main game = new Main();
	}

}
