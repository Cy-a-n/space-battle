package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.PositionBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * PositionLogic class manages the entities having the behavior of positions.
 * It holds a set of all PositionBehavior entities, allowing for easy addition and removal.
 */
class PositionLogic {
	private Set<PositionBehavior> entities = new HashSet<>();

	/**
	 * Adds a new PositionBehavior entity to the set.
	 *
	 * @param entity Entity to add
	 */
	void addEntity (PositionBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a PositionBehavior entity from the set.
	 *
	 * @param entity Entity to remove
	 */
	void removeEntity (PositionBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the entities' position change status to false.
	 */
	void update () {
		for (PositionBehavior entity : entities) {
			entity.setPositionChanged(false);
		}
	}
}
