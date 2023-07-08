package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ParentWithRelativePositionAndRotationDegreesBehavior;

public interface HasRelativePositionAndRotationDegrees extends HasPosition {
	@NotNull Vector2 getRelativePosition ();

	float getRelativeRotationDegrees ();

	void setRelativeRotationDegrees (float relativeRotationDegrees);

	@NotNull ParentWithRelativePositionAndRotationDegreesBehavior getParentWithPositionAndRotationDegrees ();
}
