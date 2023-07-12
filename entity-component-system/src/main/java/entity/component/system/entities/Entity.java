package entity.component.system.entities;

import entity.component.system.behaviors.EntityBehavior;
import entity.component.system.components.EntityComponent;
import org.jetbrains.annotations.NotNull;

public class Entity implements EntityBehavior {
	private final @NotNull EntityComponent entityComponent;

	public Entity (  ) {
		this.entityComponent = new EntityComponent ();
	}

	@Override public @NotNull EntityComponent getEntityComponent ( ) {
		return entityComponent;
	}
}
