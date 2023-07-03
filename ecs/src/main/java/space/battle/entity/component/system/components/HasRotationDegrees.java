package space.battle.entity.component.system.components;

public interface HasRotationDegrees {
	float getRotationDegrees ();

	void setRotationDegrees (float rotationDegrees);

	boolean rotationChanged();
	void setRotationChanged(boolean rotationChanged);
}
