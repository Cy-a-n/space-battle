package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionAndRotationBehavior;

import java.util.ArrayList;
import java.util.List;

public class RelativePositionAndRotationLogic {
	private List<RelativePositionAndRotationBehavior> entities = new ArrayList<>();

	void addEntity (@NotNull RelativePositionAndRotationBehavior entity) {
		entities.add(entity);
	}

	void update () {
		for (RelativePositionAndRotationBehavior entity : entities) {
			Vector2 parentPosition = entity.getParentWithPosition().getPosition();
			float parentRotationDegrees = entity.getParentWithRotationDegrees().getRotationDegrees();
			Vector2 position = entity.getPosition();
			Vector2 relativePosition = entity.getRelativePosition();
			float relativeRotationDegrees = entity.getRelativeRotationDegrees();

			position.x = parentPosition.x + relativePosition.x;
			position.y = parentPosition.y + relativePosition.y;

			entity.setRotationDegrees(parentRotationDegrees + relativeRotationDegrees);
		}
	}
}
