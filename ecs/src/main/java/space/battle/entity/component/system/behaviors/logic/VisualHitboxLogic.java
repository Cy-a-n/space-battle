package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.Color;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.VisualHitboxBehavior;
import space.battle.entity.component.system.dataclasses.Vector2;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class VisualHitboxLogic {
	private static Set<VisualHitboxBehavior> visualHitboxes = new HashSet<>();


	public static Set<VisualHitboxBehavior> getVisualHitboxes () {
		return Collections.unmodifiableSet(visualHitboxes);
	}

	static void addVisualHitboxEntity (@NotNull VisualHitboxBehavior visualHitbox) {
		visualHitboxes.add(visualHitbox);
	}

	static void update (ShapeDrawer shapeDrawer) {
		for (VisualHitboxBehavior hitbox : visualHitboxes) {
			
		}
	}

}
