package entity.component.system.behaviors;

import entity.component.system.behaviors.CollisionShapeBehavior;
import entity.component.system.behaviors.ConstantMovementBehavior;
import entity.component.system.behaviors.TextureBehavior;
import org.jetbrains.annotations.NotNull;

public interface ProjectileBehavior extends ConstantMovementBehavior, TextureBehavior, CollisionShapeBehavior, LifeTimeBehavior {}
