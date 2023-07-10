package entity.component.system.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ParentWithPositionRotationBehavior;
import entity.component.system.behaviors.PositionRotationBehavior;
import entity.component.system.behaviors.RelativePositionRotationBehavior;
import entity.component.system.components.PositionRotationComponent;
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
	private final @NotNull Map<ParentWithPositionRotationBehavior, HashSet<RelativePositionRotationBehavior>> parentChildrenEntities =
			new HashMap<> ();

	void addEntity (ParentWithPositionRotationBehavior entity) {
		parentChildrenEntities.put (entity, new HashSet<> ());
	}

	/**
	 * Adds an entity to the parent's set of children entities. If the parent does not have a set of children entities
	 * yet,
	 * a new set is created and the entity is added to it. If the entity is not part of the BehaviorLogic instance,
	 * an IllegalArgumentException is thrown.
	 *
	 * @param entity The entity to be added. This entity should have a RelativePositionRotationBehavior and should be
	 *               part of the BehaviorLogic instance.
	 * @throws IllegalArgumentException if the entity is not part of the BehaviorLogic instance.
	 */
	void addEntity (final @NotNull RelativePositionRotationBehavior entity) {
		ParentWithPositionRotationBehavior parent = entity.getRelativePositionAndRotationComponent ().getParentWithPositionRotationBehavior ();

		if (!BehaviorLogic.getInstance ().containsEntity (parent)) {
			BehaviorLogic.getInstance ().addEntity (parent);
		}
		parentChildrenEntities.get (parent).add (entity);
	}

	/**
	 * Removes an entity and all of its child entities.
	 * The entities are also to be removed from the ECS, which is a task to be added later.
	 *
	 * @param entity - The entity and its children being removed.
	 */
	void removeEntity (final ParentWithPositionRotationBehavior entity) {
		HashSet<RelativePositionRotationBehavior> children = parentChildrenEntities.get (entity);
		if (children != null) {
			for (RelativePositionRotationBehavior child : children) {
				BehaviorLogic.getInstance ().removeEntity (child);
			}
		}

		parentChildrenEntities.remove (entity);
	}

	/**
	 * Removes an entity only from its parent's set of entities.
	 *
	 * @param entity - The entity being removed.
	 */
	void removeEntity (final @NotNull RelativePositionRotationBehavior entity) {
		PositionRotationBehavior parent = entity.getRelativePositionAndRotationComponent ().getParentWithPositionRotationBehavior ();

		HashSet<RelativePositionRotationBehavior> children = parentChildrenEntities.get (parent);
		if (children != null) {
			children.remove (entity);
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
		for (final Map.Entry<ParentWithPositionRotationBehavior, HashSet<RelativePositionRotationBehavior>> parentChildrenPair :
				parentChildrenEntities.entrySet ()) {
			final ParentWithPositionRotationBehavior parent = parentChildrenPair.getKey ();
			final @NotNull PositionRotationComponent parentPositionRotationComponent = parent.getPositionRotationComponent ();
			final @NotNull Vector2 parentPosition = parentPositionRotationComponent.getPosition ();
			final @NotNull HashSet<RelativePositionRotationBehavior> children = parentChildrenPair.getValue ();

			final float parentRadians = MathUtils.degreesToRadians * parentPositionRotationComponent.getDegrees ();
			final float cosTheta = MathUtils.cos (parentRadians);
			final float sinTheta = MathUtils.sin (parentRadians);

			for (final @NotNull RelativePositionRotationBehavior child : children) {
				final @NotNull Vector2 relativePosition = child.getRelativePositionAndRotationComponent ().getPosition ();
				final @NotNull Vector2 resultingRelativePosition = new Vector2 ();
				final @NotNull PositionRotationComponent childPositionRotationComponent = child.getPositionRotationComponent ();
				final @NotNull Vector2 childPosition = childPositionRotationComponent.getPosition ();

				// TODO: Rotating every frame is kinda inefficient
				resultingRelativePosition.x = relativePosition.x * cosTheta - relativePosition.y * sinTheta;
				resultingRelativePosition.y = relativePosition.x * sinTheta + relativePosition.y * cosTheta;

				childPosition.x = resultingRelativePosition.x + parentPosition.x;
				childPosition.y = resultingRelativePosition.y + parentPosition.y;
				child.getPositionRotationComponent ().setChanged (true);

				childPositionRotationComponent.setDegrees (
						parentPositionRotationComponent.getDegrees () + child.getRelativePositionAndRotationComponent ().getDegrees ());
			}
		}
	}
}

