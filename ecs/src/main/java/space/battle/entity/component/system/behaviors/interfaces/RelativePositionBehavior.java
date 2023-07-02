package space.battle.entity.component.system.behaviors.interfaces;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.components.*;

public interface RelativePositionBehavior extends HasRelativePosition, HasPosition{
    @NotNull ChildrenWithRelativePositionBehavior getParentWithPosition();
}
