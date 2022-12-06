package org.example;

import java.util.List;

public class Aventura {
    

     List<Jugador> jugadores;
     List<Mision> misiones;
    public boolean agregarJugador(Jugador jugador){
        boolean yaExistia= jugadores.contains(jugador);  
        if(yaExistia) return false;
        misiones.stream().allMatch(mision -> {
            boolean misionSuperada=jugador.addMisionSuperada(mision.getNombre());
            if(misionSuperada){
                jugador.incrementarPuntosDeExperiencia(mision.getPuntosEXdeRecompensa());
            }   
            return mision.superaMision(jugador) && misionSuperada;
        });
    } 
    
}
