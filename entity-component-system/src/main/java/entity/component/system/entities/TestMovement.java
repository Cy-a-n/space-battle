package entity.component.system.entities;

import entity.component.system.behaviors.*;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class TestMovement implements TextureBehavior, SpaceShipLocalPlayerBehavior {
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull TextureComponent textureComponent;
	private final @NotNull CameraComponent cameraComponent;
	private final @NotNull AccelerationComponent accelerationComponent;
	private final @NotNull CollisionShapeComponent collisionShapeComponent;
	private final @NotNull DirectionalThrustComponent directionalThrustComponent;
	private final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent;

	public TestMovement (final VelocityComponent velocityComponent,
						 final PositionRotationComponent positionRotationComponent,
						 final TextureComponent textureComponent, final CameraComponent cameraComponent,
						 AccelerationComponent accelerationComponent,
						 final @NotNull CollisionShapeComponent collisionShapeComponent,
						 final @NotNull DirectionalThrustComponent directionalThrustComponent,
						 final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent) {
		this.velocityComponent = velocityComponent;
		this.positionRotationComponent = positionRotationComponent;
		this.textureComponent = textureComponent;
		this.cameraComponent = cameraComponent;
		this.accelerationComponent = accelerationComponent;
		this.collisionShapeComponent = collisionShapeComponent;
		this.directionalThrustComponent = directionalThrustComponent;
		this.userInputSpaceShipComponent = userInputSpaceShipComponent;
	}

	@Override
	public @NotNull VelocityComponent getVelocityComponent () {
		return velocityComponent;
	}

	@Override
	public @NotNull PositionRotationComponent getPositionRotationComponent () {
		return positionRotationComponent;
	}

	@Override
	public @NotNull TextureComponent getTextureComponent () {
		return textureComponent;
	}

	@Override
	public @NotNull CameraComponent getCameraComponent () {
		return cameraComponent;
	}

	@Override
	public @NotNull AccelerationComponent getAccelerationComponent () {
		return accelerationComponent;
	}

	@Override
	public @NotNull CollisionShapeComponent getCollisionShapeComponent () {
		return collisionShapeComponent;
	}

	@Override
	public @NotNull DirectionalThrustComponent getDirectionalThrustComponent () {
		return directionalThrustComponent;
	}

	@Override
	public UserInputSpaceShipComponent getUserInputSpaceShipBehavior () {
		return userInputSpaceShipComponent;
	}
}
