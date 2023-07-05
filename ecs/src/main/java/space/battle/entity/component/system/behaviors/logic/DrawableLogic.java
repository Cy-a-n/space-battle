package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing drawable entities in the game.
 */
class DrawableLogic {
	private final Set<TextureBehavior> entities = new HashSet<>();

	/**
	 * Adds a entity to the set of drawables.
	 *
	 * @param entity The entity to be added.
	 */
	void addEntity (@NotNull TextureBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a entity from the set of drawables.
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
		for (TextureBehavior entity : entities) {
			batch.draw(entity.getTextureRegion(), entity.getPosition().x - entity.getOrigin().x,
					entity.getPosition().y - entity.getOrigin().y, entity.getOrigin().x, entity.getOrigin().y,
					entity.getSize().y, entity.getSize().x, entity.getScale().x, entity.getScale().y,
					entity.getRotationDegrees());
		}
	}
}
