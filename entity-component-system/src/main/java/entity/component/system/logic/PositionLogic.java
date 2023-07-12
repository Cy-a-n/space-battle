package entity.component.system.logic;

import entity.component.system.behaviors.PositionRotationBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * PositionLogic class manages the entities having the behavior of positions.
 * It holds a set of all PositionRotationBehavior entities, allowing for easy addition and removal.
 */
class PositionLogic {
	private final @NotNull Set<PositionRotationBehavior> entities = new HashSet<> ( );

	/**
	 * Adds a new PositionRotationBehavior entity to the set.
	 *
	 * @param entity EntityBehavior to add
	 */
	void addEntity ( final @NotNull PositionRotationBehavior entity ) {
		entities.add ( entity );
	}

	/**
	 * Removes a PositionRotationBehavior entity from the set.
	 *
	 * @param entity EntityBehavior to remove
	 */
	void removeEntity ( final @NotNull PositionRotationBehavior entity ) {
		entities.remove ( entity );
	}

	/**
	 * Updates the entities' position change status to false.
	 */
	void update ( ) {
		for ( final @NotNull PositionRotationBehavior entity : entities ) {
			if ( entity.getEntityComponent ().isQueuedForRemoval () )
				continue;

			entity.getPositionRotationComponent ( ).setChanged ( false );
		}
	}
}
