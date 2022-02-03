import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;


public class MainPanel extends JPanel implements ActionListener{
	
	final static int Nunits = 16;
	final static int boxsize = View.ScreenX / Nunits;
	final static Border blackline = BorderFactory.createLineBorder(Color.black);
	static Random rand;
	
	private int applex;
	private int appley;
	private int score; //apples eaten by the snake
	boolean gameOver;	
	private Snake snake;	
	private Direction newDirection = Direction.Right; 
	private int[] x;
	private int[] y;
	private int bodyparts = 3;
	
	public MainPanel() {
		super(new GridLayout(Nunits, Nunits));
		super.setBackground(Color.DARK_GRAY);
		this.gameOver = false;
		this.rand = new Random();
		x = new int[Nunits];
	    y = new int[Nunits];
		play();
		
	}
	
	public void play() {
		getApple();
		
	}
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		this.draw(g);
	}
	
	public void draw(Graphics g) {
		//Draw apple
		/*java.net.URL lien = getClass().getResource("apple.png");
		ImageIcon im = new ImageIcon(lien);
		g.drawImage(im.getImage(), applex+2, appley+5,boxsize - 15 , boxsize - 15, getFocusCycleRootAncestor());
		*/
		System.out.println(applex);
		g.fillOval(applex, appley, boxsize, boxsize);
		g.setColor(Color.red);
		
		//draw snake
		for (int i=0; i<=this.bodyparts; i++) {
			g.fillRect(x[i], y[i], boxsize, boxsize);
			g.setColor(Color.green);
		}
		
		
		
	}
	
	public void getApple() {
		applex = rand.nextInt(Nunits);
		appley = rand.nextInt(Nunits);
	}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
