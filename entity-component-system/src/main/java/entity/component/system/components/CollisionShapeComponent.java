package entity.component.system.components;

import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;

/**
 * The CollisionShapeComponent class represents the collision shape properties of an entity.
 * It defines a convex polygon shape, armor classes, health, and damage.
 */
public class CollisionShapeComponent {
	private static int nextNonCollidingGroupId;
	private final @NotNull Polygon convexPolygon;
	private final int armorClass;
	private final int effectiveAgainstArmorClass;
	private float health;
	private float damage;
	private int nonCollidingGroupId;

	/**
	 * Constructs a new CollisionShapeComponent with the specified properties.
	 *
	 * @param convexPolygon              the convex polygon shape defining the collision shape
	 * @param armorClass                 the armor class of the entity
	 * @param effectiveAgainstArmorClass the armor class this entity is effective against
	 * @param health                     the health value of the entity
	 * @param damage                     the damage value of the entity
	 * @param nonCollidingGroupId        the non-colliding group ID of the entity
	 */
	public CollisionShapeComponent ( @NotNull final Polygon convexPolygon,
									 final int armorClass,
									 final int effectiveAgainstArmorClass,
									 final float health,
									 final float damage,
									 int nonCollidingGroupId ) {
		this.convexPolygon = convexPolygon;
		convexPolygon.setOrigin ( convexPolygon.getBoundingRectangle ( ).width / 2, convexPolygon.getBoundingRectangle ( ).height / 2 );

		this.armorClass = armorClass;
		this.effectiveAgainstArmorClass = effectiveAgainstArmorClass;
		this.health = health;
		this.damage = damage;
		this.nonCollidingGroupId = nonCollidingGroupId;
	}

	/**
	 * Returns the next unique non-colliding group ID.
	 *
	 * @return the next non-colliding group ID
	 */
	public static int getUniqueNonCollidingGroupId ( ) {
		return nextNonCollidingGroupId++;
	}

	/**
	 * Returns the non-colliding group ID of the entity.
	 *
	 * @return the non-colliding group ID
	 */
	public int getNonCollidingGroupId ( ) {
		return nonCollidingGroupId;
	}

	/**
	 * Sets the non-colliding group ID of the entity.
	 *
	 * @param nonCollidingGroupId the non-colliding group ID to set
	 */
	public void setNonCollidingGroupId ( final int nonCollidingGroupId ) {
		this.nonCollidingGroupId = nonCollidingGroupId;
	}

	/**
	 * Returns the convex polygon defining the collision shape.
	 *
	 * @return the convex polygon collision shape
	 */
	public @NotNull Polygon getConvexPolygon ( ) {
		return convexPolygon;
	}

	/**
	 * Returns the armor class of the entity.
	 *
	 * @return the armor class
	 */
	public int getArmorClass ( ) {
		return armorClass;
	}

	/**
	 * Returns the armor class this entity is effective against.
	 *
	 * @return the effective armor class
	 */
	public int getEffectiveAgainstArmorClass ( ) {
		return effectiveAgainstArmorClass;
	}

	/**
	 * Returns the health value of the entity.
	 *
	 * @return the health value
	 */
	public float getHealth ( ) {
		return health;
	}

	/**
	 * Sets the health value of the entity.
	 *
	 * @param health the health value to set
	 */
	public void setHealth ( final float health ) {
		this.health = health;
	}

	/**
	 * Returns the damage value of the entity.
	 *
	 * @return the damage value
	 */
	public float getDamage ( ) {
		return damage;
	}

	/**
	 * Sets the damage value of the entity.
	 *
	 * @param damage the damage value to set
	 */
	public void setDamage ( final float damage ) {
		this.damage = damage;
	}
}
