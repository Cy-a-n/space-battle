package space.battle.entity.component.system.entities;

import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import space.battle.entity.component.system.dataclasses.Position;

public class TestCamera implements IsCamera {
	private Position position;

	public TestCamera (Position position) {
		this.position = position;
	}

	@Override
	public Position getPosition () {
		return position;
	}
}
