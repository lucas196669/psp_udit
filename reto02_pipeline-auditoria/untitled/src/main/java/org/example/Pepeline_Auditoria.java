package org.example;

import java.io.IOException;


public class Pepeline_Auditoria {
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        System.out.println("============");
        System.out.println("🚀PILDORA TECNICA : TOLERANCIA A FALLOS (RETRY)");
        System.out.println("=======================");


        try {
            ProcessBuilder pb1 = new ProcessBuilder("ping", "-n", "1", "-w", "3000", "127.0.0.1");
            ProcessBuilder pb2 = new ProcessBuilder("ping", "-n", "1", "-w", "3000", "192.0.2.1");

            pb1.redirectErrorStream(true).redirectOutput(ProcessBuilder.Redirect.DISCARD);
            pb2.redirectErrorStream(true).redirectOutput(ProcessBuilder.Redirect.DISCARD);

            Process p1 = pb1.start();
            Process p2 = pb2.start();

            int codigo1 = p1.waitFor();
            int codigo2 = p2.waitFor();

            System.out.println("Ping 127.0.0.1 -> " + codigo1);
            System.out.println("Ping 192.0.2.1 -> " + codigo2);

            int intentos1 = 0;

            while (codigo1 != 0 && intentos1 < 3) {
                intentos1++;
                System.out.println("reintento " + intentos1);
                Thread.sleep(1000);
                codigo1 = pb1.start().waitFor();
            }

            int intentos2 = 0;
            while (codigo2 != 0 && intentos2 < 3) {
                intentos2++;
                System.out.println("reintento " + intentos2);
                Thread.sleep(1000);
                codigo2 = pb2.start().waitFor();
            }


            if (codigo1 == 0 && codigo2 == 0) {
                new ProcessBuilder("notepad.exe").start();
            } else {
                new ProcessBuilder("calc.exe").start();
            }
        } catch (IOException e) {
            System.err.println("Error al lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Espera interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("Tiempo total: " + (System.currentTimeMillis() - inicio) + " ms");
    }
}