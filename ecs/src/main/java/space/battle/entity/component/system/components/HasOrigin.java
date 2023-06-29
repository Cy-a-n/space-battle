package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public interface HasOrigin {
	@NotNull Vector2 getOrigin ();
}
