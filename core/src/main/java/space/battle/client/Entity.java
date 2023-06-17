package space.battle.client;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.earlygrey.shapedrawer.ShapeDrawer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

interface Entity {
    /**
     * Returns the child entities of the current entity.
     */
    ArrayList<Entity> getChildEntities();

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

    // TODO: Use {link} tag for physics sim after implementation
    /**
     * This method is called every frame after the physics simulation .
     * Useful for updating the entity's position based on the result of the physic simulation, reading input and updating the physics simulation for the next frame.
     */
    void update();

    /**
     * This method is called every frame at the end of the loop after {@link #update()}.
     * Draw the associated shape or texture of the entity, if present, centered around the position and rotation of the entity.
     * @param batch The {@link SpriteBatch} used for drawing {@link Texture} or {@link TextureRegion}.
     * @param shapeDrawer The {@link ShapeDrawer} used for drawing simple shapes. Unlike {@link ShapeRenderer} it can be called during {@link SpriteBatch#begin()} and {@link SpriteBatch#end()}
     */
    void draw(SpriteBatch batch, ShapeDrawer shapeDrawer);
}

