package Logica;
import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * SarumParadas.java
 *
 * Created on 26/04/2011, 01:06:56 PM
 */
/**
 * Permite mantener la informacion de todas la paradas para la aplicacion
 * @author  Miguel Mondragon 
 * @since  1.0
 */
public class SarumParadas {

    private ArrayList<Parada> listaParadas= new ArrayList<Parada>();
    SarumParadas(){}
    private boolean verificarCadena(String paradas)throws Exception{
        int nParadas=paradas.replaceAll("[^#]","").length();
        if(nParadas<3){
            System.err.println("Estacion no creada: "+paradas);
            throw new Exception("Hay una mal formacion en la creacion de una parada");
        }else {
            return true;
        }
    }
    /**
     * Verifica y crea las paradas desde el archivo para ser anexadas como una estacion o paradero valido
     * @param parada
     * @throws Exception
     */
    public void addParada(String parada) throws Exception{
        if(verificarCadena(parada)){
        StringTokenizer tokens = new StringTokenizer(parada,"#");
        listaParadas.add(new Parada(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),tokens.nextToken(),converToPoint(tokens.nextToken())));
        }
    }
    /**
     * Establece la lista de paradas
     * @param listaParadas
     */
    void setListaParadas(ArrayList<Parada> listaParadas) {
        this.listaParadas = listaParadas;
    }
    /**
     * Retorna la lista de paradas
     * @return lista de paradas
     */
    public ArrayList<Parada> getListaParadas() {
        return listaParadas;
    }
    /**
     * Retorna la cantidad de paradas en la aplicacion
     * @return cantidad de paradas
     */
    public int sizeParadas(){
            return listaParadas.size();
    }
    /**
     * Con el numero de la estacion retorna la posicion de esta
     * @param numero
     * @return ubicacion de una estacion
     */
    public Point getPosicion(int numero){
        Point tmp=null;
        for(int i=0;i<listaParadas.size();i++){
            Parada prd=listaParadas.get(i);
                if(prd.getNParada()==numero){
                    tmp= prd.getUbicacion();
                    break;
                }
        }
        return new Point(100+tmp.x,100+tmp.y);
    }
    /**
     * Obtiene una parada dado su numero de indice
     * @param numero
     * @return Parada
     * @see Parada
     * @see Point
     */
    public Parada getParada(int numero){
        Parada prdtmp=null;
        for(int i=0;i<listaParadas.size();i++){
           Parada prd=listaParadas.get(i);
                if(prd.getNParada()==numero){
                    prdtmp=prd;
                    break;
                }
        }
        return prdtmp;
    }
    /**
     * Obtiene una parada dada su ubicacion como un punto
     * @param pnt
     * @return Parada
     * @see Parada
     * @see Point
     */
    public Parada getParada(Point pnt){
        Parada prdtmp=null;
        for(int i=0;i<listaParadas.size();i++){
           Parada prd=listaParadas.get(i);
                if(prd.getUbicacion().x==pnt.x && prd.getUbicacion().y==pnt.y*(-1)){
                    prdtmp=prd;
                    break;
                }
        }
        if(prdtmp==null){
            //System.out.print("\nBuscando optimamente\n");
            prdtmp=calcularOptimo(pnt);
        }
        //System.out.print("\nPRDTMP : "+prdtmp.getNombreParada());
        return prdtmp;
    }
    /**
     * Realiza la transformacion para la graficacion correcta en el plano xy
     * @param nextToken
     * @return
     */
    private Point converToPoint(String nextToken) {
        String [] splittArray = null;
        if (nextToken != null || !nextToken.equalsIgnoreCase("")){
            splittArray = nextToken.split("\\,");
        }
       //Acomodo para las coordenadas - con el (-1) invierte los negativos y los positivos a negativos
       //hacen que en el canvas todo cuadre como el cartesiano
        //System.out.print(Integer.parseInt(splittArray[0])+" , "+Integer.parseInt(splittArray[1])*(-1)+"\n");
       return new Point(Integer.parseInt(splittArray[0]),Integer.parseInt(splittArray[1])*(-1));
    }

    private Parada calcularOptimo(Point pnt) {
        //System.out.print("@109:SarumParadas "+pnt);
        Parada prdtmp = null;
        double distanciaSolucion = java.lang.Double.MAX_VALUE;
        for(int i=0;i<listaParadas.size();i++){
           Parada prd=listaParadas.get(i);
           double distanciaActual = (Math.sqrt(Math.pow(prd.getUbicacion().x - pnt.x, 2) + Math.pow(pnt.y-prd.getUbicacion().y, 2)));
           //System.out.print("\n@115:SarumParadas "+distanciaActual+" : "+distanciaSolucion+" : "+listaParadas.get(i).getNombreParada());
            if (distanciaSolucion > distanciaActual){
                        distanciaSolucion = distanciaActual;
                        prdtmp=prd;
            //System.out.print("\n>>>@119:SarumParadas "+distanciaActual+" : "+listaParadas.get(i).getNombreParada()+" : "+listaParadas.get(i).getUbicacion());
                        //break;
            }
        }
        return prdtmp;
    }
}
