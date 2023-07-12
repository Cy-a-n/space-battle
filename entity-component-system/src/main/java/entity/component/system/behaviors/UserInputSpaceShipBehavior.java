package entity.component.system.behaviors;

import entity.component.system.components.UserInputSpaceShipComponent;
import org.jetbrains.annotations.NotNull;

public interface UserInputSpaceShipBehavior extends EntityBehavior {
	@NotNull UserInputSpaceShipComponent getUserInputSpaceShipComponent ( );
}
