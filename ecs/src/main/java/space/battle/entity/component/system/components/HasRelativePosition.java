package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public interface HasRelativePosition extends HasPosition {
	@NotNull Vector2 getRelativePosition ();

	@NotNull HasChildrenWithRelativePosition getParentWithPosition();
}
