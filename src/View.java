import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.*;

public class View extends JPanel implements ActionListener{
	
	final static int game_size = 500;
	final static int snake_unit = 20;
	final static int nb_unit = game_size / snake_unit;
	final static Border blackline = BorderFactory.createLineBorder(Color.gray);

	private Timer t =  new Timer(100, this);
	private Snake snake;
	private boolean gameover = false;
	private Apple apple;
	
	public View() {
		super();
		//super.setBackground(Color.black);
		snake = new Snake(nb_unit / 2, nb_unit/2, 5);
		apple = new Apple(nb_unit);
		//timer for updating the graphics
		t.start();
	}
	
	public void Play() {
		//check if snake can eat apple
		if (this.snake.getPositionsX()[0] == this.apple.getX() && 
				this.snake.getPositionsY()[0] == this.apple.getY()) {
			this.snake.EatApple();
			this.apple.NewPosition();
		}
		this.snake.Move(this.snake.getDirection());
		this.gameover = this.snake.isGameOver(nb_unit, game_size);
		
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//background
		g.setColor(Color.black);
		g.fillRect(20,30,game_size, game_size);
		
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
	public Snake getSnake() {
		return this.snake;
	}
	
	public boolean isRunning() {
		return ! this.gameover;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (! this.gameover) {
			this.Play();
		}else {
			t.stop();
		}

	}
	

	
}
