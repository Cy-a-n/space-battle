package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasRotationDegrees;
import space.battle.entity.component.system.components.HasRotationalVelocity;

public interface ConstantRotationBehavior extends Entity, RotationDegreesBehavior, HasRotationalVelocity {}
