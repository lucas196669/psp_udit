package org.example;

import java.io.IOException;


public class Pepeline_Auditoria {
    public static void main(String[] args) {

        System.out.println("============");
        System.out.println("🚀PILDORA TECNICA : SECUENCIA VS PARALELO");
        System.out.println("=======================");


        try {
            ProcessBuilder pb1 = new ProcessBuilder("ping", "-n", "2", "127.0.0.1");
            ProcessBuilder pb2 = new ProcessBuilder("ping", "-n", "2", "error.invalid");

            pb1.redirectErrorStream(true).redirectOutput(ProcessBuilder.Redirect.DISCARD);
            pb2.redirectErrorStream(true).redirectOutput(ProcessBuilder.Redirect.DISCARD);

            Process p1 = pb1.start();
            Process p2 = pb2.start();

            int codigo1 = p1.waitFor();
            int codigo2 = p2.waitFor();

            System.out.println("Ping 127.0.0.1 -> " + codigo1);
            System.out.println("Ping error.invalid -> " + codigo2);

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
    }
}