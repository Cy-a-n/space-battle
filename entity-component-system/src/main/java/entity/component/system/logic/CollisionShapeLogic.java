package entity.component.system.logic;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.CollisionShapeBehavior;
import entity.component.system.components.CollisionShapeComponent;
import entity.component.system.components.PositionRotationComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing collision shapes in the game.
 */
class CollisionShapeLogic {
	private final Set<CollisionShapeBehavior> entities = new HashSet<> ( );

	/**
	 * Adds a entity to the set of collision shapes.
	 *
	 * @param entity The entity to be added.
	 */
	void addEntity ( @NotNull CollisionShapeBehavior entity ) {
		entities.add ( entity );
	}

	/**
	 * Removes a entity from the set of collision shapes.
	 *
	 * @param entity The entity to be removed.
	 */
	void removeEntity ( @NotNull CollisionShapeBehavior entity ) {
		entities.remove ( entity );
	}

	/**
	 * Updates the position, rotation, and origin of each entity based on its current state.
	 * Checks each pair of entities for possible collisions.
	 */
	void update ( ) {
		// Update each entity's position, rotation, and origin based on its current state
		for ( CollisionShapeBehavior entity : entities ) {
			final @NotNull Polygon shape = entity.getCollisionShapeComponent ( ).getConvexPolygon ( );
			final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent ( );
			final @NotNull Vector2 position = positionRotationComponent.getPosition ( );

			if ( positionRotationComponent.isChanged ( ) ) {
				shape.setPosition ( position.x - shape.getOriginX ( ), position.y - shape.getOriginY ( ) );
				shape.setRotation ( positionRotationComponent.getDegrees ( ) );
			}
		}

		// Check each pair of entities for possible collisions
		CollisionShapeBehavior[] entityArray = entities.toArray ( new CollisionShapeBehavior[ 0 ] );
		for ( int i = 0; i < entityArray.length; i++ ) {
			final @NotNull CollisionShapeBehavior entity0 = entityArray[ i ];
			final @NotNull CollisionShapeComponent collisionShapeComponent0 = entity0.getCollisionShapeComponent ( );
			final @NotNull Polygon shape0 = collisionShapeComponent0.getConvexPolygon ( );
			final int nonCollidingGroupId0 = collisionShapeComponent0.getNonCollidingGroupId ( );

			for ( int j = i + 1; j < entityArray.length; j++ ) {
				CollisionShapeBehavior entity1 = entityArray[ j ];
				final @NotNull CollisionShapeComponent collisionShapeComponent1 = entity1.getCollisionShapeComponent ( );

				// Skip this collision check if possible
				if ( nonCollidingGroupId0 == collisionShapeComponent1.getNonCollidingGroupId ( ) ||
					 entity0.getEntityComponent ( ).isQueuedForRemoval ( ) || entity1.getEntityComponent ( ).isQueuedForRemoval ( ) )
					continue;

				Polygon shape1 = collisionShapeComponent1.getConvexPolygon ( );

				// If the bounding boxes of the two entities overlap, then check for a more precise collision using
				// the Separating Axis Theorem (SAT)
				if ( shape1.getBoundingRectangle ( ).overlaps ( shape0.getBoundingRectangle ( ) ) ) {
					if ( areIntersecting ( shape0, shape1 ) ) {
						final float health0 = collisionShapeComponent0.getHealth ( );
						final float health1 = collisionShapeComponent1.getHealth ( );

						float damage0 = collisionShapeComponent0.getDamage ( );
						float damage1 = collisionShapeComponent1.getDamage ( );

						final float effectiveDamage0 = ( collisionShapeComponent1.getArmorClass ( ) >
														 collisionShapeComponent0.getEffectiveAgainstArmorClass ( ) ) ? damage0 / 2 : damage0;

						final float effectiveDamage1 = ( collisionShapeComponent0.getArmorClass ( ) >
														 collisionShapeComponent1.getEffectiveAgainstArmorClass ( ) ) ? damage1 / 2 : damage1;

						final float damageHealthRatio0 = effectiveDamage0 / health1;
						final float damageHealthRatio1 = effectiveDamage1 / health0;

						if ( damageHealthRatio0 > damageHealthRatio1 ) {
							BehaviorLogic.getInstance ( ).queueEntityForRemoval ( entity1 );
							collisionShapeComponent0.setHealth ( health0 - effectiveDamage1 / damageHealthRatio0 );
							collisionShapeComponent0.setDamage ( damage0 - effectiveDamage1 / damageHealthRatio0 / 2 );
							if ( collisionShapeComponent0.getHealth ( ) < 1 )
								BehaviorLogic.getInstance ( ).queueEntityForRemoval ( entity0 );
						} else {
							BehaviorLogic.getInstance ( ).queueEntityForRemoval ( entity0 );
							collisionShapeComponent1.setHealth ( health1 - effectiveDamage0 / damageHealthRatio1 );
							collisionShapeComponent1.setDamage ( damage1 - effectiveDamage0 / damageHealthRatio1 / 2 );
							if ( collisionShapeComponent1.getHealth ( ) < 1 )
								BehaviorLogic.getInstance ( ).queueEntityForRemoval ( entity1 );
						}
					}
				}
			}
		}
	}

	// Check if two polygons are intersecting by applying the Separating Axis Theorem (SAT)
	private boolean areIntersecting ( Polygon shape1, Polygon shape2 ) {
		float[] vertices1 = shape1.getTransformedVertices ( );
		float[] vertices2 = shape2.getTransformedVertices ( );

		// Project all points of both polygons onto a series of axes perpendicular to the edges of the polygons
		for ( int i = 0; i < vertices1.length; i += 2 ) {
			float x1 = vertices1[ i ];
			float y1 = vertices1[ i + 1 ];

			float x2, y2;
			if ( i + 2 < vertices1.length ) {
				x2 = vertices1[ i + 2 ];
				y2 = vertices1[ i + 3 ];
			} else {
				x2 = vertices1[ 0 ];
				y2 = vertices1[ 1 ];
			}

			float axisX = y1 - y2;
			float axisY = x2 - x1;

			// If there exists an axis along which the projections of the two polygons do not overlap, then the
			// polygons do not intersect
			if ( !overlap ( axisX, axisY, vertices1, vertices2 ) ) {
				return false;
			}
		}

		return true;
	}

	// Check if the projections of the two polygons overlap along the given axis
	private boolean overlap ( float axisX, float axisY, float[] vertices1, float[] vertices2 ) {
		float min1 = project ( axisX, axisY, vertices1[ 0 ], vertices1[ 1 ] );
		float max1 = min1;
		for ( int i = 2; i < vertices1.length; i += 2 ) {
			float p = project ( axisX, axisY, vertices1[ i ], vertices1[ i + 1 ] );
			if ( p < min1 ) {
				min1 = p;
			} else if ( p > max1 ) {
				max1 = p;
			}
		}

		float min2 = project ( axisX, axisY, vertices2[ 0 ], vertices2[ 1 ] );
		float max2 = min2;
		for ( int i = 2; i < vertices2.length; i += 2 ) {
			float p = project ( axisX, axisY, vertices2[ i ], vertices2[ i + 1 ] );
			if ( p < min2 ) {
				min2 = p;
			} else if ( p > max2 ) {
				max2 = p;
			}
		}

		return !( min1 > max2 || max1 < min2 );
	}

	// Project a point onto an axis
	private float project ( float axisX, float axisY, float x, float y ) {
		float dotProduct = ( x * axisX + y * axisY ) / ( axisX * axisX + axisY * axisY );
		return dotProduct * axisX + dotProduct * axisY;
	}
}

