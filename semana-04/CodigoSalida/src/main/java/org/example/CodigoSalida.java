package org.example;

import java.io.IOException;

public class CodigoSalida {
    public static void main(String[] args){
        System.out.println("================================");
        System.out.println("COMPROBACION DE SERVIDOR");
        System.out.println("================================");

        try{
            ProcessBuilder pb = new ProcessBuilder(
                    "ping",
                    "-n",
                    "1",
                    "8.8.8.8"
            );

            Process proceso = pb.start();


            System.out.println("PID" + proceso.pid());

            int codigoSalida = proceso.waitFor();

            System.out.println("codigo de salida :" + codigoSalida);
            if (codigoSalida == 0) {
                System.out.println("ESTADO: ACTIVO");
            }else{

                    System.out.println("ESTADO:CAIDO");
                }
            }catch (IOException e){
                System.out.println("error al lanzzar el proeso");
            }catch(InterruptedException e){
                System.out.println("La espera del proceso fue interrumpida");
            }
        System.out.println("===============");
        System.out.println("COMPROBACION DEL SERVIDOR");
        System.out.println("===============");
            }
            }
        }

    }
}
