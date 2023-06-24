package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;

import java.util.ArrayList;
import java.util.List;

public class BehaviorLogic {
	public static void addEntity (@NotNull Object entity) {
		if (entity instanceof IsDrawable)
			DrawableLogic.addDrawables((IsDrawable) entity);

		if (entity instanceof IsCamera)
			CameraLogic.addCamera((IsCamera) entity);
	}

	public static void updateWithGraphics (SpriteBatch batch, OrthographicCamera camera) {
		CameraLogic.update(camera);
		DrawableLogic.update(batch, camera);
	}
}
