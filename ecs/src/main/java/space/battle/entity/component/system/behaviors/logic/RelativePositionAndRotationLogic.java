package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ChildrenWithRelativePositionBehavior;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionBehavior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativePositionAndRotationLogic {
	private Map<ChildrenWithRelativePositionBehavior, List<RelativePositionBehavior>> parentChildren = new HashMap<>();

	void addEntity (@NotNull ChildrenWithRelativePositionBehavior entity) {
		parentChildren.put(entity, new ArrayList<>());
	}

	void addEntity (@NotNull RelativePositionBehavior entity) {
		List<RelativePositionBehavior> children = parentChildren.get(entity.getParentWithPosition());
		if(children == null) {
			throw new IllegalArgumentException(String.format("The parent %s specified by %s was not found in %s. Make sure you add the parent entity implementing %s with %s before adding any child entity implementing %s referencing the parent.", (Object) entity.getParentWithPosition(), (Object) entity, "space.battle.entity.component.system.behaviors.logic.RelativePositionAndRotationLogic.parentChildren", ChildrenWithRelativePositionBehavior.class, "space.battle.entity.component.system.behaviors.logic.BehaviorLogic.addEntity()", RelativePositionBehavior.class));
		}
		children.add(entity);
	}

	void update () {
		for (Map.Entry<ChildrenWithRelativePositionBehavior, List<RelativePositionBehavior>> parentChildrenPair : parentChildren.entrySet()) {
			ChildrenWithRelativePositionBehavior parent = parentChildrenPair.getKey();
			Vector2 parentPosition = parent.getPosition();
			List<RelativePositionBehavior> children = parentChildrenPair.getValue();

			for (RelativePositionBehavior child : children) {
				Vector2 relativePosition = child.getRelativePosition();
				Vector2 childPosition = child.getPosition();

				childPosition.x = relativePosition
			}
		}
	}
}
