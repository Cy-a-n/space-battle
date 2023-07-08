package entity.component.system.components;

import org.jetbrains.annotations.NotNull;

public class FactionComponent {
	private final @NotNull FactionComponent.Id playerID;

	public FactionComponent (@NotNull final FactionComponent.Id id) {
		this.playerID = id;
	}

	public @NotNull FactionComponent.Id getId () {
		return playerID;
	}

	public enum Id {
		ONE, TWO,
	}
}
