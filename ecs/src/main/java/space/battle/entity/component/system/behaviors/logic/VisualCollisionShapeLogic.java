package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.Color;
import org.jetbrains.annotations.NotNull;
import space.earlygrey.shapedrawer.ShapeDrawer;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * The VisualCollisionShapeLogic class keeps track of the entities with visual collision shape behavior.
 * The entities are tracked using a HashSet which offers better performance for adding, removing and checking the
 * presence of entities.
 */
public class VisualCollisionShapeLogic {
	private final Set<VisualCollisionShapeBehavior> entities = new HashSet<>();

	/**
	 * Adds an entity to the set of entities.
	 *
	 * @param entity the entity to be added to the set
	 */
	void addEntity (@NotNull VisualCollisionShapeBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a specified entity from the set of entities.
	 *
	 * @param entity the entity to be removed from the set
	 */
	void removeEntity (VisualCollisionShapeBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updated the visual collision shapes by drawing each of the entities' shapes.
	 *
	 * @param shapeDrawer tool used for drawing shapes
	 */
	void update (@NotNull ShapeDrawer shapeDrawer) {
		shapeDrawer.setColor(Color.DARK_GRAY);
		for (VisualCollisionShapeBehavior entity : entities) {
			shapeDrawer.filledRectangle(entity.getCollisionShape().getBoundingRectangle());
		}

		shapeDrawer.setColor(Color.WHITE);
		for (VisualCollisionShapeBehavior entity : entities) {
			shapeDrawer.filledPolygon(entity.getCollisionShape().getTransformedVertices());
		}
	}
}
