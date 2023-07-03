package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public interface HasPosition {
	@NotNull Vector2 getPosition ();

	boolean positionChanged();

	void setPositionChanged(boolean positionChanged);
}
