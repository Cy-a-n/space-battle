package entity.component.system.components;

public class LifeTimeComponent {
	private long startTimeMilliseconds;
	private float milliseconds;

	public LifeTimeComponent ( final float milliseconds ) {
		this.milliseconds = milliseconds;
	}

	public long getStartTimeMilliseconds ( ) {
		return startTimeMilliseconds;
	}

	public void setStartTimeMilliseconds ( final long startTimeMilliseconds ) {
		this.startTimeMilliseconds = startTimeMilliseconds;
	}

	public float getMilliseconds ( ) {
		return milliseconds;
	}

	public void setMilliseconds ( final float milliseconds ) {
		this.milliseconds = milliseconds;
	}
}
