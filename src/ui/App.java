package ui;

import sistema.Sistema;
import sistema.SistemaImpl;

public class App {

	public static void main(String[] args) {
		Sistema sistema = new SistemaImpl();

		InterfazGrafica gui = new InterfazGrafica(sistema);
        gui.setVisible(true);

	}

}
