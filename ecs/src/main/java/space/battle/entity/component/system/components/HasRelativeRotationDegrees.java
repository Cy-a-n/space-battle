package space.battle.entity.component.system.components;

import org.jetbrains.annotations.NotNull;

public interface HasRelativeRotationDegrees {
	float getRelativeRotationDegrees ();

	void setRelativeRotationDegrees (float relativeRotationDegrees);

	@NotNull HasRotationDegrees getParentWithRotationDegrees ();
}
