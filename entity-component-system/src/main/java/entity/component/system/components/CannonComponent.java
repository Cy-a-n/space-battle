package entity.component.system.components;

import entity.component.system.behaviors.ProjectileBehavior;
import org.jetbrains.annotations.NotNull;

public class CannonComponent {
	private final @NotNull Class<? extends ProjectileBehavior> projectile;
	private long millisecondsPerProjectile;
	private long millisecondsOfLastProjectile;
	private float translationalVelocity;

	public long getMillisecondsPerProjectile() {
		return millisecondsPerProjectile;
	}

	public void setMillisecondsPerProjectile( long millisecondsPerProjectile) {
		this.millisecondsPerProjectile = millisecondsPerProjectile;
	}

	public long getMillisecondsOfLastProjectile () {
		return millisecondsOfLastProjectile;
	}

	public void setMillisecondsOfLastProjectile ( long millisecondsOfLastProjectile ) {
		this.millisecondsOfLastProjectile = millisecondsOfLastProjectile;
		millisecondsOfLastProjectile = 0;
	}

	public CannonComponent (final @NotNull Class<? extends ProjectileBehavior> projectile, final float translationalVelocity, final long millisecondsPerProjectile) {
		this.projectile = projectile;
		this.translationalVelocity = translationalVelocity;
		this.millisecondsPerProjectile = millisecondsPerProjectile;
	}

	public float getTranslationalVelocity () {
		return translationalVelocity;
	}

	public void setTranslationalVelocity (final float translationalVelocity) {
		this.translationalVelocity = translationalVelocity;
	}

	public @NotNull Class<? extends ProjectileBehavior> getProjectile () {
		return projectile;
	}
}
