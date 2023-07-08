package entity.component.system.components;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class CollisionShapeComponent {
	private final @NotNull Polygon convexPolygon;
	private final int armorClass;
	private final int effectiveAgainstArmorClass;
	private float health;
	private float damage;

	public CollisionShapeComponent (@NotNull final Polygon convexPolygon, final int armorClass,
									final int effectiveAgainstArmorClass, final float health, final float damage) {
		this.convexPolygon = convexPolygon;
		convexPolygon.setOrigin(convexPolygon.getBoundingRectangle().width / 2,
				convexPolygon.getBoundingRectangle().height / 2);

		this.armorClass = armorClass;
		this.effectiveAgainstArmorClass = effectiveAgainstArmorClass;
		this.health = health;
		this.damage = damage;
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
