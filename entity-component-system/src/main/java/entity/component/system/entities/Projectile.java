package entity.component.system.entities;

import entity.component.system.behaviors.ProjectileBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class Projectile extends Entity implements ProjectileBehavior {
	private @NotNull final CollisionShapeComponent collisionShapeComponent;
	private @NotNull final VelocityComponent velocityComponent;
	private @NotNull final PositionRotationComponent positionRotationComponent;
	private @NotNull final TextureComponent textureComponent;
	private final @NotNull LifeTimeComponent lifeTimeComponent;

	public Projectile ( @NotNull final PositionRotationComponent positionRotationComponent,
						@NotNull final VelocityComponent velocityComponent,
						@NotNull final CollisionShapeComponent collisionShapeComponent,
						@NotNull final TextureComponent textureComponent,
						final @NotNull LifeTimeComponent lifeTimeComponent ) {
		this.collisionShapeComponent = collisionShapeComponent;
		this.velocityComponent = velocityComponent;
		this.positionRotationComponent = positionRotationComponent;
		this.textureComponent = textureComponent;
		this.lifeTimeComponent = lifeTimeComponent;
	}

	@Override public @NotNull CollisionShapeComponent getCollisionShapeComponent ( ) {
		return collisionShapeComponent;
	}

	@Override public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}

	@Override public @NotNull TextureComponent getTextureComponent ( ) {
		return textureComponent;
	}

	@Override public @NotNull LifeTimeComponent getLifeTimeComponent ( ) {
		return lifeTimeComponent;
	}
}
