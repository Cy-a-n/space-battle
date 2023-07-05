package space.battle.entity.component.system.behaviors.logic;

import org.mockito.internal.matchers.Or;
import space.battle.entity.component.system.behaviors.interfaces.OriginBehavior;
import space.battle.entity.component.system.behaviors.interfaces.PositionBehavior;
import space.battle.entity.component.system.components.HasOrigin;

import java.util.ArrayList;
import java.util.List;

/**
 * The OriginLogic class handles logic related to entities that have an origin in the game.
 * An origin might refer to a starting point or the source of an entity.
 * <p>
 * The class maintains a list of entities that implement the OriginBehavior interface (i.e. entities that have an
 * origin).
 * Each game tick, it can update these entities according to some game logic.
 */
class OriginLogic {
	private List<OriginBehavior> entities = new ArrayList<>();

	/**
	 * The addEntity method adds an entity to the list of entities that have an origin.
	 *
	 * @param entity: This is the entity that will be added to the list. It
	 *                must implement the OriginBehavior interface.
	 */
	void addEntity (OriginBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes an OriginBehavior entity from the set.
	 *
	 * @param entity Entity to remove
	 */
	void removeEntity (OriginBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * The update method updates the state of all entities that have an origin.
	 * Specifically, it resets the originChanged state of all entities to false.
	 */
	void update () {
		for (OriginBehavior entity : entities) {
			entity.setOriginChanged(false);
		}
	}
}
