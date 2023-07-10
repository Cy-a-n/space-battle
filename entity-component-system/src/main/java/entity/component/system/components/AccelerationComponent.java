package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

/**
 * The AccelerationComponent class represents the acceleration properties of an entity.
 * It defines translational and rotational acceleration, as well as friction coefficients.
 */
public class AccelerationComponent {
	private final @NotNull Vector2 translational;
	private float degreesPerSecondSquared;
	private float translationalFriction;
	private float rotationalFriction;

	/**
	 * Constructs a new AccelerationComponent with the specified properties.
	 *
	 * @param translational           the translational acceleration vector
	 * @param degreesPerSecondSquared the rotational acceleration in degrees per second squared
	 * @param translationalFriction   the translational friction coefficient
	 * @param rotationalFriction      the rotational friction coefficient
	 */
	public AccelerationComponent ( @NotNull final Vector2 translational,
								   final float degreesPerSecondSquared,
								   final float translationalFriction,
								   final float rotationalFriction ) {
		this.translational = translational;
		this.degreesPerSecondSquared = degreesPerSecondSquared;
		this.translationalFriction = translationalFriction;
		this.rotationalFriction = rotationalFriction;
	}

	/**
	 * Returns the rotational friction coefficient.
	 *
	 * @return the rotational friction coefficient
	 */
	public float getRotationalFriction ( ) {
		return rotationalFriction;
	}

	/**
	 * Sets the rotational friction coefficient.
	 *
	 * @param rotationalFriction the rotational friction coefficient to set
	 */
	public void setRotationalFriction ( final float rotationalFriction ) {
		this.rotationalFriction = rotationalFriction;
	}

	/**
	 * Returns the rotational acceleration in degrees per second squared.
	 *
	 * @return the rotational acceleration in degrees per second squared
	 */
	public float getDegreesPerSecondSquared ( ) {
		return degreesPerSecondSquared;
	}

	/**
	 * Sets the rotational acceleration in degrees per second squared.
	 *
	 * @param degreesPerSecondSquared the rotational acceleration to set in degrees per second squared
	 */
	public void setDegreesPerSecondSquared ( final float degreesPerSecondSquared ) {
		this.degreesPerSecondSquared = degreesPerSecondSquared;
	}

	/**
	 * Returns the translational acceleration vector.
	 *
	 * @return the translational acceleration vector
	 */
	public @NotNull Vector2 getTranslational ( ) {
		return translational;
	}

	/**
	 * Returns the translational friction coefficient.
	 *
	 * @return the translational friction coefficient
	 */
	public float getTranslationalFriction ( ) {
		return translationalFriction;
	}

	/**
	 * Sets the translational friction coefficient.
	 *
	 * @param translationalFriction the translational friction coefficient to set
	 */
	public void setTranslationalFriction ( final float translationalFriction ) {
		this.translationalFriction = translationalFriction;
	}
}
