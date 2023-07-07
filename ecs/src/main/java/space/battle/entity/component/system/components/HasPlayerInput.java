package space.battle.entity.component.system.components;

import org.jetbrains.annotations.NotNull;

public interface HasPlayerInput {
	@NotNull HasPlayerInput.PlayerId getPlayerId ();

	enum PlayerId {
		PLAYER_ONE, PLAYER_TWO,
	}
}
