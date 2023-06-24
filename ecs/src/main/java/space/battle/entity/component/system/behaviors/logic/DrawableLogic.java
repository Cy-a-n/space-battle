package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing drawable entities in the game.
 */
public class DrawableLogic {
	private static Set<IsDrawable> drawables = new HashSet<>();

	/**
	 * Returns an unmodifiable set of drawable entities in the game.
	 *
	 * @return An unmodifiable set of drawable entities.
	 */
	public static Set<IsDrawable> getDrawables () {
		return Collections.unmodifiableSet(drawables);
	}

	/**
	 * Adds a drawable entity to the set of drawables.
	 *
	 * @param drawable The drawable entity to be added.
	 */
	static void addDrawables (@NotNull IsDrawable drawable) {
		drawables.add(drawable);
	}

	/**
	 * Updates the drawable entities by rendering them with the specified SpriteBatch and OrthographicCamera.
	 *
	 * @param batch  The SpriteBatch used for drawing the entities.
	 * @param camera The OrthographicCamera used for rendering the entities.
	 */
	static void update (@NotNull SpriteBatch batch, @NotNull OrthographicCamera camera) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (IsDrawable drawable : drawables) {
			if (drawable.getOrigin() == null || drawable.getSize() == null || drawable.getScale() == null)
				batch.draw(drawable.getTextureRegion(), drawable.getPosition().getX(), drawable.getPosition().getY());
			else
				batch.draw(drawable.getTextureRegion(), drawable.getPosition().getX(), drawable.getPosition().getY(),
						drawable.getOrigin().getX(), drawable.getOrigin().getY(), drawable.getSize().getWidth(),
						drawable.getSize().getHeight(), drawable.getScale().getX(), drawable.getScale().getY(),
						drawable.getRotationDegrees());
		}
		batch.end();
	}
}
