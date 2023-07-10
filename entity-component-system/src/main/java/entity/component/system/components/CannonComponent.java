package entity.component.system.components;

import entity.component.system.behaviors.ProjectileBehavior;
import org.jetbrains.annotations.NotNull;

public class CannonComponent {
	private final @NotNull Class<? extends ProjectileBehavior> projectile;
	private float translationalVelocity;

	public CannonComponent (final @NotNull Class<? extends ProjectileBehavior> projectile, final float translationalVelocity) {
		this.projectile = projectile;
		this.translationalVelocity = translationalVelocity;
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
