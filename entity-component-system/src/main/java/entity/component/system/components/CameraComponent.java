package entity.component.system.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.jetbrains.annotations.NotNull;

/**
 * The CameraComponent class represents the camera properties of an entity.
 * It contains a viewport and an associated orthographic camera.
 */
public class CameraComponent {
	private final @NotNull Viewport viewport;
	private final @NotNull OrthographicCamera camera;

	/**
	 * Constructs a new CameraComponent with the specified viewport.
	 *
	 * @param viewport the viewport associated with the camera
	 * @throws IllegalArgumentException if the viewport does not contain a non-null instance of OrthographicCamera
	 */
	public CameraComponent ( @NotNull final Viewport viewport ) {
		if ( viewport.getCamera ( ) == null || !( viewport.getCamera ( ) instanceof OrthographicCamera orthographicCamera ) ) {
			throw new IllegalArgumentException ( "Viewport must contain a non-null instance of OrthographicCamera" );
		}

		this.viewport = viewport;
		this.camera = orthographicCamera;
	}

	/**
	 * Returns the orthographic camera associated with the camera component.
	 *
	 * @return the orthographic camera
	 */
	public @NotNull OrthographicCamera getCamera ( ) {
		return camera;
	}

	/**
	 * Returns the viewport associated with the camera component.
	 *
	 * @return the viewport
	 */
	public @NotNull Viewport getViewport ( ) {
		return viewport;
	}
}
