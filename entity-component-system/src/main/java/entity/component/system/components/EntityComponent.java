package entity.component.system.components;

import entity.component.system.behaviors.EntityBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EntityComponent {
	private boolean queuedForAddition;
	private boolean addedToBehaviorLogic;
	private boolean queuedForRemoval;
	private final @NotNull Set<EntityBehavior> queueEntitiesOnAddition;
	private final @NotNull Set<EntityBehavior> queueEntitiesOnRemoval;

	public Set<EntityBehavior> getQueueEntitiesOnAddition ( ) {
		return Collections.unmodifiableSet ( queueEntitiesOnAddition );
	}

	public void addEntityToQueueOnAddition ( EntityBehavior entity ) {
		queueEntitiesOnAddition.add ( entity );
	}

	public Set<EntityBehavior> getQueueEntitiesOnRemoval ( ) {
		return Collections.unmodifiableSet ( queueEntitiesOnRemoval );
	}

	public void addEntityToQueueOnRemoval (EntityBehavior entity) {
		queueEntitiesOnAddition.add ( entity );
	}

	public EntityComponent ( ) {
		this.queuedForAddition = false;
		this.addedToBehaviorLogic = false;
		this.queuedForRemoval = false;
		this.queueEntitiesOnAddition = new HashSet<> ();
		this.queueEntitiesOnRemoval = new HashSet<> ();
	}

	public boolean isAddedToBehaviorLogic ( ) {
		return addedToBehaviorLogic;
	}

	public void setAddedToBehaviorLogic ( final boolean addedToBehaviorLogic ) {
		this.addedToBehaviorLogic = addedToBehaviorLogic;
	}

	public boolean isQueuedForAddition ( ) {
		return queuedForAddition;
	}

	public void setQueuedForAddition ( final boolean queuedForAddition ) {
		this.queuedForAddition = queuedForAddition;
	}

	public boolean isQueuedForRemoval ( ) {
		return queuedForRemoval;
	}

	public void setQueuedForRemoval ( final boolean queuedForRemoval ) {
		this.queuedForRemoval = queuedForRemoval;
	}


}
