package entity.component.system.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.jetbrains.annotations.NotNull;

public class TextureComponent {
	private final @NotNull TextureRegion textureRegion;

	public TextureComponent (@NotNull final TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public @NotNull TextureRegion getTextureRegion () {
		return textureRegion;
	}
}
