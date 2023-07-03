package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.components.HasOrigin;

import java.util.ArrayList;
import java.util.List;

 class HasOriginLogic {
    private List<HasOrigin> entities = new ArrayList<>();

    void addEntity(HasOrigin entity) {
        entities.add(entity);
    }

    void update() {
        for (HasOrigin entity : entities) {
            entity.setOriginChanged(false);
        }
    }
}
