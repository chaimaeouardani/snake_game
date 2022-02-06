import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter{
	
	private Snake snake;
	
	public MyKeyAdapter(Snake s) {
		this.snake = s;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		Direction nd = null;
		
			if(keyCode == KeyEvent.VK_UP && snake.getDirection() != Direction.Down) {
				nd = Direction.Up;
			}
			if(keyCode == KeyEvent.VK_DOWN && snake.getDirection() != Direction.Up) {
				nd = Direction.Down;
			}
		
			if(keyCode == KeyEvent.VK_LEFT && snake.getDirection() != Direction.Right) {
				nd = Direction.Left;
			}
		
			if(keyCode == KeyEvent.VK_RIGHT && snake.getDirection() != Direction.Left) {
				nd = Direction.Right;
			}
			//update direction 
			if (nd != null) {
				this.snake.setDirection(nd);
			}
		}

		
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
}
