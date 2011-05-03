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
    
    //{{Variables - declaracion
    private SarumParadas fileParadas;
    private ArrayList<Camino> rutas;
    private int padre[];
    private int sumaDistancia[];
    private int tiempo=0;
    private int paradaInicial=-1;
    private int paradaFinal=-1;
    public String salida="";
    private String salidatmp="";
    private boolean visitado[];
   // private SarumRutas fileRutas;
    /**
     * Crea un objeto de tipo Algoritmo ingenuo que realiza los calculos para hallar la solucion
     * @param fileParadas
     */
    public AlgIngenuo(SarumParadas fileParadas){
        this.fileParadas=fileParadas;
        //iniciaLizar();
    }
    /**
     *
     */
    private void iniciaLizar(){
        int numeroParadas=fileParadas.getListaParadas().size()+1;
            padre=new int[numeroParadas];
            sumaDistancia=new int[numeroParadas];
            visitado=new boolean[numeroParadas];
        for(int iniciar=1;iniciar<numeroParadas;iniciar++){
            padre[iniciar]=-1;
            visitado[iniciar]=false;
            sumaDistancia[iniciar]=Integer.MAX_VALUE;
        }
    }
    /**
     * Calcula el algoritmo ingenuo
     * @param origendestino
     */
    public String calcularIngenuo(ArrayList<Point[]> origendestino,ArrayList<Camino> rutas){
        this.rutas=(ArrayList<Camino>) rutas.clone();
        /**for(int s=0;s<rutas.size();s++){
             System.out.println("/"+rutas.get(s).toString());
        }*/
        long startTime=0;
        long endTime=0;
        //iniciado el algortimo
        for(int b=0;b<origendestino.size();b++){
            //System.out.println("\n:"+fileParadas.getParada(origendestino.get(b)[0]).getNombreParada()+" - "+fileParadas.getParada(origendestino.get(b)[1]).getNombreParada());
            paradaInicial=fileParadas.getParada(origendestino.get(b)[0]).getNParada();
            paradaFinal=fileParadas.getParada(origendestino.get(b)[1]).getNParada();
             //System.out.println("De: "+fileParadas.getParada(paradaInicial).getNombreParada()+" a: "+fileParadas.getParada(paradaFinal).getNombreParada()+" : ("+origendestino.get(b)[0].x+","+origendestino.get(b)[0].y+")-("+origendestino.get(b)[1].x+","+origendestino.get(b)[1].y+")");
             salida+="("+origendestino.get(b)[0].x+","+origendestino.get(b)[0].y+")-("+origendestino.get(b)[1].x+","+origendestino.get(b)[1].y+")\n";
             iniciaLizar();
              startTime = System.currentTimeMillis();
             DFSOptimizado(paradaInicial);
              endTime = System.currentTimeMillis();
             limpiarEstado();
        }
        //terminado el algortimo
        System.out.println("T: "+(endTime-startTime));
        return getSalida();
    }
    public void DFSOptimizado(int estacionActual){
            //System.out.println("** DFSOptimizado "+estacionActual);
            visitado[estacionActual]=true;
            Vector<Integer> datVecinos=nAdyacentes(estacionActual);
            for(int vecino=1;vecino<datVecinos.size();vecino++){
                int nVecino=datVecinos.get(vecino);
                int v=Integer.parseInt(this.rutas.get(nVecino).getDestino());
              //  System.out.println("** v "+v);
                if(v>0 && v!=paradaFinal && !visitado[v]){
                    salidatmp+=this.rutas.get(nVecino).toString();
                    tiempo+=Integer.parseInt(this.rutas.get(nVecino).getTiempoRecorrido());
                        padre[v]=estacionActual;
                        DFSOptimizado(v);
                        visitado[v]=true;
                        //System.out.println("*");
                }else if(v>0 && v==paradaFinal && !visitado[v]){
                    //System.out.println("** "+v);
                    salidatmp+=this.rutas.get(nVecino).toString();
                    tiempo+=Integer.parseInt(this.rutas.get(nVecino).getTiempoRecorrido());
                    visitado[v]=true;
                    if(tiempo<sumaDistancia[estacionActual]){
                        sumaDistancia[estacionActual]=tiempo;
                        //System.out.print(sumaDistancia[estacionActual]+" : "+salidatmp+"\n");
                        salida+=salidatmp;
                    }
                    
                    tiempo=0;
                    salidatmp="";
                    break;
                }else if(paradaFinal==paradaInicial){
                    sumaDistancia[estacionActual]=0;
                    //System.err.print("Misma Ubicacion");
                }
            }
        
    }
    private void limpiarEstado(){
        for(int iniciar=1;iniciar<fileParadas.getListaParadas().size()+1;iniciar++){
            visitado[iniciar]=false;
        }
    }
    private Vector<Integer> nAdyacentes(int estacionActual){
            Vector<Integer> nRutas=new Vector<Integer>();
            nRutas.add(0,0);
            for(int hijos=0;hijos<this.rutas.size();hijos++){
                if(this.rutas.get(hijos).getOrigen().equals(estacionActual+"")){
                    int cantidad=Integer.parseInt(nRutas.elementAt(0).toString());
                    nRutas.setElementAt(cantidad+1,0);//cantidad de adyacentes
                    nRutas.add(hijos);//posicion de cada adyacente
                }
            }
            return nRutas;
    }
    
    private void agregaraSalida() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
}
