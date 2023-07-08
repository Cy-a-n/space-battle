package entity.component.system.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.TextureBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing drawable entities in the game.
 */
class TextureLogic {
	private final Set<TextureBehavior> entities = new HashSet<>();

	/**
	 * Adds an entity to the set of drawables.
	 *
	 * @param entity The entity to be added.
	 */
	void addEntity (@NotNull TextureBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes an entity from the set of drawables.
	 *
	 * @param entity The entity to be removed.
	 */
	void removeEntity (@NotNull TextureBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the drawable entities by rendering them with the specified SpriteBatch.
	 *
	 * @param batch The SpriteBatch used for drawing the entities.
	 */
	void update (@NotNull SpriteBatch batch) {
		for (final @NotNull TextureBehavior entity : entities) {
			final @NotNull Vector2 position = entity.getPositionComponent().getVector2();
			final @NotNull TextureRegion textureRegion = entity.getTextureComponent().getTextureRegion();
			final int width = textureRegion.getRegionWidth();
			final int height = textureRegion.getRegionHeight();

			batch.draw(textureRegion, position.x - (float) width / 2, position.y - (float) height / 2, position.x,
					position.y, width, height, 1, 1, entity.getRotationComponent().getDegrees());
		}
	}
}
