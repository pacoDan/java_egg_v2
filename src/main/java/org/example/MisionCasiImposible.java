package org.example;

import java.util.ArrayList;
import java.util.List;

public class MisionCasiImposible extends Mision {

    List<String> accionesRequeridas;

    public MisionCasiImposible(String nombre, String dificultad, int puntosEXdeRecompensa, int minimoPuntosEXrequeridos){
       this.accionesRequeridas=new ArrayList<String>();
       this.nombre=nombre;
       this.dificultad=nombre;
       this.puntosEXdeRecompensa=puntosEXdeRecompensa;
       this.minimoPuntosEXrequeridos=minimoPuntosEXrequeridos;
    }
    public boolean addAccionRequerida(String string) {
        return this.accionesRequeridas.add(string);
    }
    @Override
    public boolean superaMision(Jugador jugador) {
        boolean condicionPuntos = super.superaMision(jugador);
        if(condicionPuntos==false) return false;

        boolean completoAccionesRequeridas=this.accionesRequeridas.containsAll(jugador.getAccionesRealizadas(;
        if(completoAccionesRequeridas==false){
            int cantidadDeAccionesPorCumplir=this.accionesRequeridas.size()-jugador.getAccionesRealizadas().size();
            int cantidadDeMisionesSuperadasPorElJugador=jugador.getMisionesSuperadas();
            completoAccionesRequeridas=cantidadDeAccionesPorCumplir<cantidadDeMisionesSuperadasPorElJugador;
        }
       return  completoAccionesRequeridas;
    }

}
