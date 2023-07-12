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
	private final @NotNull Set<EntityBehavior> queueEntitiesOnAdditionForAddition;
	private final @NotNull Set<EntityBehavior> queueEntitiesOnRemovalForRemoval;
	private final @NotNull Set<EntityBehavior> queueEntitiesOnRemovalForAddition;

	public EntityComponent ( ) {
		this.queuedForAddition = false;
		this.addedToBehaviorLogic = false;
		this.queuedForRemoval = false;
		this.queueEntitiesOnAdditionForAddition = new HashSet<> ( );
		this.queueEntitiesOnRemovalForRemoval = new HashSet<> ( );
		this.queueEntitiesOnRemovalForAddition = new HashSet<> ( );
	}

	public Set<EntityBehavior> getQueueEntitiesOnAdditionForAddition ( ) {
		return Collections.unmodifiableSet ( queueEntitiesOnAdditionForAddition );
	}

	public void addEntityToQueueOnAdditionForAddition ( EntityBehavior entity ) {
		queueEntitiesOnAdditionForAddition.add ( entity );
	}

	public Set<EntityBehavior> getQueueEntitiesOnRemovalForRemoval ( ) {
		return Collections.unmodifiableSet ( queueEntitiesOnRemovalForRemoval );
	}

	public void addEntityToQueueOnRemovalForRemoval ( EntityBehavior entity ) {
		queueEntitiesOnAdditionForAddition.add ( entity );
	}

	public Set<EntityBehavior> getQueueEntitiesOnRemovalForAddition ( ) {
		return queueEntitiesOnRemovalForAddition;
	}

	public void addEntityToQueueOnRemovalForAddition ( EntityBehavior entity ) {
		queueEntitiesOnRemovalForAddition.add ( entity );
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
