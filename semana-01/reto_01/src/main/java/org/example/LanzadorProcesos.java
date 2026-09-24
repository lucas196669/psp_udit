package org.example;

import java.io.IOException;

public class LanzadorProcesos {
    public static void main (String[] args){
        System.out.println("Solicitaremos al SO la creacion de proceso nativo");

        //1. ProcessBuilder es el puente entre java y el sistema Operativo
        //Preparamos el comando( en windows, nitepad.exe es el block de notas)

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        try {
            Process proceso = pb.start();
            System.out.println("proceso en ejecucion. PID:" + proceso.pid());
            //waitFor() pausa nuestro hilo de java hasta que el usuario cierre el block de notas
            int salida = proceso.waitFor();
            System.out.println("Proceso externo finalizado con codigo" + salida);

        }catch (IOException e){
            System.out.println("Error: el sistema operativo no encuentra el programa.");

        }catch (InterruptedException e){
            System.out.println("Error: El proceso fue interrumpido bruscamente");
        }
    }
}
