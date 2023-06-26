package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;

import java.util.*;

/**
 * This class provides logic for managing drawable entities in the game.
 */
public class DrawableLogic {
	private List<TextureBehavior> drawables = new ArrayList<>();

	/**
	 * Returns an unmodifiable set of drawable entities in the game.
	 *
	 * @return An unmodifiable set of drawable entities.
	 */
	public List<TextureBehavior> getDrawables () {
		return Collections.unmodifiableList(drawables);
	}

	/**
	 * Adds a drawable entity to the set of drawables.
	 *
	 * @param drawable The drawable entity to be added.
	 */
	void addDrawables (@NotNull TextureBehavior drawable) {
		drawables.add(drawable);
	}

	/**
	 * Updates the drawable entities by rendering them with the specified SpriteBatch and OrthographicCamera.
	 *
	 * @param batch The SpriteBatch used for drawing the entities.
	 */
	void update (@NotNull SpriteBatch batch) {
		for (TextureBehavior drawable : drawables) {
			batch.draw(drawable.getTextureRegion(), drawable.getPosition().x, drawable.getPosition().y,
					drawable.getOrigin().x, drawable.getOrigin().y, drawable.getSize().y, drawable.getSize().x,
					drawable.getScale().x, drawable.getScale().y, drawable.getRotationDegrees());
		}
	}
}
