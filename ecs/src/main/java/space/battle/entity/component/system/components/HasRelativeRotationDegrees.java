package space.battle.entity.component.system.components;

import org.jetbrains.annotations.NotNull;

public interface HasRelativeRotationDegrees extends HasRotationDegrees {
	float getRelativeRotationDegrees ();

	void setRelativeRotationDegrees (float relativeRotationDegrees);

	@NotNull HasChildrenWithRelativeRotationDegrees getParentWithRotationDegrees();
}
