package entity.component.system.entities;

import entity.component.system.behaviors.AcceleratedMovementBehavior;
import entity.component.system.components.AccelerationComponent;
import entity.component.system.components.EntityComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

public class TestAcceleratedMovement implements AcceleratedMovementBehavior {
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull EntityComponent entityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull AccelerationComponent acceleratedMovementBehavior;

	public TestAcceleratedMovement ( @NotNull VelocityComponent velocityComponent,
									 @NotNull EntityComponent entityComponent,
									 @NotNull PositionRotationComponent positionRotationComponent,
									 @NotNull AccelerationComponent acceleratedMovementBehavior ) {
		this.velocityComponent = velocityComponent;
		this.entityComponent = entityComponent;
		this.positionRotationComponent = positionRotationComponent;
		this.acceleratedMovementBehavior = acceleratedMovementBehavior;
	}

	@Override
	public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}

	@Override
	public @NotNull EntityComponent getEntityComponent ( ) {
		return entityComponent;
	}

	@Override
	public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}

	@Override
	public @NotNull AccelerationComponent getAccelerationComponent ( ) {
		return acceleratedMovementBehavior;
	}
}
