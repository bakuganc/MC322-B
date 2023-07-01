import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class MeuMenu extends Screen {
    private Menu menu;

    public MeuMenu() {
        super("meu-menu"); // Defina um nome para a tela
    }

    @Override
    public void initializeComponents() {
        this.menu = new Menu(this.getWidth() / 2 - 100, this.getHeight() / 2 - 100, 200, 200);
        this.menu.addMenuItem("Novo Jogo", this::iniciarNovoJogo);
        this.menu.addMenuItem("Opções", this::abrirOpcoes);
        this.menu.addMenuItem("Sair", this::sairDoJogo);
        this.menu.setFont(Resources.fonts().get("Arial").deriveFont(24f));

        this.getComponents().add(this.menu);
    }

    private void iniciarNovoJogo() {
        // Lógica para iniciar um novo jogo
    }

    private void abrirOpcoes() {
        // Lógica para abrir o menu de opções
    }

    private void sairDoJogo() {
        // Lógica para sair do jogo
    }
}
