import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class GamePanel extends JPanel implements ActionListener{
	
	final static int maxX = 16;
	final static int maxY = 16;
	final static Border blackline = BorderFactory.createLineBorder(Color.black);
	static Random rand;
	
	private int applex;
	private int appley;
	private int score; //apples eaten by the snake
	boolean gameOver;	
	private Snake snake;	
	private ArrayList<ArrayList<JPanel>> boxes;
	private Direction newDirection = Direction.Right; 
	
	public GamePanel() {
		super(new GridLayout(maxX,maxY));
		score = 0;
		gameOver = false;
		
		boxes = new ArrayList<ArrayList<JPanel>>();
		for (int i=0; i<maxX; i++) {
			ArrayList<JPanel> temp = new ArrayList<JPanel>();
			for (int j=0; j<maxY; j++) {
				JPanel box = new JPanel();
				box.setBackground(Color.DARK_GRAY);
				box.setBorder(blackline);
				super.add(box);
				temp.add(box);
			}
			boxes.add(temp);
		}
		
		//main
		this.snake = new Snake(maxX / 2, maxY / 2, Direction.Up);
		//startGame();
		this.DrawSnake();
		this.DrawApple();
	}
	
	
	public void startGame() {
		this.DrawSnake();
		this.DrawApple();
		//this.moveSnake();
		

	
	//}
	
	}
	public void moveSnake() {
		if (this.snake.getDirection() != this.newDirection) {
			this.snake.Move(newDirection);
			super.repaint();
			DrawSnake();
		}
	}
	
	
	public void DrawSnake() {
		//super.repaint();
		for (int x : this.snake.getPositionsX()) {
			for (int y : this.snake.getPositionsY()) {
				boxes.get(x).get(y).setBackground(Color.green);
			}
		}
	}
	
	
	public void DrawApple(){
		rand = new Random();
		/*boolean sameAsPrev = false;
		int x = applex;
		int y = appley;
		while (! sameAsPrev) {
			x = rand.nextInt(maxX);
			y = rand.nextInt(maxY);
			sameAsPrev = x == applex && y == appley;
		}*/
		applex = rand.nextInt(maxX);
		appley = rand.nextInt(maxY);
		java.net.URL lien = getClass().getResource("apple.png");
		ImageIcon im = new ImageIcon(lien);
		ImageIcon apple = new ImageIcon(im.getImage().getScaledInstance(View.ScreenX / maxX  - 10, View.ScreenY / maxY - 10, Image.SCALE_SMOOTH));
		boxes.get(applex).get(appley).add(new JLabel(apple));
				
	}
	
	//check if player changed the direction of the snake
	public void checkGameInputs(KeyEvent e) {
		if(e.getKeyCode()==38) {
			if (snake.getDirection() != Direction.Down) {
				newDirection = Direction.Up;
			}
			
		}else if(e.getKeyCode()==40) {
			if (snake.getDirection() != Direction.Up) {
				newDirection = Direction.Down;
			}
			
		}else if(e.getKeyCode()==37) {
			if (snake.getDirection() != Direction.Right) {
				newDirection = Direction.Left;
			}
			
		}else if(e.getKeyCode()==39) {
			if (snake.getDirection() != Direction.Left) {
				newDirection = Direction.Right;
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
