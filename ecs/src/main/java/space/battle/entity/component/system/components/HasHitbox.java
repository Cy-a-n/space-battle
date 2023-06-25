package space.battle.entity.component.system.components;

import space.battle.entity.component.system.dataclasses.Vector2;

import java.util.ArrayList;

public interface HasHitbox {
	ArrayList<Vector2> getHitbox ();
}
