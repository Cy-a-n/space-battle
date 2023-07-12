package entity.component.system.logic;

import com.badlogic.gdx.graphics.Color;
import entity.component.system.behaviors.VisualCollisionShapeBehavior;
import org.jetbrains.annotations.NotNull;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashSet;
import java.util.Set;

/**
 * The VisualCollisionShapeLogic class keeps track of the entities with visual collision shape behavior.
 * The entities are tracked using a HashSet which offers better performance for adding, removing and checking the
 * presence of entities.
 */
public class VisualCollisionShapeLogic {
	private final @NotNull Set<VisualCollisionShapeBehavior> entities = new HashSet<> ( );

	/**
	 * Adds an entity to the set of entities.
	 *
	 * @param entity the entity to be added to the set
	 */
	void addEntity ( final @NotNull VisualCollisionShapeBehavior entity ) {
		entities.add ( entity );
	}

	/**
	 * Removes a specified entity from the set of entities.
	 *
	 * @param entity the entity to be removed from the set
	 */
	void removeEntity ( final @NotNull VisualCollisionShapeBehavior entity ) {
		entities.remove ( entity );
	}

	/**
	 * Updated the visual collision shapes by drawing each of the entities' shapes.
	 *
	 * @param shapeDrawer tool used for drawing shapes
	 */
	void update ( final @NotNull ShapeDrawer shapeDrawer ) {
		for ( final @NotNull VisualCollisionShapeBehavior entity : entities ) {
			if ( entity.getEntityComponent ().isQueuedForRemoval () )
				continue;

			shapeDrawer.setColor ( Color.DARK_GRAY );
			shapeDrawer.filledRectangle ( entity.getCollisionShapeComponent ( ).getConvexPolygon ( ).getBoundingRectangle ( ) );
			shapeDrawer.setColor ( Color.WHITE );
			shapeDrawer.filledPolygon ( entity.getCollisionShapeComponent ( ).getConvexPolygon ( ).getTransformedVertices ( ) );
		}
	}
}
