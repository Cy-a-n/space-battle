package entity.component.system.entities;

import entity.component.system.behaviors.RelativePositionRotationBehavior;
import entity.component.system.behaviors.TextureBehavior;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.RelativePositionRotationComponent;
import entity.component.system.components.TextureComponent;
import org.jetbrains.annotations.NotNull;

public class SpaceShipSubcomponent implements RelativePositionRotationBehavior, TextureBehavior {
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior;
	private final @NotNull TextureComponent textureComponent;

	public SpaceShipSubcomponent (@NotNull final PositionRotationComponent positionRotationComponent,
								  @NotNull final RelativePositionRotationComponent relativePositionAndRotationBehavior
			, final @NotNull TextureComponent textureComponent) {
		this.positionRotationComponent = positionRotationComponent;
		this.relativePositionAndRotationBehavior = relativePositionAndRotationBehavior;
		this.textureComponent = textureComponent;
	}

	@Override
	public @NotNull PositionRotationComponent getPositionRotationComponent () {
		return positionRotationComponent;
	}

	@Override
	public @NotNull RelativePositionRotationComponent getRelativePositionAndRotationComponent () {
		return relativePositionAndRotationBehavior;
	}

	@Override
	public @NotNull TextureComponent getTextureComponent () {
		return textureComponent;
	}
}
