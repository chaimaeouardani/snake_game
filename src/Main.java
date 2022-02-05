import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener{
	
	final static int screen_sizeX = 800;
	final static int screen_sizeY = 600;

	private JFrame fenetre;
	private View gamepanel;
	
	public Main() {
		this.fenetre = new JFrame();
		this.gamepanel = new View();
		this.addKeyListener(new KeyAdapter());
		fenetre.setSize(new Dimension(screen_sizeX, screen_sizeY));
		fenetre.add(gamepanel);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setTitle("Snake Game by Chaimae");
		fenetre.setLocation(300, 100);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		Direction currD = this.gamepanel.getSnake().getDirection();
		Direction nd = null;
		
		if(this.gamepanel.isRunning()) {
			System.out.println("inside");
			if(keyCode == KeyEvent.VK_UP && currD != Direction.Down) {
				nd = Direction.Up;
			}
			if(keyCode == KeyEvent.VK_DOWN && currD != Direction.Up) {
				nd = Direction.Down;
			}
		
			if(keyCode == KeyEvent.VK_LEFT && currD != Direction.Right) {
				nd = Direction.Left;
			}
		
			if(keyCode == KeyEvent.VK_RIGHT && currD != Direction.Left) {
				nd = Direction.Right;
			}
			//update direction
			if (nd != null) {
				this.gamepanel.getSnake().setDirection(nd);
			}
		}
		
	}
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Main game = new Main();
	}

}
