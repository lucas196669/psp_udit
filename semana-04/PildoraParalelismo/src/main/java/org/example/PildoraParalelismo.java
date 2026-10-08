package org.example;

import java.io.IOException;

public class PildoraParalelismo {

    public static void main(String[] args){
        System.out.println("============");
        System.out.println("🚀PILDORA TECNICA : SECUENCIA VS PARALELO");
        System.out.println("=======================");

        try {
            System.out.println("iniciando prueba secuencial");
            long inicioSecuencial = System.currentTimeMillis();

            System.out.println("   ->Lanzando proceso 1 y esperando que muera");
            Process p1 = new ProcessBuilder("ping", "-n", "2", "127.0.0.1").start();
            p1.waitFor();
            System.out.println("   ->Lanzando proceso 2 y esperando que muera");
            Process p2 = new ProcessBuilder("ping", "-n", "2", "8.8.8.8").start();
            p2.waitFor();

            long finishSecuencial = System.currentTimeMillis();
            System.out.println("TIEMPO TOTAL SECUENCIAL" + (finishSecuencial - inicioSecuencial) + "ms\n");

            System.out.println("===========================================");
            System.out.println("INICIANDO EJECUCION PARALELA");


            long inicioParalelo = System.currentTimeMillis();

            System.out.println("LANZANDO PROCESO 3");
            Process p3 = new ProcessBuilder("ping", "-n", "2", "127.0.0.1").start();
            System.out.println("LANZANDO PROCESO 4");
            Process p4 = new ProcessBuilder("ping", "-n", "2", "8.8.8.8").start();

            System.out.println("BLOQUEAMOS JAVA PARA RECOGER RESULTADOS");
            p3.waitFor();
            p4.waitFor();

            long finParalelo = System.currentTimeMillis();
            System.out.println("TIEMPO TOTAL PARALELO" +(finParalelo - inicioParalelo) + "ms\n");
        }catch (IOException e) {
            System.out.println("Error:No se pudo lanzar el proceso");
        }catch (InterruptedException e){
            System.out.println("Error: La espera fue interrumpida");


            }
        }
    }
}
