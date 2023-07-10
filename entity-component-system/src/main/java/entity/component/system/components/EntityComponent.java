package entity.component.system.components;

public class EntityComponent {
	private boolean queuedForAddition;
	private boolean addedToBehaviorLogic;
	private boolean queuedForRemoval;

	public EntityComponent () {
		this.queuedForAddition = false;
		this.addedToBehaviorLogic = false;
		this.queuedForRemoval = false;
	}

	public boolean isAddedToBehaviorLogic () {
		return addedToBehaviorLogic;
	}

	public void setAddedToBehaviorLogic (final boolean addedToBehaviorLogic) {
		this.addedToBehaviorLogic = addedToBehaviorLogic;
	}

	public boolean isQueuedForAddition () {
		return queuedForAddition;
	}

	public void setQueuedForAddition (final boolean queuedForAddition) {
		this.queuedForAddition = queuedForAddition;
	}

	public boolean isQueuedForRemoval () {
		return queuedForRemoval;
	}

	public void setQueuedForRemoval (final boolean queuedForRemoval) {
		this.queuedForRemoval = queuedForRemoval;
	}
}
