package org.example;

public class Episode {

    private String titulo;
    private int duracion;

    //constructor
    public Episode (String titulo, int duracion){
        this.titulo = titulo;
        this.duracion = duracion;

    }

    //metodos
    public void procesar(){
        System.out.println("Iniciando procesamiento de: " + this.titulo + "...");

        try {
            Thread.sleep(2000);
             } catch (InterruptedException e) {
            System.out.println("Error al procesar episodio");
        }
        System.out.println("Completado" + this.titulo);
        }
    }
    
