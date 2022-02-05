


enum Direction {Left, Up, Down, Right};

public class Snake {

	private Direction currDirection;
	
	private int[] positionsX;
	private int[] positionsY;
	
	private int body;

	
	public Snake(int x, int y, int nb) {
		this.currDirection = Direction.Right;
		this.positionsX = new int[500];
		this.positionsY = new int[500];
		this.body = nb;
		for (int i=0; i<nb; i++) {
			this.positionsX[i] = x - i;
			this.positionsY[i] = y;
		}
	}

	// adding new part for the body
	public void EatApple() {
		if (this.currDirection == Direction.Down) {	
			this.positionsX[body] = this.positionsX[body-1];
			this.positionsY[body] = this.positionsY[body-1] - 1;
		}
		else if (this.currDirection == Direction.Up) {
			this.positionsX[body] = this.positionsX[body-1];
			this.positionsY[body] = this.positionsY[body-1] + 1;
		}
		else if (this.currDirection == Direction.Left) {
			this.positionsX[body] = this.positionsX[body-1] + 1;
			this.positionsY[body] = this.positionsY[body-1] ;
		}
		else {
			this.positionsX[body] = this.positionsX[body-1] - 1;
			this.positionsY[body] = this.positionsY[body-1] ;
		}
		this.body++;
	}
	
	//Moving the snake
	public void Move(Direction d) {
			for (int i=this.body; i>0; i--) {
				this.positionsY[i] = this.positionsY[i-1];
				this.positionsX[i] = this.positionsX[i-1];
			}
			switch (d) {
				case Up:
					this.positionsY[0]--;
					break;
				case Down:
					this.positionsY[0]++;
					break;
				case Right:
					this.positionsX[0]++;
					break;
				case Left:
					this.positionsX[0]--;
					break;
				}
	}
	
	//check collisions with wall and body parts
	public boolean isGameOver(int maxX, int maxY) {
		
		boolean colliededW = this.positionsX[0] < 0 || this.positionsX[0] > maxX
				|| this.positionsY[0] < 0 || this.positionsY[0] > maxY ;
		
		if (colliededW) {
			return true;
		}else {
			for (int i=1; i<this.body; i++) {
				if ( positionsX[i] == positionsX[0] && positionsY[i] == positionsY[0]) {
					System.out.println("body");
					return true;
				}
			}
			return false;
		}
	}
						
	//getters and setters
	
	public int getBodysize() {
		return this.body;
	}
	public void setDirection(Direction nd) {
		this.currDirection = nd;
	}
	
	public Direction getDirection() {
		return this.currDirection;
	}
	
	public int[] getPositionsX() {
		return positionsX;
	}

	public void setPositionsX(int[] npx) {
		this.positionsX = npx;
	}

	public int[] getPositionsY() {
		return positionsY;
	}

	public void setPositionsY(int[] positionsY) {
		this.positionsY = positionsY;
	}
	
}
