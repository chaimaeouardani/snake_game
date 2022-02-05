

import java.awt.LayoutManager;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
	final static int screen_size = 500;
	final static int game_size = 400;
	final static int snake_unit = 20;
	final static int nb_unit = game_size / snake_unit;
	
	private JFrame fenetre;
	private Timer t;
	private Snake snake;
	private JPanel[][] gamePanels;
	
	public Game() {
		super(new GridLayout(nb_unit, nb_unit));
		super.setBackground(Color.black);
		super.setPreferredSize(new Dimension(game_size ,game_size));
		
		
		fenetre = new JFrame();
		fenetre.setSize(new Dimension(screen_size, screen_size));
		fenetre.add(this);
		fenetre.setVisible(true);
		
		for (int i=0; i<nb_unit; i++) {
			for (int j=0; j<nb_unit; j++) {
				gamePanels[i][j] = new JPanel();
				
				
			}
		}
		
		snake = new Snake(game_size / 2, game_size/2, 3);
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
	}
}
