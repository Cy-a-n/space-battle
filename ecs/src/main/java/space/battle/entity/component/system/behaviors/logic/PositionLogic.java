package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.PositionBehavior;
import space.battle.entity.component.system.components.HasPosition;

import java.util.ArrayList;
import java.util.List;

class PositionLogic {
	private List<PositionBehavior> entities = new ArrayList<>();

	void addEntity (PositionBehavior entity) {
		entities.add(entity);
	}

	void update () {
		for (PositionBehavior entity : entities) {
			entity.setPositionChanged(false);
		}
	}
}
