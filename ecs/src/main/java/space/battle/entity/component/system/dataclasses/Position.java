package space.battle.entity.component.system.dataclasses;

public class Position {
	private float x;
	private float y;

	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public float getX () {
		return x;
	}

	public void setX (float x) {
		this.x = x;
	}

	public float getY () {
		return y;
	}

	public void setY (float y) {
		this.y = y;
	}
}
