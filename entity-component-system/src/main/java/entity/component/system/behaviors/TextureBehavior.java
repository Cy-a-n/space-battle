package entity.component.system.behaviors;

import entity.component.system.components.TextureComponent;
import org.jetbrains.annotations.NotNull;

public interface TextureBehavior extends PositionRotationBehavior {
	@NotNull TextureComponent getTextureComponent ( );
}
