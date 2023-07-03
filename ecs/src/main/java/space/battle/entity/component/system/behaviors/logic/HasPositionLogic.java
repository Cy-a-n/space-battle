package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.components.HasPosition;

import java.util.ArrayList;
import java.util.List;

class HasPositionLogic {
    private List<HasPosition> entities = new ArrayList<>();

    void addEntity(HasPosition entity) {
        entities.add(entity);
    }

    void update() {
        for (HasPosition entity : entities) {
            entity.setPositionChanged(false);
        }
    }
}
