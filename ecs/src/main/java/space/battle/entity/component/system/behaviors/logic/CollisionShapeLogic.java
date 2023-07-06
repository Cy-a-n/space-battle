package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Polygon;
import space.battle.entity.component.system.behaviors.interfaces.CollisionShapeBehavior;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing collision shapes in the game.
 */
class CollisionShapeLogic {
	private final Set<CollisionShapeBehavior> entities = new HashSet<>();

	/**
	 * Adds a entity to the set of collision shapes.
	 *
	 * @param entity The entity to be added.
	 */
	void addEntity (@NotNull CollisionShapeBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a entity from the set of collision shapes.
	 *
	 * @param entity The entity to be removed.
	 */
	void removeEntity (@NotNull CollisionShapeBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position, rotation, and origin of each entity based on its current state.
	 * Checks each pair of entities for possible collisions.
	 */
	void update () {
		// Update each entity's position, rotation, and origin based on its current state
		for (CollisionShapeBehavior entity : entities) {
			if (entity.positionChanged())
				entity.getShape().setPosition(entity.getPosition().x - entity.getOrigin().x,
						entity.getPosition().y - entity.getOrigin().y);

			if (entity.rotationChanged())
				entity.getShape().setRotation(entity.getRotationDegrees());

			if (entity.originChanged())
				entity.getShape().setOrigin(entity.getOrigin().x, entity.getOrigin().y);
		}

		// Check each pair of entities for possible collisions
		CollisionShapeBehavior[] entityArray = entities.toArray(new CollisionShapeBehavior[0]);
		for (int i = 0; i < entityArray.length; i++) {
			CollisionShapeBehavior entity0 = entityArray[i];
			Polygon shape0 = entity0.getShape();

			for (int j = i + 1; j < entityArray.length; j++) {
				CollisionShapeBehavior entity1 = entityArray[j];
				Polygon shape1 = entity1.getShape();

				// If the bounding boxes of the two entities overlap, then check for a more precise collision using
				// the Separating Axis Theorem (SAT)
				if (shape1.getBoundingRectangle().overlaps(shape0.getBoundingRectangle())) {
					if (areIntersecting(shape0, shape1)) {
						// Calculate the damage the entities can inflict upon another
						float damage0 = (entity1.getArmorClass() > entity0.effectiveAgainstArmorClass()) ?
								entity0.getHealth() * 0.5f : entity0.getHealth();
						float damage1 = (entity0.getArmorClass() > entity1.effectiveAgainstArmorClass()) ?
								entity1.getHealth() * 0.5f : entity1.getHealth();

						// Divide the health of each entity by the effective damage the other entity inflicts onto it.
						float healthDamageRatio0 = entity0.getHealth() / damage1;
						float healthDamageRatio1 = entity1.getHealth() / damage0;

						if (healthDamageRatio0 < healthDamageRatio1) {
							BehaviorLogic.getInstance().queueEntityForRemoval((Entity) entity0);
							entity1.setHealth(entity1.getHealth() - damage0 * healthDamageRatio0);
							if (entity1.getHealth() < 1)
								BehaviorLogic.getInstance().queueEntityForRemoval(entity1);
						} else {
							BehaviorLogic.getInstance().queueEntityForRemoval((Entity) entity1);
							entity0.setHealth(entity0.getHealth() - damage1 * healthDamageRatio1);
							if (entity0.getHealth() < 1)
								BehaviorLogic.getInstance().queueEntityForRemoval(entity0);
						}
					}
				}
			}
		}
	}

	// Check if two polygons are intersecting by applying the Separating Axis Theorem (SAT)
	private boolean areIntersecting (Polygon shape1, Polygon shape2) {
		float[] vertices1 = shape1.getTransformedVertices();
		float[] vertices2 = shape2.getTransformedVertices();

		// Project all points of both polygons onto a series of axes perpendicular to the edges of the polygons
		for (int i = 0; i < vertices1.length; i += 2) {
			float x1 = vertices1[i];
			float y1 = vertices1[i + 1];

			float x2, y2;
			if (i + 2 < vertices1.length) {
				x2 = vertices1[i + 2];
				y2 = vertices1[i + 3];
			} else {
				x2 = vertices1[0];
				y2 = vertices1[1];
			}

			float axisX = y1 - y2;
			float axisY = x2 - x1;

			// If there exists an axis along which the projections of the two polygons do not overlap, then the
			// polygons do not intersect
			if (!overlap(axisX, axisY, vertices1, vertices2)) {
				return false;
			}
		}

		return true;
	}

	// Check if the projections of the two polygons overlap along the given axis
	private boolean overlap (float axisX, float axisY, float[] vertices1, float[] vertices2) {
		float min1 = project(axisX, axisY, vertices1[0], vertices1[1]);
		float max1 = min1;
		for (int i = 2; i < vertices1.length; i += 2) {
			float p = project(axisX, axisY, vertices1[i], vertices1[i + 1]);
			if (p < min1) {
				min1 = p;
			} else if (p > max1) {
				max1 = p;
			}
		}

		float min2 = project(axisX, axisY, vertices2[0], vertices2[1]);
		float max2 = min2;
		for (int i = 2; i < vertices2.length; i += 2) {
			float p = project(axisX, axisY, vertices2[i], vertices2[i + 1]);
			if (p < min2) {
				min2 = p;
			} else if (p > max2) {
				max2 = p;
			}
		}

		return !(min1 > max2 || max1 < min2);
	}

	// Project a point onto an axis
	private float project (float axisX, float axisY, float x, float y) {
		float dotProduct = (x * axisX + y * axisY) / (axisX * axisX + axisY * axisY);
		return dotProduct * axisX + dotProduct * axisY;
	}
}

