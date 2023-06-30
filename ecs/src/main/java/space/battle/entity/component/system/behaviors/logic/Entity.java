package space.battle.entity.component.system.behaviors.logic;

public abstract class Entity {
	private boolean isAddedToBehaviorLogic = false;

	public boolean isAddedToBehaviorLogic () {
		return isAddedToBehaviorLogic;
	}

	void setAddedToBehaviorLogic (boolean addedToBehaviorLogic) {
		isAddedToBehaviorLogic = addedToBehaviorLogic;
	}
}
