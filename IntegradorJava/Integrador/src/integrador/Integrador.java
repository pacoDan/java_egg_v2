package integrador;

import java.util.ArrayList;

public class Integrador {

    public static void main(String[] args) {
        
        Practica practica = new Practica();
        
        System.out.println( (int) Math.log10(1000)+1);
        
        //Generar las variables necesarias para probar
        //ArrayList<String> medias = new ArrayList(Arrays.asList(new String[]{"A", "B", "C", "D","A", "C", "D", "A"}));

        //System.out.println(practica.mediasAmigas(medias));
        //System.out.println(practica.numeroPalindromo(null));
        //System.out.println(practica.prisioneroDulce(5,10,5));

        Persona p1 = new Persona ( ) ;
        Persona p2 = new Persona ( ) ;
        p1.setNombre ( " Albus Dumbledore " ) ;
        p2.setNombre ( p1.getNombre ( ) ) ;
        System.out.println ( p1.equals ( p2 ) ) ;
        System.out.println ( p1.getNombre ( ) . equals ( p2.getNombre ( ) ) ) ;

        System.out.println("FIN");
        List<String> nombres= new ArrayList<>();
    }
}
