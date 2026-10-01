package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PildoraMonitor {

    public static void  main(String[] args) {

        System.out.println(("===MONITOR UDIFLIX==="));
        System.out.println(("comprobando servicio"));

        //TRY/CATCH
        //try->intenta hacer esto
        //catch->si algo sale mal haz esto en vz de roper el programa
        try {
            //paso 1 preparar el proceso(todavia no se ejecuta)
            // ProcessBuilder -> encargado de preparar la orden que le daremos al sistema operativo es como rellenar un formulario
            //ping-> programa que queremos ejecutar
            // -n-> opcion de windows: numero de intentos
            //1-> haz solo un intento
            ProcessBuilder pb = new ProcessBuilder(
                    "ping", "-n", "1", "127.0.0.1"
            );
            //paso 2 unir los dos canales de salida
            //todo programa tiene salidas por el que hablan
            //salida normal(lo que va)
            //salida error(el mensaje que da fallo)
            // pb.redirectErrorStream(true); lo juntamos en uno solo asi leyendo un unico canal vemos todo lo que el prces diga sea un resultado normal o un error

            pb.redirectErrorStream(true);

            //paso 3 lanzar el proceso
            //star() es el boton de enviar. ahora si el sistema operativo crea un prorama nuevo ue hace y ping y corre por su cuenta con su propia memoria separado de nuestro programa java.
            //process es el objeto con el controlamos el programa

            Process proceso = pb.start();
             //paso 4 mostrar PID
            //PID es un process IDentifier es el dni del proceso

            System.out.println("PID: " + proceso.pid());

            //Paso 5 preparar la lectura de lo que dice el proceso

            //El proceso ping escribe su propia consola, que java no ve
            //Para escucharlo nos conectamos a su salida con una cadena
            //proceso.getInputStream()-> es al tuberia por la que sal el texto del proceso
            //el texto del procso (en bytes)
            //new InputStremReader(...) -> traduce esos bytes a letras
            //new BufferReader(...) nos deja leer linea a linea

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())

            );
            //variable donde guardaremos cada linea
            String linea;

            //Paso 6 leer todo lo que el proeso va a escribir
            while((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            //paso 7 esperar a que el proceso termine
            int codigo = proceso.waitFor();

            //paso 8 interpretar el resultado

            if (codigo == 0) {
            System.out.println("estado: servicio activo");
            }else {
                System.out.println("estado: servicio con error");
            }
            }catch (IOException e) {
            System.out.println("no se puede lanzar el proceso");
            }catch (InterruptedException e) {
            System.out.println("la ejecucion fue interrumpida");


        }
    }
}
