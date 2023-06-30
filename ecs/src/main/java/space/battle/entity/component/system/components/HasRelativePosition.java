package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.utilities.RelativePositionParentChildrenRelationship;

public interface HasRelativePosition extends HasPosition {
	@NotNull Vector2 getRelativePosition ();

	@NotNull RelativePositionParentChildrenRelationship relativePositionParentChildrenRelationship ();
}
