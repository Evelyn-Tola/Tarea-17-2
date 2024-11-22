package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorArchivos {
    private static final String ARCHIVO = "registro.log";

    public static void registrarEvento(String mensaje) {
        try (FileWriter writer = new FileWriter(ARCHIVO, true)) {
            LocalDateTime ahora = LocalDateTime.now();
            String fechaHora = ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(fechaHora + " - " + mensaje + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

