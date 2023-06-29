package space.battle.entity.component.system.components;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface HasChildrenWithRelativePosition {
    @NotNull List<HasChildrenWithRelativePosition> getChildrenWithRelativePosition();
}
