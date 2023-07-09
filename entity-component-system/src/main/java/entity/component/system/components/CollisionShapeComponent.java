package entity.component.system.components;

import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;

public class CollisionShapeComponent {
	private static int nextNonCollidingGroupId;
	private final @NotNull Polygon convexPolygon;
	private final int armorClass;
	private final int effectiveAgainstArmorClass;
	private float health;
	private float damage;
	private int nonCollidingGroupId;

	public CollisionShapeComponent (@NotNull final Polygon convexPolygon, final int armorClass,
									final int effectiveAgainstArmorClass, final float health, final float damage,
									int nonCollidingGroupId) {
		this.convexPolygon = convexPolygon;
		convexPolygon.setOrigin(convexPolygon.getBoundingRectangle().width / 2,
				convexPolygon.getBoundingRectangle().height / 2);

		this.armorClass = armorClass;
		this.effectiveAgainstArmorClass = effectiveAgainstArmorClass;
		this.health = health;
		this.damage = damage;
		this.nonCollidingGroupId = nonCollidingGroupId;
	}

	public static int getUniqueNonCollidingGroupId () {
		return nextNonCollidingGroupId++;
	}

	public int getNonCollidingGroupId () {
		return nonCollidingGroupId;
	}

	public void setNonCollidingGroupId (final int nonCollidingGroup) {
		this.nonCollidingGroupId = nonCollidingGroup;
	}

	public @NotNull Polygon getConvexPolygon () {
		return convexPolygon;
	}

	public int getArmorClass () {
		return armorClass;
	}

	public int getEffectiveAgainstArmorClass () {
		return effectiveAgainstArmorClass;
	}

	public float getHealth () {
		return health;
	}

	public void setHealth (final float health) {
		this.health = health;
	}

	public float getDamage () {
		return damage;
	}

	public void setDamage (final float damage) {
		this.damage = damage;
	}
}
