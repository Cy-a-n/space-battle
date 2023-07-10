package entity.component.system.entities;

import entity.component.system.behaviors.CannonBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class Cannon extends SpaceShipSubcomponent implements CannonBehavior {
	private final @NotNull CannonComponent cannonComponent;
	private final @NotNull CollisionShapeComponent collisionShapeComponent;
	private final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent;

	public Cannon ( final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior,
					final @NotNull TextureComponent textureComponent,
					@NotNull final CannonComponent cannonComponent,
					@NotNull final CollisionShapeComponent collisionShapeComponent,
					@NotNull final UserInputSpaceShipComponent userInputSpaceShipComponent ) {
		super ( relativePositionAndRotationBehavior, textureComponent );
		this.cannonComponent = cannonComponent;
		this.collisionShapeComponent = collisionShapeComponent;
		this.userInputSpaceShipComponent = userInputSpaceShipComponent;
	}

	@Override public @NotNull CannonComponent getCannonComponent ( ) {
		return cannonComponent;
	}

	@Override public @NotNull CollisionShapeComponent getCollisionShapeComponent ( ) {
		return collisionShapeComponent;
	}

	@Override public @NotNull UserInputSpaceShipComponent getUserInputSpaceShipComponent ( ) {
		return userInputSpaceShipComponent;
	}
}
