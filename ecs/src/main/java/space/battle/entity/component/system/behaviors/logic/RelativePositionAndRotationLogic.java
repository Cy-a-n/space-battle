package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ParentWithRelativePositionAndRotationDegreesBehavior;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionAndRotationBehavior;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

/**
 * This class is responsible for processing relative position and rotation logic.
 */
class RelativePositionAndRotationLogic {
	/**
	 * Stores entities and their children. The HashSet allows O(1) complexity for removal operations.
	 */
	private final Map<ParentWithRelativePositionAndRotationDegreesBehavior,
			HashSet<RelativePositionAndRotationBehavior>> parentChildren = new HashMap<>();

	/**
	 * Registers an entity as a parent of RelativePositionAndRotationBehavior entities.
	 *
	 * @param entity - The entity being added as a parent entity.
	 */
	void addEntity (@NotNull ParentWithRelativePositionAndRotationDegreesBehavior entity) {
		parentChildren.put(entity, new HashSet<>());
	}

	/**
	 * Registers an entity as a child of a parent ParentWithRelativePositionAndRotationDegreesBehavior entity.
	 * An error is thrown if the parent entity has not been added before the child, or if the parent
	 * with the position is not the same as the parent with rotation degrees.
	 *
	 * @param entity - The entity being added as a child entity.
	 */
	void addEntity (@NotNull RelativePositionAndRotationBehavior entity) {
		ParentWithRelativePositionAndRotationDegreesBehavior parent = entity.getParentWithPositionAndRotationDegrees();

		HashSet<RelativePositionAndRotationBehavior> children = parentChildren.get(parent);
		if (children == null) {
			throw new IllegalArgumentException(String.format("The parent %s specified by %s was not found in %s. Make "
					+ "sure you add the parent entity implementing %s with %s before adding any child entity " +
					"implementing %s referencing the parent.", parent, entity, "space.battle" + ".entity.component" +
					".system.behaviors.logic.RelativePositionAndRotationLogic" + ".parentChildren",
					ParentWithRelativePositionAndRotationDegreesBehavior.class, "space" + ".battle.entity" +
							".component.system.behaviors.logic" + ".BehaviorLogic.addEntity()",
					RelativePositionAndRotationBehavior.class));
		}
		children.add(entity);
	}

	/**
	 * Removes an entity and all of its child entities.
	 * The entities are also to be removed from the ECS, which is a task to be added later.
	 *
	 * @param entity - The entity and its children being removed.
	 */
	void removeEntity (@NotNull ParentWithRelativePositionAndRotationDegreesBehavior entity) {
		HashSet<RelativePositionAndRotationBehavior> children = parentChildren.get(entity);
		if (children != null) {
			for (RelativePositionAndRotationBehavior child : children)
				BehaviorLogic.getInstance().removeEntity(child);
		}

		parentChildren.remove(entity);
	}

	/**
	 * Removes an entity only from its parent's set of entities.
	 *
	 * @param entity - The entity being removed.
	 */
	void removeEntity (@NotNull RelativePositionAndRotationBehavior entity) {
		ParentWithRelativePositionAndRotationDegreesBehavior parent = entity.getParentWithPositionAndRotationDegrees();

		HashSet<RelativePositionAndRotationBehavior> children = parentChildren.get(parent);
		if (children != null) {
			children.remove(entity);
		}
	}

	/**
	 * Updates the position and rotation of all child entities relative to their parent entities.
	 * This method iterates over each parent-child pair in the parentChildren map. For each child, it updates its
	 * position
	 * and rotation based on its relative position and rotation to the parent. The rotation is calculated using the
	 * cosine
	 * and sine of the parent's rotation angle.
	 */
	void update () {
		for (Map.Entry<ParentWithRelativePositionAndRotationDegreesBehavior,
				HashSet<RelativePositionAndRotationBehavior>> parentChildrenPair : parentChildren.entrySet()) {
			ParentWithRelativePositionAndRotationDegreesBehavior parent = parentChildrenPair.getKey();
			Vector2 parentPosition = parent.getPosition();
			float parentRotationDegrees = parent.getRotationDegrees();
			HashSet<RelativePositionAndRotationBehavior> children = parentChildrenPair.getValue();

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

