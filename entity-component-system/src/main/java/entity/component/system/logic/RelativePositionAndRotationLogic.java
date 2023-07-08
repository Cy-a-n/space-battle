package entity.component.system.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ParentWithPositionAndRotationBehavior;
import entity.component.system.behaviors.RelativePositionAndRotationBehavior;
import entity.component.system.components.RotationComponent;
import org.jetbrains.annotations.NotNull;

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
	private final @NotNull Map<ParentWithPositionAndRotationBehavior, HashSet<RelativePositionAndRotationBehavior>> parentChildren = new HashMap<>();

	/**
	 * Registers an entity as a parent of RelativePositionAndRotationBehavior entities.
	 *
	 * @param entity - The entity being added as a parent entity.
	 */
	void addEntity (final @NotNull ParentWithPositionAndRotationBehavior entity) {
		parentChildren.put(entity, new HashSet<>());
	}

	/**
	 * Registers an entity as a child of a parent ParentWithPositionAndRotationBehavior entity.
	 * An error is thrown if the parent entity has not been added before the child, or if the parent
	 * with the position is not the same as the parent with rotation degrees.
	 *
	 * @param entity - The entity being added as a child entity.
	 */
	void addEntity (final @NotNull RelativePositionAndRotationBehavior entity) {
		ParentWithPositionAndRotationBehavior parent =
				entity.getRelativePositionAndRotationComponent().getParentWithPositionAndRotationBehavior();

		HashSet<RelativePositionAndRotationBehavior> children = parentChildren.get(parent);
		if (children == null) {
			throw new IllegalArgumentException(String.format("The parent %s specified by %s was not found in %s. Make "
					+ "sure you add the parent entity implementing %s with %s before adding any child entity " +
					"implementing %s referencing the parent.", parent, entity, "space.battle" + ".entity.component" +
					".system.behaviors.logic.RelativePositionAndRotationLogic" + ".parentChildren",
					ParentWithPositionAndRotationBehavior.class, "space" + ".battle.entity" + ".component.system" +
							".behaviors.logic" + ".BehaviorLogic.addEntity()",
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
	void removeEntity (final @NotNull ParentWithPositionAndRotationBehavior entity) {
		HashSet<RelativePositionAndRotationBehavior> children = parentChildren.get(entity);
		if (children != null) {
			for (RelativePositionAndRotationBehavior child : children) {
				// TODO: Remove all children from the ecs
			}
		}

		parentChildren.remove(entity);
	}

	/**
	 * Removes an entity only from its parent's set of entities.
	 *
	 * @param entity - The entity being removed.
	 */
	void removeEntity (final @NotNull RelativePositionAndRotationBehavior entity) {
		ParentWithPositionAndRotationBehavior parent =
				entity.getRelativePositionAndRotationComponent().getParentWithPositionAndRotationBehavior();

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
		for (final @NotNull Map.Entry<ParentWithPositionAndRotationBehavior,
				HashSet<RelativePositionAndRotationBehavior>> parentChildrenPair : parentChildren.entrySet()) {
			final @NotNull ParentWithPositionAndRotationBehavior parent = parentChildrenPair.getKey();
			final @NotNull Vector2 parentPosition = parent.getPositionComponent().getVector2();
			final float parentRotationDegrees = parent.getRotationComponent().getDegrees();
			final @NotNull HashSet<RelativePositionAndRotationBehavior> children = parentChildrenPair.getValue();

			final float angleRadians = MathUtils.degreesToRadians * parentRotationDegrees;
			final float cosTheta = MathUtils.cos(angleRadians);
			final float sinTheta = MathUtils.sin(angleRadians);

			for (final @NotNull RelativePositionAndRotationBehavior child : children) {
				final @NotNull Vector2 relativePosition = child.getRelativePositionAndRotationComponent().getVector2();
				final @NotNull Vector2 resultingRelativePosition = new Vector2();
				final @NotNull Vector2 childPosition = child.getPositionComponent().getVector2();
				final @NotNull RotationComponent childRotationComponent = child.getRotationComponent();

				// TODO: Rotating every frame is kinda inefficient
				resultingRelativePosition.x = relativePosition.x * cosTheta - relativePosition.y * sinTheta;
				resultingRelativePosition.y = relativePosition.x * sinTheta + relativePosition.y * cosTheta;

				childPosition.x = resultingRelativePosition.x + parentPosition.x;
				childPosition.y = resultingRelativePosition.y + parentPosition.y;
				child.getPositionComponent().setChanged(true);

				childRotationComponent.setDegrees(parentRotationDegrees + childRotationComponent.getDegrees());
			}
		}
	}
}

