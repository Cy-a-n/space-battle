package entity.component.system.entities;

import entity.component.system.behaviors.SpaceShipBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class SpaceShip extends Entity implements SpaceShipBehavior {
	private final @NotNull TextureComponent textureComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull AccelerationComponent accelerationComponent;
	private final @NotNull CollisionShapeComponent collisionShapeComponent;

	public SpaceShip ( @NotNull final TextureComponent textureComponent,
					   @NotNull final PositionRotationComponent positionRotationComponent,
					   @NotNull final VelocityComponent velocityComponent,
					   @NotNull final AccelerationComponent accelerationComponent,
					   @NotNull final CollisionShapeComponent collisionShapeComponent ) {
		this.textureComponent = textureComponent;
		this.positionRotationComponent = positionRotationComponent;
		this.velocityComponent = velocityComponent;
		this.accelerationComponent = accelerationComponent;
		this.collisionShapeComponent = collisionShapeComponent;
	}

	@Override public @NotNull AccelerationComponent getAccelerationComponent ( ) {
		return accelerationComponent;
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
}
