import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum Direction {Left, Up, Down, Right};


public class Snake {
	
	private int appleNb; //apples eaten by the snake
	
	private int snakeHeadx;
	private int snakeHeady;
	
	private Direction currDirection;
	
	private ArrayList<Integer> positionsX;
	private ArrayList<Integer> positionsY;

	
	public Snake(int x, int y, Direction curd) {
		this.appleNb = 0;
		this.snakeHeadx = x;
		this.snakeHeady = y;
		this.positionsX = new ArrayList<Integer>();
		this.positionsX.add(x);
		this.positionsY = new ArrayList<Integer>();
		this.positionsY.add(y);
		
		this.currDirection = curd;
		
	}
	
	public void setDirection(Direction nd) {
		this.currDirection = nd;
	}
	
	public Direction getDirection() {
		return this.currDirection;
	}
	
	public ArrayList<Integer> getPositionsX() {
		return positionsX;
	}

	public void setPositionsX(ArrayList<Integer> positionsX) {
		this.positionsX = positionsX;
	}

	public ArrayList<Integer> getPositionsY() {
		return positionsY;
	}

	public void setPositionsY(ArrayList<Integer> positionsY) {
		this.positionsY = positionsY;
	}
	
	
	public void EatApple() {
		if (this.currDirection == Direction.Down) {
			this.positionsX.add(this.snakeHeadx);
			int lastY = this.positionsY.get(appleNb - 1);
			this.positionsY.add(lastY + 1);
		}
		else if (this.currDirection == Direction.Up) {
			this.positionsX.add(this.snakeHeadx);
			int lastY = this.positionsY.get(appleNb - 1);
			this.positionsY.add(lastY - 1);
		}
		else if (this.currDirection == Direction.Left) {
			this.positionsY.add(this.snakeHeady);
			int lastX = this.positionsX.get(appleNb - 1);
			this.positionsY.add(lastX + 1);
		}
		else if (this.currDirection == Direction.Right) {
			this.positionsY.add(this.snakeHeady);
			int lastX = this.positionsX.get(appleNb - 1);
			this.positionsY.add(lastX - 1);
		}
	}
	
	
	public void Move(Direction d) {
			if (d == Direction.Up || d == Direction.Down) {
				for (int i=0; i < this.appleNb+1; i++) {
					int x = positionsX.get(i);
					
					if (this.currDirection == Direction.Right && x < this.snakeHeadx) {
						this.positionsX.set(i, x+1);
					}
					else if (this.currDirection == Direction.Left && x > this.snakeHeadx) {
						this.positionsX.set(i, x-1);
					}
					else {
						int y = this.positionsY.get(i);
						
						if (d == Direction.Up) {
							this.positionsY.set(i,  y+1);

						}else {
							this.positionsY.set(i,  y-1);
	
						}
					}
				}
			}else {
				for (int i=0; i < this.appleNb+1; i++) {
					int y = positionsY.get(i);
					
					if (this.currDirection == Direction.Up && y < this.snakeHeady) {
						this.positionsY.set(i, y+1);
					}
					else if (this.currDirection == Direction.Down && y > this.snakeHeady) {
						this.positionsY.set(i, y-1);
					}
					else {
						int x = this.positionsX.get(i);
						
						if (d == Direction.Left) {
							this.positionsX.set(i,  x-1);

						}else {
							this.positionsX.set(i,  x+1);
	
						}
					}
					
				}
			}
			this.currDirection = d;
			
			}
			// debug
			

			
		
		
	
	public static void main(String[] args) {
		Snake s = new Snake(5,5,Direction.Up);
		ArrayList<Integer> l = new ArrayList<>();
		s.Move(Direction.Up);
	}
}
