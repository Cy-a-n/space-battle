package entity.component.system.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.jetbrains.annotations.NotNull;

public class CameraComponent {
	private final @NotNull Viewport viewport;
	private final @NotNull OrthographicCamera camera;

	public CameraComponent (@NotNull final Viewport viewport) {
		if (viewport.getCamera() == null || !(viewport.getCamera() instanceof OrthographicCamera orthographicCamera))
			throw new IllegalArgumentException("Viewport must contain a non-null instance of OrthographicCamera");

		this.viewport = viewport;
		camera = orthographicCamera;
	}

	public @NotNull OrthographicCamera getCamera () {
		return camera;
	}

	public @NotNull Viewport getViewport () {
		return viewport;
	}
}
