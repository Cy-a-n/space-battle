package space.battle.entity.component.system.behaviors.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class CollisionShapeBehavior {
    private List<CollisionShapeBehavior> entities = new ArrayList<>();

    void addEntity(CollisionShapeBehavior entity) {
        entities.add(entity);
    }

    void update() {
        HashSet<HashSet<CollisionShapeBehavior>> collisionCandidates = new HashSet<>();

        // Check the bounding boxes for possible collisions
        for(int i = 0; i < entities.size(); i++) {
            for (int j = i + 1; j < entities.size(); j++) {
                
            }
        }
    }
}
