package space.battle.client.entities.components.composite;

import space.battle.client.entities.components.HasDirection;
import space.battle.client.entities.components.HasPosition;
import space.battle.client.entities.components.HasSpeed;

public interface HasMovement extends HasPosition, HasDirection, HasSpeed {
}
