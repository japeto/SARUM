package Algoritmos;
import Logica.*;
import java.awt.Point;
import java.util.*;
import java.util.ArrayList;
/*
 * AlgIngenuo.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Implementa el algoritmo ingenuo, consistente en generar cada alternativa posible, desde cada estacion hallando
 * el itinerario mas acertado 
 * @author Miguel Mondragon 
 * @since  1.0
 * @version 1.4.0
 */
public class AlgIngenuo {
    
    private ArrayList<String> ingenuo;
    private SarumParadas fileParadas;
   // private SarumRutas fileRutas;
    /**
     * Crea un objeto de tipo Algoritmo ingenuo que realiza los calculos para hallar la solucion
     * @param fileParadas
     * @param fileRutas
     */
    public AlgIngenuo(SarumParadas fileParadas){
        this.fileParadas=fileParadas;
        //this.fileRutas=fileRutas;
        ingenuo = new ArrayList<String>();
    }
    /**
     * Calcula el algoritmo ingenuo
     * @param origendestino
     */
    public void calcularIngenuo(ArrayList<Point[]> origendestino,ArrayList<Camino> rutas){
        ArrayList arl=new ArrayList();
        //iniciado el algortimo
        long startTime = System.currentTimeMillis();
        for(int b=0;b<origendestino.size();b++){
            System.out.println("\nObtParadas : "+fileParadas.getParada(origendestino.get(b)[0]).getNombreParada()+" - "+fileParadas.getParada(origendestino.get(b)[1]).getNombreParada());
            Parada pInicial=fileParadas.getParada(origendestino.get(b)[0]);
            Parada pFinal=fileParadas.getParada(origendestino.get(b)[0]);
        }
         //terminado el algortimo
        long endTime = System.currentTimeMillis();
        System.out.println("T: "+(endTime-startTime));
        
    }
    /**
     * Retorna el contenido del archivo de salida del algoritmo ingenuo
     * @return resultado del algoritmo ingenuo
     */
    public ArrayList<String> getIngenuo(){
        return ingenuo;
    }
}
