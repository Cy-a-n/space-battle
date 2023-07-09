package entity.component.system.entities;

import entity.component.system.behaviors.*;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class SpaceShipLocalPlayer extends SpaceShip implements SpaceShipLocalPlayerBehavior,
		VisualCollisionShapeBehavior {
	private final @NotNull CameraComponent cameraComponent;
	private final @NotNull DirectionalThrustComponent directionalThrustComponent;
	private final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent;

	public SpaceShipLocalPlayer (final @NotNull TextureComponent textureComponent,
								 final @NotNull PositionRotationComponent positionRotationComponent,
								 final @NotNull VelocityComponent velocityComponent,
								 final @NotNull AccelerationComponent accelerationComponent,
								 final @NotNull CollisionShapeComponent collisionShapeComponent,
								 @NotNull final CameraComponent cameraComponent,
								 @NotNull final DirectionalThrustComponent directionalThrustComponent1,
								 @NotNull final UserInputSpaceShipComponent userInputSpaceShipComponent1) {
		super(textureComponent, positionRotationComponent, velocityComponent, accelerationComponent,
				collisionShapeComponent);

		this.cameraComponent = cameraComponent;
		this.directionalThrustComponent = directionalThrustComponent1;
		this.userInputSpaceShipComponent = userInputSpaceShipComponent1;
	}

	@Override
	public @NotNull CameraComponent getCameraComponent () {
		return cameraComponent;
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
