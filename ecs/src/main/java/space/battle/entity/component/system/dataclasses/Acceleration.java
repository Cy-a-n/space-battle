package space.battle.entity.component.system.dataclasses;

public class Acceleration {
	private float x;
	private float y;

	public Acceleration (float x, float y) {
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
