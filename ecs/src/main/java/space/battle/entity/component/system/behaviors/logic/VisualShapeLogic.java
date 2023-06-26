package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.Color;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.VisualShapeBehavior;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class VisualShapeLogic {
	private final List<VisualShapeBehavior> visualShapes = new ArrayList<>();

	public List<VisualShapeBehavior> getVisualShapes () {
		return Collections.unmodifiableList(visualShapes);
	}

	void addVisualShape (@NotNull VisualShapeBehavior visualShape) {
		visualShapes.add(visualShape);
	}

	void update (@NotNull ShapeDrawer shapeDrawer) {
		for (VisualShapeBehavior visualShape : visualShapes) {
			shapeDrawer.setColor(Color.WHITE);
			shapeDrawer.polygon(visualShape.getShape());
		}
	}
}
