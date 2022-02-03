import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class GamePanel extends JPanel{
	
	final static int maxX = 16;
	final static int maxY = 16;
	
	private int applex;
	private int appley;
	private int appleNb; //apples eaten by the snake
	
	private int snakeHeadx;
	private int snakeHeady;
	
	private Map<Integer, ArrayList<Integer>> positions;

	
	
	final static Border blackline = BorderFactory.createLineBorder(Color.black);
	private ArrayList<ArrayList<JPanel>> boxes;
	boolean gameOver;
	
	public GamePanel() {
		super(new GridLayout(maxX,maxY));
		appleNb = 0;
		snakeHeady = maxY / 2;
		snakeHeadx = maxX / 2;
		gameOver = false;
		positions = new HashMap();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(snakeHeady);
		positions.put(snakeHeadx, l);

		
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
		while (! this.gameOver) {
			DrawSnake();
			DrawApple();
		}
		
	}
	
	public void move() {
		
	}
	
	public void DrawSnake() {
		for (int x : positions.keySet()) {
			ArrayList<Integer> posY = positions.get(x);
			for (int y : posY) {
				boxes.get(x).get(y).setBackground(Color.green);
			}
		}
	}
	
	public void DrawApple(){
		Random rand = new Random();
		boolean sameAsPrev = false;
		int x = applex;
		int y = appley;
		while (! sameAsPrev) {
			x = rand.nextInt(maxX);
			y = rand.nextInt(maxX);
			sameAsPrev = x == applex && y == appley;
		}
		applex = x;
		appley = y;
		java.net.URL lien = getClass().getResource("apple.png");
		ImageIcon im = new ImageIcon(lien);
		ImageIcon apple = new ImageIcon(im.getImage().getScaledInstance(View.ScreenX / maxX  - 10, View.ScreenY / maxY - 10, Image.SCALE_SMOOTH));
		boxes.get(applex).get(appley).add(new JLabel(apple));
				
	}
	


	
	
	

}
