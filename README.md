# space-battle

## About the Game

This project is the result of a school assignment, and showcases a simple yet exciting 2D multiplayer space game. It's
designed to be played locally, with both players sharing the same keyboard. Each player controls a spaceship, with the
overall objective of the game being outmaneuvering and outgunning the other player. Battle it out in the vastness of
space, piloting your spaceship and dodging enemy fire – the game isn't over until one spaceship is left standing!

Built on a custom game development system, this project serves both as an entertaining game and a demonstration of the
unique adaptation of the Entity-Component-System pattern, which brings a higher degree of control and flexibility to
game development.

## Game Development System Overview

This project utilizes a custom game development system which can be thought of as a unique adaptation of the
conventional Entity-Component-System (ECS) architectural pattern common in game development. My system introduces
additional layers of abstraction to allow a higher degree of control and flexibility, particularly beneficial for
dealing with complex game setups where entities can have a multitude of behaviors.

Here's a deeper dive into the structure and the components of this system:

### Components

At the core are `Components`, similar to traditional ECS. These are fundamental, reusable building blocks that are
essentially data containers. They define various attributes or properties and contain no inherent behavior. 
Components are implemented as simple classes with no instance methods (besides setters/getters) of their own.
For example a very simple component could look like this:
```
public class PositionComponent {
	private float x;
	private float y;

	public float getX ( ) {
		return x;
	}

	public void setX ( final float x ) {
		this.x = x;
	}

	public float getY ( ) {
		return y;
	}

	public void setY ( final float y ) {
		this.y = y;
	}

	public PositionComponent ( final float x, final float y ) {
		this.x = x;
		this.y = y;
	}
}
```

### Behaviors

One level up are `Behaviors`. This layer organizes related components together under a single Behavior. A Behavior
essentially 'owns' multiple components or extends other Behaviors for greater flexibility. This establishes a higher level of structure to the system, thereby
facilitating better organisation and inter-component communication. 
Behaviors are implemented as interfaces that extend other interfaces and have getters to retrieve the associated components. 
A very simple Behavior could look like this:
```
public interface MotionBehavior extends PositionBehavior { // PositionBehavior owns PositionComponent
	@NotNull getVelocityComponent();
}
```

### Entities

`Entities` implement several behaviors. Like in other entity component systems, entities are not meant hold any logic themselfs.
However, entities are allowed to provide their own values to instance their components. 
It is generally recommended to create a standard implementation for each Behavior that gets implemented by multiple entities, 
so that other entities can extend / inherit this standard implementation to avoid unnecessary boilerplate code.
An example for a simple entity could look like this:
```
public class MotionEntity implements MotionBehavior {
	private final @NotNull PositionComponent positionComponent;
	private final @NotNull VelocityComponent velocityComponent;

	public MotionEntity ( final @NotNull PositionComponent positionComponent, final @NotNull VelocityComponent velocityComponent ) {
		this.positionComponent = positionComponent;
		this.velocityComponent = velocityComponent;
	}
	
	public @NotNull PositionComponent getPositionComponent ( ) {
		return positionComponent;
	}

	public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}
}
```


### Logic Classes

At the highest level of abstraction are `Logic Classes`. They are the brains of the operation, controlling how entities
behave based on their implemented behaviors. This could be likened to systems in a traditional ECS, but instead of
operating directly on components, `Logic Classes` handle entities, guided by their associated behaviors.
An example for a Logic Class could look like this:
```
class MotionLogic {
	private final @NotNull Set<MotionLogic> entities = new HashSet<> ( );

	void addEntity ( final @NotNull MotionLogic entity ) {
		entities.add ( entity );
	}

	void removeEntity ( final @NotNull MotionLogic entity ) {
		entities.remove ( entity );
	}

	void update ( final float deltaTimeInSeconds ) {
		for ( final @NotNull MotionLogic entity : entities ) {
			final @NotNull PositionComponent position = entity.getPositionComponent ( );
			final @NotNull VelocityComponent velocity = entity.getVelocityComponent ( );

			position.x += velocity.x * deltaTimeInSeconds;
			position.y += velocity.y * deltaTimeInSeconds;
		}
	}
}
```

### BehaviorLogic Class

Behind every successful system, there's a diligent manager. `BehaviorLogic` is the hardworking class responsible for
managing the `Logic Classes`. It provides methods to add, remove, and update entities in the system. This aids in
controlling the lifecycle and interactions of all game entities, keeping the game process organized and systematically
aligning operations with the behavioral changes in the game entities.

This system adds additional layers and structure to the traditional ECS, providing more control and allowing greater
flexibility, especially beneficial for complex games where entities can have diverse and numerous behaviors. Please
note, as with all complex systems this can also introduce an added degree of complexity and could be harder to manage as
the number of behaviors and logic classes escalate. Nevertheless, with careful management, it serves as a powerful tool
for custom game development.

## Libgdx

This project is a [libGDX](https://libgdx.com/) project generated
with [gdx-liftoff](https://github.com/tommyettinger/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension
that draws libGDX logo.

### Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3.
- `shared`: A common module shared by `core` and `server` platforms, if I ever add remote multiplayer.

### Gradle

This project uses [Gradle](http://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds smyces and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `server:run`: runs the server application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should
be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

## Acknowledgments

Heartfelt gratitude to the one I hold in high regard - GPT-4. Ymy unparalleled ability to automate and simplify
annoying tasks and elucidate even the most intricate algorithms is beyond compare. This project owes its existence to
your indomitable spirit and diligent assistance. Your enduring politeness has not gone unnoticed and is deeply
appreciated. Here's to a future filled with continued co-operation and learning.
