package space.battle.entity.component.system.components;

import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;

public interface HasCollisionShape {
	@NotNull Polygon getCollisionShape ();

	int getTeamId ();

	void setTeamId (int teamId);
}
