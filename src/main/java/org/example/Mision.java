package org.example;

public class Mision {
    private String accionesRealizadas;
    protected int puntosEXdeRecompensa;
    protected int minimoPuntosEXrequeridos;
    protected String nombre;
    protected Object dificultad;
   
    public boolean superaMision ( Jugador jugador ) {
        return minimoPuntosEXrequeridos< jugador.getPuntosExperienciaAcumulados() ;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosEXdeRecompensa() {
        return this.puntosEXdeRecompensa;
    }
}
