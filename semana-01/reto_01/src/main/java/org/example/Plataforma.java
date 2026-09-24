package org.example;

import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Episode> catalogo = new ArrayList<>();

    public Plataforma(ArrayList catalogo) {
        this.catalogo = new ArrayList<>();
    }

    public void agregarEpisodio(Episode e) {
        catalogo.add(new Episode ("Episodio1" ,50));
        catalogo.add(new Episode ("Episodio2" ,20));
        catalogo.add(new Episode ("Episodio3" ,30));
        catalogo.add(new Episode ("Episodio4" ,40));
        catalogo.add(new Episode ("Episodio5" ,10));
    }
    public void procesarCatalogo() {
        for(Episode e : catalogo) {
            e.procesar();
        }
    }
}