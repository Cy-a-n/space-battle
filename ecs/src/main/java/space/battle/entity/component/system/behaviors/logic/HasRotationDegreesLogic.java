package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.components.HasRotationDegrees;

import java.util.ArrayList;
import java.util.List;

class HasRotationDegreesLogic {
    private List<HasRotationDegrees> entities = new ArrayList<>();

    void addEntity(HasRotationDegrees entity) {
        entities.add(entity);
    }

    void update() {
        for (HasRotationDegrees entity : entities) {
            entity.setRotationChanged(false);
        }
    }
}
