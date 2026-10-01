package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonitorCatalogo {

    public static void main(String[] args) {

        // PASO 1: matriz de dos dimensiones
        // cada fila es un vídeo: columna 0 -> nombre, columna 1 -> dirección a comprobar
        // las direcciones que no existen simulan un vídeo caído
        // 127.0.0.1 siempre responde, así que simula un vídeo activo
        String[][] catalogo = {
                {"Animación 3D", "animacion3d.noexiste"},
                {"Videojuegos", "videojuegos.noexiste"},
                {"Kotlin", "kotlin.noexiste"},
                {"Android", "127.0.0.1"},
                {"Flutter", "127.0.0.1"}
        };

        System.out.println("== UDITFLIX CATÁLOGO ==");
        System.out.println("Comprobando servicio");


        for (int i = 0; i < catalogo.length; i++) {

            String nombre = catalogo[i][0];
            String direccion = catalogo[i][1];

            System.out.println("[VÍDEO] " + nombre);

            // TRY/CATCH
            // try -> intenta hacer esto
            // catch -> si algo sale mal, haz esto en vez de romper el programa
            try {
                // PASO 3: preparar el proceso (todavía no se ejecuta)
                // ping -> programa que queremos ejecutar
                // -n 1 -> opción de Windows: haz solo un intento
                // -w 1000 -> espera como máximo 1000 ms la respuesta
                // direccion -> la dirección que sacamos de la matriz
                ProcessBuilder pb = new ProcessBuilder(
                        "ping", "-n", "1", "-w", "1000", direccion
                );

                // PASO 4: unir salida normal y salida de error en un solo canal
                pb.redirectErrorStream(true);

                // PASO 5: lanzar el proceso
                // start() es el botón de enviar: ahora sí se crea el proceso nuevo
                Process proceso = pb.start();

                // PASO 6: mostrar el PID (el "DNI" del proceso)
                System.out.println("PID: " + proceso.pid());

                // PASO 7: preparar la lectura de lo que dice el proceso
                // getInputStream() -> tubería por la que sale el texto del proceso
                // InputStreamReader -> traduce los bytes a letras
                // BufferedReader -> nos deja leer línea a línea
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream())
                );

                // PASO 8: leer todo lo que escribe el proceso
                // no lo imprimimos para que la consola quede como el resultado esperado
                // (si quieres verlo, añade System.out.println(linea); dentro del while)
                String linea;
                while ((linea = lector.readLine()) != null) {
                    // aquí solo consumimos la salida del ping
                }
                lector.close();

                // PASO 9: esperar a que el proceso termine
                // waitFor() devuelve el código de salida: 0 = todo correcto
                int codigo = proceso.waitFor();

                // PASO 10: interpretar el resultado
                if (codigo == 0) {
                    System.out.println("ESTADO: ACTIVO");
                } else {
                    System.out.println("ESTADO: CAÍDO");
                }

            } catch (IOException e) {
                System.out.println("no se puede lanzar el proceso");
            } catch (InterruptedException e) {
                System.out.println("la ejecucion fue interrumpida");
            }
        }

        System.out.println("COMPROBACIÓN FINALIZADA");
    }
}