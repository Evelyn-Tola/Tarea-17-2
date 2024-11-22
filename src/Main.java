import controlador.ControladorLogin;
import javax.swing.SwingUtilities;
import ventana.VentanaLogin;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaLogin vista = new VentanaLogin();
            new ControladorLogin(vista);
            vista.setVisible(true);
        });
    }
}

