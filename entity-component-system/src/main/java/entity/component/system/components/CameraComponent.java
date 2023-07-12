package entity.component.system.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.PositionRotationBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The CameraComponent class represents the camera properties of an entity.
 * It contains a viewport and an associated orthographic camera.
 */
public class CameraComponent {
	private final @NotNull Viewport viewport;
	private final @NotNull OrthographicCamera camera;
	private final @NotNull Set<PositionRotationBehavior> entitiesAlwaysInFrame;
	private final float boundary;

	public void addEntityAlwaysInFrame ( final PositionRotationBehavior entityInFrame ) { entitiesAlwaysInFrame.add ( entityInFrame ); }

	public Set<PositionRotationBehavior> getEntitiesAlwaysInFrame ( ) {
		return Collections.unmodifiableSet ( entitiesAlwaysInFrame );
	}

	/**
	 * Constructs a new CameraComponent with the specified viewport.
	 *
	 * @param viewport              the viewport associated with the camera
	 * @param boundary
	 * @param entitiesAlwaysInFrame
	 * @throws IllegalArgumentException if the viewport does not contain a non-null instance of OrthographicCamera
	 */
	public CameraComponent ( @NotNull final Viewport viewport,
							 final float boundary,
							 final @NotNull PositionRotationBehavior... entitiesAlwaysInFrame ) {
		this.boundary = boundary;

		if ( viewport.getCamera ( ) == null || !( viewport.getCamera ( ) instanceof OrthographicCamera orthographicCamera ) )
			throw new IllegalArgumentException ( "Viewport must contain a non-null instance of OrthographicCamera" );

		this.viewport = viewport;
		this.camera = orthographicCamera;
		this.entitiesAlwaysInFrame = new HashSet<> ( List.of ( entitiesAlwaysInFrame ) );
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
