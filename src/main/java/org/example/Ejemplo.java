package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
    public static  int suma;
    public static int T;
    public static int numAnterior;
    public static int indiceListaPadre;
    public static int indiceListaHija;
    
    public static void main(String[] args) {
        
        List<Integer> L= new ArrayList<Integer>();
        int [] aux={2,6,8,3,5,0,2,6};
        for(int i=0;i<aux.length;i++){
            L.add(aux[i]);
        }

        T=8;
        ArrayList<ArrayList<Integer>> listaDeListas= new ArrayList<ArrayList<Integer>();
        // public static  int suma=0;
        suma=0;
        indiceListaPadre=0;
        L.forEach( (Integer unNumero) -> {
            indiceListaHija=0;
            L.forEach(otroNumero -> {
                if(unNumero+otroNumero==T && indiceListaHija!=indiceListaPadre){ 
                    ArrayList<Integer> listaAux= new ArrayList<Integer>();
                    listaAux.add(unNumero);
                    listaAux.add(otroNumero);
                    listaDeListas.add(listaAux);
                    indiceListaHija++;
                }
            indiceListaPadre++;
            });
        });

        
    }
}
