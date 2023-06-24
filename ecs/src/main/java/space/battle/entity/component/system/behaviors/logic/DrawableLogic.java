package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DrawableLogic {
	private static Set<IsDrawable> drawables = new HashSet<>();

	public static Set<IsDrawable> getDrawables () {
		return Collections.unmodifiableSet(drawables);
	}

	static void addDrawables (@NotNull IsDrawable drawable) {
		drawables.add(drawable);
	}

	static void update (SpriteBatch batch, OrthographicCamera camera) {
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
