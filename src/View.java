import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.*;

public class View extends JPanel implements ActionListener{
	
	final static int nb_unit = 40;
	final static int game_size = 600;
	final static int snake_unit = game_size / nb_unit;

	static int update_time = 150;
	private Timer t =  new Timer(update_time, this);
	private Snake snake;
	private boolean gameover = false;
	private Apple apple;
	
	public View() {
		super();
		snake = new Snake(nb_unit / 2, nb_unit/2, 5);
		apple = new Apple(nb_unit-1);
				
		//timer for updating the graphics
		t.start();
	}
	
	public void Play() {
		//check if snake can eat an apple
		if (this.snake.getPositionsX()[0] == this.apple.getX() && 
				this.snake.getPositionsY()[0] == this.apple.getY()) {
			this.snake.EatApple();
			this.apple.NewPosition();
		}
		this.snake.Move();
		this.gameover = this.snake.isGameOver(nb_unit-1, nb_unit-1);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//background
		g.setColor(Color.black);
		g.fillRect(0,0,game_size, game_size);
		
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
			showGO();	
		}

	}
	
	public void showGO() {
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(2,1) );
		f.setTitle("Game Over");
		JLabel score = new JLabel("   Game Over ! Your score is " + this.snake.getScore());
		JButton replay = new JButton("Replay");
		JButton quit = new JButton("Quit");
		JPanel but = new JPanel(new GridBagLayout());
		but.add(replay);
		but.add(quit);
		f.add(score);
		f.add(but);
		f.setSize(new Dimension(400, 200));
		f.setLocation(2*(Main.pos + 50), 3*Main.pos);
		f.toFront();
		f.setVisible(true);
		replay.addActionListener(new replayAction(f));
		quit.addActionListener(new quitAction(f));
	
		}
	public class replayAction implements ActionListener{
		
		private JFrame f;
		
		public replayAction(JFrame f) {
			this.f = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Main.fenetre.dispose();
			this.f.dispose();
			Main m = new Main();				
		}
		
	}

	public class quitAction implements ActionListener{
		private JFrame f;
		
		public quitAction(JFrame f) {
			this.f = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.f.dispose();
			Main.fenetre.dispose();

		}
		

	}

	
}
