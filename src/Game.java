

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Game extends JPanel implements ActionListener{
	final static int screen_size = 700;
	final static int game_size = 500;
	final static int snake_unit = 20;
	final static int nb_unit = game_size / snake_unit;
	final static Border blackline = BorderFactory.createLineBorder(Color.gray);

	private JFrame fenetre;
	private Timer t;
	private Snake snake;
	//private JPanel[][] gamePanels;
	private boolean appleEaten = true;
	private boolean gameover = false;
	private Apple apple;
	
	public Game() {
		super(new GridLayout(nb_unit, nb_unit));
		super.setPreferredSize(new Dimension(game_size ,game_size));		
		
		fenetre = new JFrame();
		/*this.gamePanels = new JPanel[nb_unit][nb_unit];
		for (int i=0; i<nb_unit; i++) {
			for (int j=0; j<nb_unit; j++) {
				gamePanels[i][j] = new JPanel();
				gamePanels[i][j].setBorder(blackline);
				gamePanels[i][j].setBackground(Color.black);
				super.add(gamePanels[i][j]);
				
			}
		}*/
		
				
		snake = new Snake(nb_unit / 2, nb_unit/2, 5);
		//timer for updating the graphics
		t = new Timer(100, this);
		//t.start();
		startGame();
		
		fenetre.setSize(new Dimension(screen_size, screen_size));
		fenetre.add(this);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	public void startGame() {
		while (! this.gameover) {
			if (this.appleEaten) {
				this.apple = new Apple(nb_unit);
			}
			this.gameover = this.snake.isGameOver(nb_unit, game_size);
			//check if snake can eat apple
			if (this.snake.getPositionsX()[0] == this.apple.getX() && 
					this.snake.getPositionsY()[0] == this.apple.getY()) {
				this.snake.EatApple();
				this.appleEaten = true;
			}else {
				this.appleEaten = false;
			}
			//Direction nd = checkPlayerInput();
			//this.snake.Move(nd);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(20,20,game_size, game_size);
		
		//draw the snake
		int s = snake.getBodysize();
		for (int i=0; i<s; i++) {
			int x = snake.getPositionsX()[i];
			int y = snake.getPositionsY()[i];
			g.fillRect(x*snake_unit,y*snake_unit, snake_unit, snake_unit);
			if (i==0) {
				g.setColor(new Color( 137, 238, 119 ));
			}else {
			g.setColor(Color.green);
			}
		}
		
		//draw apple
		g.setColor(Color.red);
		g.fillOval(this.apple.getX()*snake_unit, this.apple.getY()*snake_unit, snake_unit, snake_unit);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	public static void main(String[] args) {
		Game g = new Game();
	}

	
}
