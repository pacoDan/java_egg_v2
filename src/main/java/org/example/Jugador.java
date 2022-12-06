package org.example;

import java.util.Collection;
import java.util.List;

public class Jugador {
    private List<String> accionesRealizadas;
    private int puntosExperienciaAcumulados;
    private List<String> misionesSuperadas;

    public boolean realizoAccion ( String elemento ) {
        return accionesRealizadas.contains ( elemento ) ;
  }

    public int getPuntosExperienciaAcumulados() {
      return this.puntosExperienciaAcumulados;
    }

    public boolean realizoAccionCasiImposible(List<String> misiones){
      return this.accionesRealizadas.contains(mision);
    }

    public List<String> getAccionesRealizadas() {
      return this.accionesRealizadas;
    }

    public int getMisionesSuperadas() {
        return this.misionesSuperadas.size();
    }

    public void incrementarPuntosDeExperiencia(int puntosEXdeRecompensa) {
      //TODO
    }

    public boolean addMisionSuperada(String nombre) {
      //TODO
        return false;
    }
}
