package entity.component.system.behaviors;

import entity.component.system.components.EntityComponent;
import org.jetbrains.annotations.NotNull;

public interface Entity {
	@NotNull EntityComponent getEntityComponent ( );
}
