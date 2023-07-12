package entity.component.system.behaviors;

import entity.component.system.components.DirectionalThrustComponent;
import org.jetbrains.annotations.NotNull;

public interface DirectionalThrustBehavior extends EntityBehavior {
	@NotNull DirectionalThrustComponent getDirectionalThrustComponent ( );
}
