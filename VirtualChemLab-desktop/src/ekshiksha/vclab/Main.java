package ekshiksha.vclab;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "VirtualChemLab";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 480;
		cfg.resizable = true;
		new LwjglApplication(new VCLabStarter(), cfg);
	}
}
