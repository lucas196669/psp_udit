package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("---INICIANDO UDITVERSUM");
        //MAla practica: toda la logica de negocio tirada al Main
        //los diamanres <> obligan a que la lista solo acepten episodios
        ArrayList<Episode>catalogo = new ArrayList<>();

        catalogo.add(new Episode("Diseño 3D -Intro", 45));
        catalogo.add(new Episode("Animacion", 60));
        catalogo.add(new Episode("Texturas", 50));

        //Medicion tiempo
        //long se usa porque milisegundos  son desde 1970 forman un numero tan gigantesco que no entra en la memoria del int

        long inicio = System.currentTimeMillis();

        for(Episode ep : catalogo){
            ep.procesar(); // Aqui ocurre el bloqueo de dos segundos
        }

        long fin = System.currentTimeMillis();

        //Resultado: Restamos fin menos inicio y diviimos entre mil (segundos)

        long totalSegundos = (fin - inicio)/1000;

        System.out.println(("tiempo total: " + totalSegundos + " Segundos de bloqueo"));
    }
}