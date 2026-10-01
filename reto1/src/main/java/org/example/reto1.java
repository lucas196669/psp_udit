package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class reto1 {

    public static void main(String[] args) {

        // 1. Matriz 2D: [nombre del vídeo][dirección de comprobación]
        String[][] catalogo = {
                {"Animación 3D", "animacion3d.uditflix.invalid"},
                {"Videojuegos", "videojuegos.uditflix.invalid"},
                {"Kotlin", "kotlin.uditflix.invalid"},
                {"Android", "127.0.0.1"},
                {"Flutter", "127.0.0.1"}
        };

        boolean esWindows = System.getProperty("os.name").toLowerCase().contains("win");

        System.out.println("========================================");
        System.out.println("UDITFLIX - CATÁLOGO");
        System.out.println("========================================");

        // 2. Recorrer la matriz con un bucle for
        for (int i = 0; i < catalogo.length; i++) {
            String nombre = catalogo[i][0];
            String direccion = catalogo[i][1];

            // Comando ping según el sistema operativo (1 solo paquete, timeout corto)
            List<String> comando = new ArrayList<>();
            comando.add("ping");
            if (esWindows) {
                comando.add("-n");
                comando.add("1");
                comando.add("-w");
                comando.add("1000");
            } else {
                comando.add("-c");
                comando.add("1");
                comando.add("-W");
                comando.add("1");
            }
            comando.add(direccion);

            System.out.println("[VÍDEO] " + nombre);

            try {
                // 3. Lanzar el proceso externo con ProcessBuilder
                ProcessBuilder pb = new ProcessBuilder(comando);
                pb.redirectErrorStream(true);
                Process proceso = pb.start();

                // 4. Mostrar el PID
                System.out.println("PID: " + proceso.pid());

                // 5. Leer la información que devuelve el proceso
                //    (se lee antes de waitFor() para no bloquear el buffer)
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream()));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    // Salida del ping leída (no se muestra para mantener
                    // la consola igual que el resultado esperado)
                }
                lector.close();

                // 6. Esperar a que termine
                int codigoSalida = proceso.waitFor();

                // 7. Determinar si está disponible (0 = respuesta correcta)
                boolean disponible = (codigoSalida == 0);

                // 8. Mostrar el resultado
                System.out.println("ESTADO: " + (disponible ? "ACTIVO" : "CAÍDO"));

            } catch (IOException e) {
                System.out.println("ERROR al lanzar el proceso: " + e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("ERROR: comprobación interrumpida");
            }
        }

        System.out.println("========================================");
        System.out.println("COMPROBACIÓN FINALIZADA");
        System.out.println("========================================");
    }
}