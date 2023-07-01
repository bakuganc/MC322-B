import de.gurkenlabs.litiengine.Game;
import java.awt.Dimension;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.GameWorld;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.util.Imaging;

public class Main {

  public static void main(String[] args) {
	  Game.init(args);
      Game.window().getResolution().setSize(800, 600);
      MeuMenu menu = new MeuMenu();
      Game.screens().add(menu);
      Game.screens().display(menu);

      Game.start();
  }
}