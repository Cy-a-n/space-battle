package space.battle.client.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;

class BaseEntity {
    ArrayList<Entity> childEntities;

    /**
     * Returns the child entities of the current entity.
     */
    public ArrayList<Entity> getChildEntities() {
        return childEntities;
    }

    // TODO: Use link tag, once I decided on proper name for App

    /**
     * Called on startup from ApplicationListener.create().
     * Useful for instantiating types like {@link SpriteBatch} and {@link Texture}
     * that rely on native libraries, which have to be loaded into memory before use.
     */
    public void create() {
    }

    // TODO: Use {link} tag for physics sim after implementation

    /**
     * This method is called every frame after the physics simulation ran.
     * Useful for updating the entity's position based on the result of the physic simulation, reading input and updating the physics simulation for the next frame.
     */
    public void update() {
    }

    // TODO: Move method to some kind of base drawable entity

    /**
     * This method is called every frame at the end of the loop after {@link #update()}.
     * Draw the associated shape or texture of the entity, if present, centered around the position and rotation of the entity.
     *
     * @param batch       The {@link SpriteBatch} used for drawing {@link Texture} or {@link TextureRegion}.
     * @param shapeDrawer The {@link ShapeDrawer} used for drawing simple shapes. Unlike {@link ShapeRenderer} it can be called during {@link SpriteBatch#begin()} and {@link SpriteBatch#end()}
     */
    public void draw(SpriteBatch batch, ShapeDrawer shapeDrawer) {
    }

    /**
     * Called on the end of the applications lifecycle from ApplicationListener.Dispose().
     * Useful for disposing types like {@link SpriteBatch} and {@link Texture} that rely on native libraries.
     */
    public void dispose() {
    }
}
