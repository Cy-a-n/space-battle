package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionBehavior;
import space.battle.entity.component.system.components.HasRelativePosition;

import java.util.ArrayList;
import java.util.List;

public class RelativePositionLogic {
	private List<RelativePositionBehavior> entities = new ArrayList<>();

	void addEntity (@NotNull RelativePositionBehavior entity) {
		entities.add(entity);
	}

	void update () {
		for (RelativePositionBehavior entity : entities) {
			List<HasRelativePosition> children = entity.getRelativePositionParentChildrenRelationship().getChildren();
			Vector2 parentPosition = entity.getPosition();

			for (HasRelativePosition child : children) {
				Vector2 childPosition = child.getPosition();
				Vector2 childRelativePosition = child.getRelativePosition();

				childPosition.x = parentPosition.x + childRelativePosition.x;
				childPosition.y = parentPosition.y + childRelativePosition.y;
			}
		}
	}
}
