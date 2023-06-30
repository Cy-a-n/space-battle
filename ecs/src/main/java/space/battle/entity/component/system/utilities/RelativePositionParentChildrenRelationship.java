package space.battle.entity.component.system.utilities;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.components.HasChildrenWithRelativePosition;
import space.battle.entity.component.system.components.HasRelativePosition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelativePositionParentChildrenRelationship {
	private final @NotNull List<HasRelativePosition> children;
	private HasChildrenWithRelativePosition parent;

	public RelativePositionParentChildrenRelationship (@NotNull List<HasRelativePosition> children) {
		this.children = children;
	}

	public RelativePositionParentChildrenRelationship (HasChildrenWithRelativePosition parent) {
		this.parent = parent;
		this.children = new ArrayList<>();
	}

	public RelativePositionParentChildrenRelationship (@NotNull HasChildrenWithRelativePosition parent,
													   @NotNull List<HasRelativePosition> children) {
		this.parent = parent;
		this.children = children;
	}

	public HasChildrenWithRelativePosition getParent () {
		return parent;
	}

	public List<HasRelativePosition> getChildren () {
		return Collections.unmodifiableList(children);
	}

	public void addChild (HasRelativePosition child) {
		children.add(child);
	}
}
