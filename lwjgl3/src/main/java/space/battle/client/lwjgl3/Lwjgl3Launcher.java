package space.battle.client.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import space.battle.client.App;

/**
 * Launches the desktop (LWJGL3) application.
 */
public class Lwjgl3Launcher {
	public static void main (String[] args) {
		if (StartupHelper.startNewJvmIfRequired())
			return; // This handles macOS support and helps on Windows.
		createApplication();
	}

	private static Lwjgl3Application createApplication () {
		return new Lwjgl3Application(new App(), getDefaultConfiguration());
	}

	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration () {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("space-battle");

		// Limits FPS to the refresh rate of the currently active monitor.
		configuration.useVsync(true);
		configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
		
		configuration.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		return configuration;
	}
}
