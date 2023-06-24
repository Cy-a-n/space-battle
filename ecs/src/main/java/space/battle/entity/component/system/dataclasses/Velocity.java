package space.battle.entity.component.system.dataclasses;

public class Velocity {
	private float x;
	private float y;

	public Velocity (float x, float y) {
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
