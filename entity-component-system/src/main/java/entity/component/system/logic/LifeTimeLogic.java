package entity.component.system.logic;

import com.badlogic.gdx.utils.TimeUtils;
import entity.component.system.behaviors.LifeTimeBehavior;
import entity.component.system.components.LifeTimeComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class LifeTimeLogic {
	private final @NotNull Set<LifeTimeBehavior> entities = new HashSet<> ( );

	void addEntity ( final @NotNull LifeTimeBehavior entity ) {
		entities.add ( entity );
		entity.getLifeTimeComponent ( ).setStartTimeMilliseconds ( TimeUtils.millis ( ) );
	}

	void removeEntity ( final @NotNull LifeTimeBehavior entity ) {
		entities.add ( entity );
	}

	void update ( ) {
		for ( LifeTimeBehavior entity : entities ) {
			if ( entity.getEntityComponent ( ).isQueuedForRemoval ( ) )
				continue;

			final @NotNull LifeTimeComponent lifeTimeComponent = entity.getLifeTimeComponent ( );

			if ( TimeUtils.timeSinceMillis ( lifeTimeComponent.getStartTimeMilliseconds ( ) ) > lifeTimeComponent.getMilliseconds ( ) )
				BehaviorLogic.getInstance ( ).queueEntityForRemoval ( entity );
		}
	}
}
