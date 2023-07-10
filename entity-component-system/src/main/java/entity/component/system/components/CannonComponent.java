package entity.component.system.components;

import entity.component.system.behaviors.ProjectileBehavior;
import org.jetbrains.annotations.NotNull;

/**
 * The CannonComponent class represents the properties of a cannon attached to an entity.
 * It defines the projectile behavior, firing rate, translational velocity, and timing.
 */
public class CannonComponent {
	private final @NotNull Class<? extends ProjectileBehavior> projectile;
	private long millisecondsPerProjectile;
	private long millisecondsOfLastProjectile;
	private float translationalVelocity;

	/**
	 * Constructs a new CannonComponent with the specified properties.
	 *
	 * @param projectile                the projectile behavior class
	 * @param translationalVelocity     the translational velocity of the cannon
	 * @param millisecondsPerProjectile the time interval in milliseconds between projectiles
	 */
	public CannonComponent ( final @NotNull Class<? extends ProjectileBehavior> projectile,
							 final float translationalVelocity,
							 final long millisecondsPerProjectile ) {
		this.projectile = projectile;
		this.translationalVelocity = translationalVelocity;
		this.millisecondsPerProjectile = millisecondsPerProjectile;
	}

	/**
	 * Returns the time interval in milliseconds between projectiles.
	 *
	 * @return the milliseconds per projectile
	 */
	public long getMillisecondsPerProjectile ( ) {
		return millisecondsPerProjectile;
	}

	/**
	 * Sets the time interval in milliseconds between projectiles.
	 *
	 * @param millisecondsPerProjectile the milliseconds per projectile to set
	 */
	public void setMillisecondsPerProjectile ( long millisecondsPerProjectile ) {
		this.millisecondsPerProjectile = millisecondsPerProjectile;
	}

	/**
	 * Returns the timestamp of the last projectile fired in milliseconds.
	 *
	 * @return the milliseconds of the last projectile
	 */
	public long getMillisecondsOfLastProjectile ( ) {
		return millisecondsOfLastProjectile;
	}

	/**
	 * Sets the timestamp of the last projectile fired in milliseconds.
	 * Additionally, resets the milliseconds of the last projectile to 0.
	 *
	 * @param millisecondsOfLastProjectile the milliseconds of the last projectile to set
	 */
	public void setMillisecondsOfLastProjectile ( long millisecondsOfLastProjectile ) {
		this.millisecondsOfLastProjectile = millisecondsOfLastProjectile;
		this.millisecondsOfLastProjectile = 0;
	}

	/**
	 * Returns the translational velocity of the cannon.
	 *
	 * @return the translational velocity
	 */
	public float getTranslationalVelocity ( ) {
		return translationalVelocity;
	}

	/**
	 * Sets the translational velocity of the cannon.
	 *
	 * @param translationalVelocity the translational velocity to set
	 */
	public void setTranslationalVelocity ( final float translationalVelocity ) {
		this.translationalVelocity = translationalVelocity;
	}

	/**
	 * Returns the projectile behavior class associated with the cannon.
	 *
	 * @return the projectile behavior class
	 */
	public @NotNull Class<? extends ProjectileBehavior> getProjectile ( ) {
		return projectile;
	}
}
