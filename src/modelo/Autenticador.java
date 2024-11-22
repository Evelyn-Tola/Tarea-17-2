package modelo;

public class Autenticador {
    private static final String USUARIO_CORRECTO = "admin";
    private static final String CONTRASENA_CORRECTA = "1234";

    public static boolean autenticar(String usuario, String contrasena) {
        return USUARIO_CORRECTO.equals(usuario) && CONTRASENA_CORRECTA.equals(contrasena);
    }
}

