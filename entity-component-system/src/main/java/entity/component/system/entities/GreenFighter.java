package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.AcceleratedMovementBehavior;
import entity.component.system.behaviors.CameraBehavior;
import entity.component.system.behaviors.SpaceShipLocalPlayerBehavior;
import entity.component.system.behaviors.TextureBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class GreenFighter implements TextureBehavior, CameraBehavior, AcceleratedMovementBehavior,
		SpaceShipLocalPlayerBehavior {
	private final @NotNull CameraComponent cameraComponent;
	private final @NotNull TextureComponent textureComponent;
	private final @NotNull PositionComponent positionComponent;
	private final @NotNull RotationComponent rotation;
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull RotationalVelocityComponent rotationalVelocityComponent;
	private final @NotNull AccelerationComponent accelerationComponent;
	private final @NotNull RotationalAccelerationComponent rotationalAccelerationComponent;
	private final @NotNull DirectionalThrustComponent directionalThrustComponent;
	private final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent;

	public GreenFighter (@NotNull final CameraComponent cameraComponent,
						 @NotNull final PositionComponent positionComponent,
						 final @NotNull RotationComponent rotationComponent,
						 @NotNull final TextureAtlas textureAtlas) {
		this.positionComponent = positionComponent;
		this.rotation = rotationComponent;
		this.textureComponent = new TextureComponent(textureAtlas.findRegion(
				"green_fighter_by_stephen_challener_on_open_game_art"));
		this.cameraComponent = cameraComponent;
		velocityComponent = new VelocityComponent(new Vector2(0, 0));
		accelerationComponent = new AccelerationComponent(new Vector2(0, 0), 0.01f);
		rotationalVelocityComponent = new RotationalVelocityComponent(0);
		rotationalAccelerationComponent = new RotationalAccelerationComponent(0.01f, 0);
		directionalThrustComponent = new DirectionalThrustComponent(100, 50, 50, 50);
		userInputSpaceShipComponent = UserInputSpaceShipComponent.PLAYER_ONE;
	}

	@Override
	public @NotNull CameraComponent getCameraComponent () {
		return cameraComponent;
	}

	@Override
	public @NotNull PositionComponent getPositionComponent () {
		return positionComponent;
	}

	@Override
	public @NotNull RotationComponent getRotationComponent () {
		return rotation;
	}

	@Override
	public @NotNull TextureComponent getTextureComponent () {
		return textureComponent;
	}

	@Override
	public @NotNull VelocityComponent getVelocityComponent () {
		return velocityComponent;
	}

	@Override
	public @NotNull AccelerationComponent getAccelerationComponent () {
		return accelerationComponent;
	}

	@Override
	public @NotNull RotationalAccelerationComponent getRotationalAcceleration () {
		return rotationalAccelerationComponent;
	}

	@Override
	public @NotNull RotationalVelocityComponent getRotationalVelocityComponent () {
		return rotationalVelocityComponent;
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
