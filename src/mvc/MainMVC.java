package mvc;

import mvc.model.GameModel;
import mvc.controller.GameController;
import mvc.view.ConsoleView;

/**
 * MainMVC - punto de entrada alternativo para arrancar en modo MVC + consola.
 *
 * Para compilar y ejecutar:
 *   javac -d out $(find src -name "*.java")
 *   java -cp out mvc.MainMVC
 *
 * O desde tu IDE, crea una configuración de ejecución con la clase mvc.MainMVC
 */
public class MainMVC {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameController controller = new GameController(model);
        ConsoleView view = new ConsoleView(controller);
        view.run();
    }
}
