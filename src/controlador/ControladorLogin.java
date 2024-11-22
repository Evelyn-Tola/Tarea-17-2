package controlador;

import modelo.Autenticador;
import modelo.GestorArchivos;
import ventana.VentanaLogin;

import javax.swing.*;
import java.awt.event.*;

public class ControladorLogin {
    private VentanaLogin vista;

    public ControladorLogin(VentanaLogin vista) {
        this.vista = vista;
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Eventos de entrada y salida en el campo de usuario
        vista.getTxtUsuario().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                GestorArchivos.registrarEvento("Entrada en campo Usuario");
            }

            @Override
            public void focusLost(FocusEvent e) {
                GestorArchivos.registrarEvento("Salida del campo Usuario");
            }
        });

        // Eventos de entrada y salida en el campo de contraseña
        vista.getTxtContrasena().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                GestorArchivos.registrarEvento("Entrada en campo Contraseña");
            }

            @Override
            public void focusLost(FocusEvent e) {
                GestorArchivos.registrarEvento("Salida del campo Contraseña");
            }
        });

        // Eventos de mouse sobre el botón de login
        vista.getBtnLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                GestorArchivos.registrarEvento("Mouse entra en el botón Login");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                GestorArchivos.registrarEvento("Mouse sale del botón Login");
            }
        });

        // Evento del botón de login
        vista.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }

    private void realizarLogin() {
        String usuario = vista.getTxtUsuario().getText();
        String contrasena = new String(vista.getTxtContrasena().getPassword());

        if (Autenticador.autenticar(usuario, contrasena)) {
            GestorArchivos.registrarEvento("Login exitoso con usuario: " + usuario);
            JOptionPane.showMessageDialog(vista, "Login exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            GestorArchivos.registrarEvento("Login fallido con usuario: " + usuario);
            JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

