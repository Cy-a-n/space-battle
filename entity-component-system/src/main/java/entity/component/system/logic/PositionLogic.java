package entity.component.system.logic;

import entity.component.system.behaviors.PositionBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * PositionLogic class manages the entities having the behavior of positions.
 * It holds a set of all PositionBehavior entities, allowing for easy addition and removal.
 */
class PositionLogic {
	private final @NotNull Set<PositionBehavior> entities = new HashSet<>();

	/**
	 * Adds a new PositionBehavior entity to the set.
	 *
	 * @param entity Behavior to add
	 */
	void addEntity (final @NotNull PositionBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a PositionBehavior entity from the set.
	 *
	 * @param entity Behavior to remove
	 */
	void removeEntity (final @NotNull PositionBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the entities' position change status to false.
	 */
	void update () {
		for (final @NotNull PositionBehavior entity : entities) {
			entity.getPositionComponent().setChanged(false);
		}
	}
}
