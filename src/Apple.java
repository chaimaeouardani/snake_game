

import java.util.Random;

public class Apple {
	private Random rand;
	private int x;
	private int y;
	private int max;
	
	public Apple(int nb) {
		this.rand = new Random();
		this.x = rand.nextInt(nb);
		this.y = rand.nextInt(nb);
		this.max = nb;
	}
	
	public void NewPosition() {
		this.x = rand.nextInt(this.max);
		this.y = rand.nextInt(this.max);

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
