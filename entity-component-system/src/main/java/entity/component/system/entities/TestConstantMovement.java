package entity.component.system.entities;

import entity.component.system.behaviors.ConstantMovementBehavior;
import entity.component.system.components.EntityComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

public class TestConstantMovement implements ConstantMovementBehavior {
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull EntityComponent entityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;

	public TestConstantMovement ( @NotNull VelocityComponent velocityComponent,
								  @NotNull EntityComponent entityComponent,
								  @NotNull PositionRotationComponent positionRotationComponent ) {
		this.velocityComponent = velocityComponent;
		this.entityComponent = entityComponent;
		this.positionRotationComponent = positionRotationComponent;
	}

	@Override public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}

	@Override public @NotNull EntityComponent getEntityComponent ( ) {
		return entityComponent;
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}
}
