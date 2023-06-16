package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

interface Entity {
    /**
     * Returns the child entities of the current entity.
     */
    List<Entity> getChildEntities();

    /**
     * Returns the X coordinate of the center of the entity.
     */
    float getCenterX();

    /**
     * Returns the Y coordinate of the center of the entity.
     */
    float getCenterY();

    /**
     * Returns the width of the entity ignoring rotation.
     */
    int getWidth();

    /**
     * Returns the height of the entity ignoring rotation.
     */
    int getHeight();

    /**
     * Returns the rotation of the entity in degrees.
     */
    float getRotationDegrees();

    /**
     * Returns the texture (sprite) of the entity.
     */
    Texture getTexture();

    /**
     * This method is called before the physic simulation calculates the next step.
     * Useful for getting user input and updating the physics simulation.
     */
    void updateBeforePhysicsSimulation();

    /**
     * This method is called after the physics simulation calculates the next step.
     * Useful for updating the entity based on the result of the physic simulation.
     */
    void updateAfterPhysicsSimulation();

    /**
     * Draws the texture at the position and rotation of the entity.
     * This method is called at the end of the loop after updateAfterPhysicsSimulation.
     * @param batch The SpriteBatch used for drawing
     */
    void draw(SpriteBatch batch);
}

