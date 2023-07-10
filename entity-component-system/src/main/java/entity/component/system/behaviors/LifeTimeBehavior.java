package entity.component.system.behaviors;

import entity.component.system.components.LifeTimeComponent;
import org.jetbrains.annotations.NotNull;

public interface LifeTimeBehavior extends Entity {
	@NotNull LifeTimeComponent getLifeTimeComponent ();
}
