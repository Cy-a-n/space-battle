package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.OriginBehavior;
import space.battle.entity.component.system.components.HasOrigin;

import java.util.ArrayList;
import java.util.List;

class OriginLogic {
	private List<OriginBehavior> entities = new ArrayList<>();

	void addEntity (OriginBehavior entity) {
		entities.add(entity);
	}

	void update () {
		for (OriginBehavior entity : entities) {
			entity.setOriginChanged(false);
		}
	}
}
