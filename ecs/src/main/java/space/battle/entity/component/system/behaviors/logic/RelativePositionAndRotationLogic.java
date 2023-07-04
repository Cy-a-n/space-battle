package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ChildrenWithRelativePositionAndRotationDegreesBehavior;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionAndRotationBehavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RelativePositionAndRotationLogic {
	private Map<ChildrenWithRelativePositionAndRotationDegreesBehavior, List<RelativePositionAndRotationBehavior>> parentChildren = new HashMap<>();

	void addEntity (@NotNull ChildrenWithRelativePositionAndRotationDegreesBehavior entity) {
		parentChildren.put(entity, new ArrayList<>());
	}

	void addEntity (@NotNull RelativePositionAndRotationBehavior entity) {
		List<RelativePositionAndRotationBehavior> children = parentChildren.get(entity.getParentWithPosition());
		if (children == null)
			throw new IllegalArgumentException(String.format("The parent %s specified by %s was not found in %s. Make "
					+ "sure you add the parent entity implementing %s with %s before adding any child entity " +
					"implementing %s referencing the parent.", entity.getParentWithPosition(), entity,
					"space.battle" + ".entity.component.system.behaviors.logic.RelativePositionAndRotationLogic" +
							".parentChildren", ChildrenWithRelativePositionAndRotationDegreesBehavior.class,
					"space" + ".battle.entity" + ".component.system.behaviors.logic" + ".BehaviorLogic.addEntity()",
					RelativePositionAndRotationBehavior.class));
		children.add(entity);
	}

	void update () {
		for (Map.Entry<ChildrenWithRelativePositionAndRotationDegreesBehavior,
				List<RelativePositionAndRotationBehavior>> parentChildrenPair : parentChildren.entrySet()) {
			ChildrenWithRelativePositionAndRotationDegreesBehavior parent = parentChildrenPair.getKey();
			Vector2 parentPosition = parent.getPosition();
			float parentRotationDegrees = parent.getRotationDegrees();
			List<RelativePositionAndRotationBehavior> children = parentChildrenPair.getValue();

			float angleRadians = MathUtils.degreesToRadians * parentRotationDegrees;
			float cosTheta = MathUtils.cos(angleRadians);
			float sinTheta = MathUtils.sin(angleRadians);

			for (RelativePositionAndRotationBehavior child : children) {
				Vector2 relativePosition = child.getRelativePosition();
				Vector2 resultingRelativePosition = new Vector2();
				Vector2 childPosition = child.getPosition();
				float childRelativeRotationDegrees = child.getRelativeRotationDegrees();

				// TODO: Rotating every frame is kinda inefficient
				resultingRelativePosition.x = relativePosition.x * cosTheta - relativePosition.y * sinTheta;
				resultingRelativePosition.y = relativePosition.x * sinTheta + relativePosition.y * cosTheta;

				childPosition.x = resultingRelativePosition.x + parentPosition.x;
				childPosition.y = resultingRelativePosition.y + parentPosition.y;

				child.setRotationDegrees(parentRotationDegrees + childRelativeRotationDegrees);
			}
		}
	}
}
