

import java.util.Random;

public class Apple {
	private Random rand;
	private int x;
	private int y;
	
	public Apple(int nb) {
		this.x = rand.nextInt(nb);
		this.y = rand.nextInt(nb);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
