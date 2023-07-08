package entity.component.system.behaviors;

import entity.component.system.components.FactionComponent;
import org.jetbrains.annotations.NotNull;

public interface FactionBehavior extends Behavior {
	@NotNull FactionComponent getFactionComponent ();
}
