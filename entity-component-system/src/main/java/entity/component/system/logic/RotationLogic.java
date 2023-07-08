package entity.component.system.logic;

import entity.component.system.behaviors.RotationBehavior;
import entity.component.system.components.RotationComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * The RotationLogic class keeps track of entities that have rotation degrees behavior.
 * The entities are stored in a HashSet for efficient add, remove, and lookup operations.
 * The class also provides methods for adding an entity, removing an entity, and updating all entities.
 */
public class RotationLogic {
	private final @NotNull Set<RotationBehavior> entities = new HashSet<>();

	/**
	 * Adds an entity to the HashSet of entities.
	 *
	 * @param entity the entity to be added
	 */
	void addEntity (final @NotNull RotationBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a specified entity from the HashSet of entities.
	 *
	 * @param entity the entity to be removed
	 */
	void removeEntity (final @NotNull RotationBehavior entity) {
		// Remove the entity from the set. This operation is typically faster for a HashSet compared to a List.
		entities.remove(entity);
	}

	/**
	 * Updates all entities in the HashSet by setting their rotationChanged property to false.
	 */
	void update () {
		// Iterate through all entities in the set and update their status.
		for (final @NotNull RotationBehavior entity : entities) {
			final @NotNull RotationComponent rotation = entity.getRotationComponent();

			rotation.setChanged(false);
		}
	}
}
