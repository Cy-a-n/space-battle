package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.RotationDegreesBehavior;

import java.util.ArrayList;
import java.util.List;

class RotationDegreesLogic {
	private List<RotationDegreesBehavior> entities = new ArrayList<>();

	void addEntity (RotationDegreesBehavior entity) {
		entities.add(entity);
	}

	void update () {
		for (RotationDegreesBehavior entity : entities) {
			entity.setRotationChanged(false);
		}
	}
}
