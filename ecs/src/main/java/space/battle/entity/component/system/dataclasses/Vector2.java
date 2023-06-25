package space.battle.entity.component.system.dataclasses;

/**
 * A very simple vector 2d class, since I don't need anything complex.
 */
public class Vector2 {
	float x;
	float y;

	public Vector2 (float x, float y) {
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
