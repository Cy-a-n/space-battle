package entity.component.system.entities;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.RelativePositionRotationBehavior;
import entity.component.system.behaviors.TextureBehavior;
import entity.component.system.components.EntityComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.RelativePositionRotationComponent;
import entity.component.system.components.TextureComponent;
import org.jetbrains.annotations.NotNull;

public class SpaceShipSubcomponent implements RelativePositionRotationBehavior, TextureBehavior {
	private final @NotNull EntityComponent entityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior;
	private final @NotNull TextureComponent textureComponent;

	public SpaceShipSubcomponent ( @NotNull final RelativePositionRotationComponent relativePositionAndRotationBehavior,
								   final @NotNull TextureComponent textureComponent ) {
		this.positionRotationComponent = new PositionRotationComponent ( new Vector2 ( 0, 0 ), 0 );
		this.relativePositionAndRotationBehavior = relativePositionAndRotationBehavior;
		this.textureComponent = textureComponent;
		entityComponent = new EntityComponent ( );
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}

	@Override public @NotNull RelativePositionRotationComponent getRelativePositionAndRotationComponent ( ) {
		return relativePositionAndRotationBehavior;
	}

	@Override public @NotNull TextureComponent getTextureComponent ( ) {
		return textureComponent;
	}

	@Override public @NotNull EntityComponent getEntityComponent ( ) {
		return entityComponent;
	}
}
